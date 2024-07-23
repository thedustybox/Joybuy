package com.thedustybox.joybuy.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author thedustybox
 */
@Data
public class MergeVo {

    private Long purchaseId;

    private List<Long> items;

}
