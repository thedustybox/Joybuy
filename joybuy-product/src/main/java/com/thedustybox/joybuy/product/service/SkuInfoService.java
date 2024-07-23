package com.thedustybox.joybuy.product.service;

import com.thedustybox.joybuy.product.vo.SkuItemVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.product.entity.SkuInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * sku信息
 *
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:21
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    SkuItemVo item(Long skuId);
}

