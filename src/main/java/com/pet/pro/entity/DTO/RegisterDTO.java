package com.pet.pro.entity.DTO;

import com.pet.pro.entity.LoginEntity;
import lombok.Data;

@Data
public class RegisterDTO {
    LoginEntity loginEntity;
    String birthday;
    String regularName;
    String nickname;
    String merchantName;
    String merchantAddress;
}
