package com.thedustybox.joybuy.product.service;

import com.thedustybox.joybuy.product.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.product.entity.CategoryBrandRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:21
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateBrand(Long brandId, String name);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateCategory(Long catId, String name);

    List<BrandEntity> getBrandsByCatId(Long catId);
}

