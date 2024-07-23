package com.thedustybox.joybuy.auth.feign;

import com.thedustybox.joybuy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thedustybox
 */
@FeignClient("gulimall-third-party")
public interface ThirdPartyFeignService {
    @GetMapping("/sms/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
//    public R sendCode(@RequestParam("phone") String phone);
}
