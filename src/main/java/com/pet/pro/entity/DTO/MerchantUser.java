package com.pet.pro.entity.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/12
 */
@Data
public class MerchantUser {
    private Integer merchantUserId;

    private String merchantName;

    private String merchantAddress;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("邮箱")
    private String email;

}
