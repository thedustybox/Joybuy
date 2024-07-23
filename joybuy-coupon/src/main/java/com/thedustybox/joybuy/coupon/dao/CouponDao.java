package com.thedustybox.joybuy.coupon.dao;

import com.thedustybox.joybuy.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 19:41:31
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
