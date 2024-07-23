package com.thedustybox.joybuy.ware.vo;

import lombok.Data;


/**
 * @author thedustybox
 */
@Data
public class PurchaseItemDoneVo {

    private Long itemId;

    private Integer status;

    private String reason;

}
