package com.thedustybox.joybuy.product.feign;

import com.thedustybox.joybuy.common.to.SkuReductionTo;
import com.thedustybox.joybuy.common.to.SpuBoundTo;
import com.thedustybox.joybuy.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("joybuy-coupon")
public interface CouponFeignService {


    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);

    @RequestMapping("/coupon/coupon/test1")
    R test1();
}
