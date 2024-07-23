package com.thedustybox.joybuy.product.service;

import com.thedustybox.joybuy.product.vo.SpuSaveVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:20
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savaSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);

    SpuInfoEntity getSpuInfoBySkuId(Long skuId);
}

