package com.thedustybox.joybuy.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;
/**
 * @author thedustybox
 */
@ToString
@Data
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrs;
}
