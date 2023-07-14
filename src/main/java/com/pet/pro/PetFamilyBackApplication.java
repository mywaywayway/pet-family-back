package com.pet.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pet.pro.mapper")
public class PetFamilyBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetFamilyBackApplication.class, args);
    }

}
