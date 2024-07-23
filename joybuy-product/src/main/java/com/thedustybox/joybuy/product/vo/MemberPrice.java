/**
  * Copyright 2023 bejson.com 
  */
package com.thedustybox.joybuy.product.vo;

import lombok.Data;

import java.math.BigDecimal;



@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}