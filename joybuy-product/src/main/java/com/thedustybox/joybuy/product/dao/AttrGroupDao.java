package com.thedustybox.joybuy.product.dao;

import com.thedustybox.joybuy.product.entity.AttrGroupEntity;
import com.thedustybox.joybuy.product.vo.SpuItemAttrGroupVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 属性分组
 * 
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:20
 */
@Mapper
public interface AttrGroupDao extends BaseMapper<AttrGroupEntity> {

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(@Param("spuId") Long spuId, @Param("catalogId") Long catalogId);
}
