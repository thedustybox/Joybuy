package com.thedustybox.joybuy.order.feign;

import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
@FeignClient("gulimall-cart")
public interface CartFeignService {

    /**
     * 查询当前用户购物车选中的商品项
     * @return
     */
    @GetMapping(value = "/currentUserCartItems")
    List<OrderItemVo> getCurrentCartItems();


    @RequestMapping("/cart/test1")
    R test1();

}
