package com.thedustybox.joybuy.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

