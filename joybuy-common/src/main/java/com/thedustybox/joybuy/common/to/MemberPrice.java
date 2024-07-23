package com.thedustybox.joybuy.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author thedustybox
 */
@Data
public class MemberPrice {
    private Long id;
    private String name;
    private BigDecimal price;
}
