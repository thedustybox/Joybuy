package com.thedustybox.joybuy.order.to;

import com.thedustybox.joybuy.order.entity.OrderEntity;
import com.thedustybox.joybuy.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author thedustybox
 * @email thedustybox@qq.com
 */
@Data
public class OrderCreateTo {

    private OrderEntity order;

    private List<OrderItemEntity> orderItems;

    /** 订单计算的应付价格 **/
    private BigDecimal payPrice;

    /** 运费 **/
    private BigDecimal fare;

}
