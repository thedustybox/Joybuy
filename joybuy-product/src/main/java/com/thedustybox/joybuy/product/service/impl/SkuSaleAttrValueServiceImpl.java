package com.thedustybox.joybuy.product.service.impl;

import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.common.utils.Query;
import com.thedustybox.joybuy.product.dao.SkuSaleAttrValueDao;
import com.thedustybox.joybuy.product.entity.SkuSaleAttrValueEntity;
import com.thedustybox.joybuy.product.service.SkuSaleAttrValueService;
import com.thedustybox.joybuy.product.vo.SkuItemSaleAttrVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("skuSaleAttrValueService")
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueDao, SkuSaleAttrValueEntity> implements SkuSaleAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuSaleAttrValueEntity> page = this.page(
                new Query<SkuSaleAttrValueEntity>().getPage(params),
                new QueryWrapper<SkuSaleAttrValueEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId){
        List<SkuItemSaleAttrVo> saleAttrVos = this.baseMapper.getSaleAttrsBySpuId(spuId);
        return saleAttrVos;
    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId){
        SkuSaleAttrValueDao baseMapper = this.baseMapper;
        List<String> stringList = baseMapper.getSkuSaleAttrValuesAsStringList(skuId);

        return stringList;

    }

}