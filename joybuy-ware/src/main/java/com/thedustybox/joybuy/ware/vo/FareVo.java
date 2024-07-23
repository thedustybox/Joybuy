package com.thedustybox.joybuy.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author thedustybox
 */
@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;

}


