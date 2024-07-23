package com.thedustybox.joybuy.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author thedustybox
 */
@Data
public class PurchaseDoneVo {

    @NotNull(message = "id不允许为空")
    private Long id;

    private List<PurchaseItemDoneVo> items;

}
