package com.thedustybox.joybuy.order.dao;

import com.thedustybox.joybuy.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单
 * 
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    /**
     * 修改订单状态
     * @param orderSn
     * @param code
     * @param payType
     */
    void updateOrderStatus(@Param("orderSn") String orderSn,
                           @Param("code") Integer code,
                           @Param("payType") Integer payType);
}
