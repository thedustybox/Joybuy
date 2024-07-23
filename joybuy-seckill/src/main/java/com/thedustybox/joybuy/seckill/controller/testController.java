package com.thedustybox.joybuy.seckill.controller;

import com.thedustybox.joybuy.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @GetMapping(value = "/test")
    @ResponseBody
    public R getSkuSeckilInfo() {

        String to = "test";

        return R.ok().setData(to);
    }

}
