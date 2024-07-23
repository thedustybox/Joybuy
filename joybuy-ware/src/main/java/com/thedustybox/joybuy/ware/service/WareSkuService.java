package com.thedustybox.joybuy.ware.service;

import com.thedustybox.joybuy.common.to.OrderTo;
import com.thedustybox.joybuy.common.to.mq.StockLockedTo;
import com.thedustybox.joybuy.common.utils.PageUtils;
import com.thedustybox.joybuy.ware.entity.WareSkuEntity;
import com.thedustybox.joybuy.ware.vo.SkuHasStockVo;
import com.thedustybox.joybuy.ware.vo.WareSkuLockVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author zhengshenhao
 * @email zhengshenhao@gmail.com
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

//    Long lockSkuStock(@Param("skuId") Long skuId, @Param("wareId") Long wareId, @Param("num") Integer num);


    boolean orderLockStock(WareSkuLockVo vo);

    void unlockStock(StockLockedTo to);

    void unlockStock(OrderTo to);
}

