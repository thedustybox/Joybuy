package com.thedustybox.joybuy.product.vo;

import lombok.Data;
/**
 * @author thedustybox
 */
@Data
public class AttrRespVo extends AttrVo{

    private String catelogName;
    private String groupName;
//回显数据使用
    private Long[] catelogPath;
}
