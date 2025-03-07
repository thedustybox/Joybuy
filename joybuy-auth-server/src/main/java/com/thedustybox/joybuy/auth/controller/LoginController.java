package com.thedustybox.joybuy.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.thedustybox.joybuy.auth.feign.MemberFeignService;
import com.thedustybox.joybuy.auth.feign.ThirdPartyFeignService;
import com.thedustybox.joybuy.auth.vo.MemberUserLoginVo;
import com.thedustybox.joybuy.auth.vo.UserLoginVo;
import com.thedustybox.joybuy.auth.vo.UserRegisterVo;
import com.thedustybox.joybuy.common.constant.AuthServerConstant;
import com.thedustybox.joybuy.common.exception.BizCodeEnum;
import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.common.vo.MemberRespVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.thedustybox.joybuy.common.constant.AuthServerConstant.SESSION_LOGIN_KEY;

/**
 * @author thedustybox
 */
@Controller
public class LoginController {
    @Autowired
    private ThirdPartyFeignService feignService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private MemberFeignService memberFeignService;



    @GetMapping("/sms/sendCode")
    @ResponseBody
    public R sendCode(@RequestParam("phone") String phone){
        //1、接口防刷
        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (StringUtils.isNotBlank(redisCode)){
            //redis存的时间戳
            long l = Long.parseLong(redisCode.split("_")[1]);
            if (System.currentTimeMillis() - l < 60000){
                //1分钟内已给这个手机号发过短信，不能在发
                return R.error(BizCodeEnum.SMS_CODE_EXCEPTION.getCode(),BizCodeEnum.SMS_CODE_EXCEPTION.getMsg());
            }
        }
        //2、验证码再次校验，存redis ,key=phone,value=code
//        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5);字母不可以
        String code = ((Double) (Math.random() * 100000)).toString().substring(0, 5);
        //redis中存储的验证码+时间戳
        String redisValue = code +"_"+System.currentTimeMillis();
        //redis缓存验证码，防止同一个手机号再次发送验证码
        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX+phone,redisValue,10, TimeUnit.MINUTES);
        //远程调用实现验证码的发送
        feignService.sendCode(phone,code);
        return R.ok();
    }

    /**
     *
     * @param vo
     * @param result 利用session原理，将数据放在session中，只要跳到下一个页面的取出这个数据以后，session里面的数据就会被删掉
     * @param redirectAttributes: 模拟重定向携带数据
     * @return
     */
    @PostMapping("/register")
    public String register(@Valid UserRegisterVo vo, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            //校验出错，转发到注册页
            Map<String, String> map = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            redirectAttributes.addFlashAttribute("errors",map);
            return "redirect:http://auth.gulimall.com/reg.html";
        }
        //真正注册，调用远程服务注册
        //1、校验验证码
        String code = vo.getCode();
        String s = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
        if (StringUtils.isNotBlank(s)){
            if (code.equals(s.split("_")[0])){
                //删除验证码;令牌机制
//                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
                //验证码校验通过,真正注册，调用远程服务注册
//                MemberUserRegisterVo memberUserRegisterVo = new MemberUserRegisterVo();
//                BeanUtils.copyProperties(memberUserRegisterVo,vo);
                R r = memberFeignService.regist(vo);
                if (r.getCode()==0){
                    //成功,转到登录页
                    return "redirect:http://auth.gulimall.com/login.html";
                }else{
                    Map<String,Object> map = new HashMap<>();
                    map.put("msg",r.get("msg"));
                    System.out.println(map);
                    redirectAttributes.addFlashAttribute("errors",map);
                    return "redirect:http://auth.gulimall.com/reg.html";
                }
            }else {
                Map<String,Object> map = new HashMap<>();
                map.put("code","验证码输入错误");
                redirectAttributes.addFlashAttribute("errors",map);
                //校验出错，转发到注册页
                return "redirect:http://auth.gulimall.com/reg.html";
            }
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("code","验证码输入错误");
            redirectAttributes.addFlashAttribute("errors",map);
            //校验出错，转发到注册页
            return "redirect:http://auth.gulimall.com/reg.html";
        }
    }
    @PostMapping("/login")
    public String login(UserLoginVo vo, RedirectAttributes redirectAttributes, HttpSession session){
        //远程登录
        MemberUserLoginVo memberUserLoginVo = new MemberUserLoginVo();
        memberUserLoginVo.setLoginacct(vo.getLoginAccount());
        memberUserLoginVo.setPassword(vo.getPassWord());

        R r = memberFeignService.login(memberUserLoginVo);
        if (r.getCode()==0){
            MemberRespVo data = r.getData(new TypeReference<MemberRespVo>() {
            });
            session.setAttribute(SESSION_LOGIN_KEY,data);
            //登录成功
            return "redirect:http://gulimall.com";
        }else{
            Map<String,String> errors = new HashMap<>();
            errors.put("msg",r.getData("msg",new TypeReference<String>(){}));
            redirectAttributes.addFlashAttribute("errors",errors);
            //远程调用错误
            return "redirect:http://auth.gulimall.com/login.html";
        }
    }



    @GetMapping("/login.html")
    public String loginPage(HttpSession session){
        Object attribute = session.getAttribute(SESSION_LOGIN_KEY);
        if (attribute == null){
            //没登录去登录页
            return "login";
        }else {
            //已登录去首页
            return "redirect:http://gulimall.com";
        }
    }

    @GetMapping(value = "/loguot.html")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_LOGIN_KEY);
        request.getSession().invalidate();
        return "redirect:http://gulimall.com";
    }

}
