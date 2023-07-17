package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 地址信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:08:11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_total_info_view")
@ApiModel(value = "AddressInfoEntity对象", description = "地址信息")
public class UserTotalInfoViewEntity {

    @ApiModelProperty("地址编号")
    private Integer addressId;

    @ApiModelProperty("用户编号")
    private Integer userId;

    @ApiModelProperty("联系人")
    private String linkman;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("联系人电话")
    private String linkmanPhone;

    @ApiModelProperty("具体地址")
    private String detailAddress;

    @ApiModelProperty("登录编号")
    private Integer loginId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("头像")
    private String avatar;

    private String email;

    private String grade;

    @ApiModelProperty("生日")
    private String birthday;





}
