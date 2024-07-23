package com.thedustybox.joybuy.product.service.impl;

import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.common.utils.Query;
import com.thedustybox.joybuy.product.dao.SpuInfoDescDao;
import com.thedustybox.joybuy.product.entity.SpuInfoDescEntity;
import com.thedustybox.joybuy.product.service.SpuInfoDescService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("spuInfoDescService")
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescDao, SpuInfoDescEntity> implements SpuInfoDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoDescEntity> page = this.page(
                new Query<SpuInfoDescEntity>().getPage(params),
                new QueryWrapper<SpuInfoDescEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void savsSpuInfoDesc(SpuInfoDescEntity descEntity) {
        this.baseMapper.insert(descEntity);
    }

}