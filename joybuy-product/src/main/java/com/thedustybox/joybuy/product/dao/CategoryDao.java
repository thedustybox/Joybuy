package com.thedustybox.joybuy.product.dao;

import com.thedustybox.joybuy.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:20
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
