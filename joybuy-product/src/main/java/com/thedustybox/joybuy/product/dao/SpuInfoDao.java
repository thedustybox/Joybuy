package com.thedustybox.joybuy.product.dao;

import com.thedustybox.joybuy.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * spu信息
 * 
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:20
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    void updateSpuState(@Param("spuId") Long spuId, @Param("code") int code);
}
