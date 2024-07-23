package com.thedustybox.joybuy.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author thedustybox
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
