package com.thedustybox.joybuy.thirdparty.controller;

import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.thirdparty.component.SmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thedustybox
 */
@RestController
@RequestMapping("/sms")
public class SmsSendController {
    @Autowired
    private SmsComponent smsComponent;
    /**
     * 提供给别的服务调用
     * @param phone
     * @param code
     * @return
     */
    @GetMapping("/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code){
//    public R sendCode(@RequestParam("phone") String phone){
        smsComponent.sengSmsCode(phone,code);
        return R.ok();
    }
}
