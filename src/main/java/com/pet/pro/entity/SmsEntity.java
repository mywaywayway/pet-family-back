package com.pet.pro.entity;

import lombok.Data;

@Data
public class SmsEntity {
    String phone_number;
    String code;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
