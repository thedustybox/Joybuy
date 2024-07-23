package com.thedustybox.joybuy.auth.feign;


import com.thedustybox.joybuy.auth.vo.MemberUserLoginVo;
import com.thedustybox.joybuy.auth.vo.SocialUser;
import com.thedustybox.joybuy.auth.vo.UserRegisterVo;
import com.thedustybox.joybuy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thedustybox
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {

    @PostMapping("/member/member/register")
    R regist(@RequestBody UserRegisterVo userRegisterVo);

    @PostMapping(value = "/member/member/login")
    R login(@RequestBody MemberUserLoginVo vo);

    @PostMapping("/member/member/oauth2/login")
    R oauth2Login(@RequestBody SocialUser vo) throws Exception;

    @PostMapping(value = "/member/member/weixin/login")
    R weixinLogin(@RequestParam("accessTokenInfo") String accessTokenInfo);


}
