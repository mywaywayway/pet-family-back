package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 申请审核表
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 12:09:50
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("audit")
@ApiModel(value = "AuditEntity对象", description = "申请审核表")
public class AuditEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty("申请状态")
    @TableField("audit_state")
    private String auditState;

    @ApiModelProperty("审核人")
    @TableField("audit_person")
    private String auditPerson;

    @ApiModelProperty("关键标识")
    @TableField("key_word")
    private Integer keyWord;

    @ApiModelProperty("申请人")
    @TableField("applicant")
    private String applicant;

    @ApiModelProperty("申请内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("申请")
    @TableField("application_remark")
    private String applicationRemark;

    @ApiModelProperty("申请人联系方式")
    @TableField("application_phone")
    private String applicationPhone;

    @ApiModelProperty("申请类型")
    @TableField("audit_type")
    private String auditType;


}
