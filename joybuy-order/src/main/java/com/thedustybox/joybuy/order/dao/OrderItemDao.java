package com.thedustybox.joybuy.order.dao;

import com.thedustybox.joybuy.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
