package com.thedustybox.joybuy.product.vo;

import lombok.Data;

import java.util.List;
/**
 * @author thedustybox
 */
@Data
public class SkuItemSaleAttrVo {
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuIdVo> attrValues;
}
