package com.thedustybox.joybuy.member.controller;

import com.thedustybox.joybuy.common.exception.BizCodeEnum;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.member.entity.MemberEntity;
import com.thedustybox.joybuy.member.exception.PhoneException;
import com.thedustybox.joybuy.member.exception.UsernameException;
import com.thedustybox.joybuy.member.feign.CouponFeignService;
import com.thedustybox.joybuy.member.service.MemberService;
import com.thedustybox.joybuy.member.vo.MemberUserLoginVo;
import com.thedustybox.joybuy.member.vo.MemberUserRegisterVo;
import com.thedustybox.joybuy.member.vo.SocialUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 会员
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    CouponFeignService couponFeignService;


    @PostMapping(value = "/oauth2/login")
    public R oauthLogin(@RequestBody SocialUser socialUser) throws Exception {
        MemberEntity memberEntity = memberService.login(socialUser);
        if (memberEntity != null) {
            return R.ok().setData(memberEntity);
        } else {
            return R.error(BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getCode(),BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getMsg());
        }
    }

    @PostMapping(value = "/login")
    public R login(@RequestBody MemberUserLoginVo vo) {
        MemberEntity memberEntity = memberService.login(vo);
        if (memberEntity != null) {
            return R.ok().setData(memberEntity);
        } else {
            return R.error(BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getCode(),BizCodeEnum.LOGIN_ACCOUNT_PASSWORD_INVALID.getMsg());
        }
    }

    
    @PostMapping(value = "/register")
    public R register(@RequestBody MemberUserRegisterVo vo) {
        try {
            memberService.register(vo);
        } catch (PhoneException e) {
            return R.error(BizCodeEnum.PHONE_EXISTS_EXCEPTION.getCode(),BizCodeEnum.PHONE_EXISTS_EXCEPTION.getMsg());
        } catch (UsernameException e) {
            return R.error(BizCodeEnum.USER_EXISTS_EXCEPTION.getCode(),BizCodeEnum.USER_EXISTS_EXCEPTION.getMsg());
        }
        return R.ok();
    }



    @RequestMapping("/coupons")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");

        R membercoupons = couponFeignService.membercoupons();
        return R.ok().put("member",memberEntity).put("coupons",membercoupons.get("coupons"));


    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
