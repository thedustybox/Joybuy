package com.thedustybox.joybuy.order.feign;

import org.springframework.cloud.openfeign.FeignClient;


/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
@FeignClient("gulimall-third-party")
public interface ThridFeignService {

//    @GetMapping(value = "/pay",consumes = "application/json")
//    String pay(@RequestBody PayVo vo) throws AlipayApiException;

}
