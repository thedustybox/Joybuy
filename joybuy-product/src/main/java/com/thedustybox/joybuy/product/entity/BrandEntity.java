package com.thedustybox.joybuy.product.entity;

import com.thedustybox.joybuy.common.valid.AddGroup;
import com.thedustybox.joybuy.common.valid.UpdateGroup;
import com.thedustybox.joybuy.common.valid.UpdateStatusGroup;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author thedustybox
 * @email thedustybox@gmail.com
 * @date 2024-06-09 12:27:20
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * 品牌id
//	 */
////	@NotNull(message = "修改必须指定id",groups = {UpdateGroup.class})
////	@Null(message = "新增不能指定id",groups = {AddGroup.class})
//	@TableId
//	private Long brandId;
//	/**
//	 * 品牌名
//	 */
//	//合并方法实现一个功能导致的问题
////	@NotBlank(message = "品牌名必须提交",groups = {AddGroup.class, UpdateGroup.class})
//	private String name;
//	/**
//	 * 品牌logo地址
////	 */
////	@NotEmpty(groups = {AddGroup.class})
////	@URL(message = "loge必须是一个合法的url地址",groups = {AddGroup.class, UpdateGroup.class})
//	private String logo;
//	/**
//	 * 介绍
//	 */
//	private String descript;
//	/**
//	 * 显示状态[0-不显示；1-显示]
//	 */
////	@NotNull(groups = {AddGroup.class, UpdateGroup.class})
////	@ListValue(vals={0,1},groups = {AddGroup.class, UpdateGroup.class})
//	private Integer showStatus;
//	/**
//	 * 检索首字母
//	 */
////	@NotEmpty(groups = {AddGroup.class})
////	@Pattern(regexp = "^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups = {AddGroup.class, UpdateGroup.class})
//	private String firstLetter;
//	/**
//	 * 排序
//	 */
////	@NotNull(groups = {AddGroup.class})
////	@Min(value = 0,message = "排序必须大于等于0")
//	private Integer sort;

	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改必须指定修改id",groups = {UpdateGroup.class})
	@Null(message = "新增不能指定id",groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */

	@NotBlank(message = "品牌名必须提交",groups = {UpdateGroup.class,AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(groups = {AddGroup.class})
//	@URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
//	@ListValue(vals = {0,1},groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotNull(groups = {AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$",message = "检索首字母必须是一个字母",groups = {AddGroup.class, UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */

	@NotNull(groups = {AddGroup.class})
	@Min(value = 0,message = "排序必须大于等于0",groups = {AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
