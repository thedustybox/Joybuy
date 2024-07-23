package com.thedustybox.joybuy.common.to;

import lombok.Data;

/**
 *
 * @author thedustybox
 */
@Data
public class SkuHasStockTo {
    private Long skuId;
    private Boolean hasStock;
}
