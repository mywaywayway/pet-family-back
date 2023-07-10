package com.pet.pro;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMPP
@SpringBootApplication
public class PetFamilyBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetFamilyBackApplication.class, args);
    }

}
