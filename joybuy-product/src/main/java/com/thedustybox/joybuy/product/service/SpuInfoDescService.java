package com.thedustybox.joybuy.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:21
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savsSpuInfoDesc(SpuInfoDescEntity descEntity);
}

