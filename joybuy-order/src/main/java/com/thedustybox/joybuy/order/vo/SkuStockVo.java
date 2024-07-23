package com.thedustybox.joybuy.order.vo;

import lombok.Data;

/**
 * @Description: 库存vo
 * @Created: with IntelliJ IDEA.
 * @author: thedustybox
 * @createTime: 2024-07-03 18:13
 **/

@Data
public class SkuStockVo {


    private Long skuId;

    private Boolean hasStock;

}
