package com.ad.boot_thymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@MapperScan("com.ad.boot_thymeleaf.mapper")
//指定原生servlet组件都放在哪里
@ServletComponentScan(basePackages = "com.ad.boot_thymeleaf")
@SpringBootApplication
public class BootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootThymeleafApplication.class, args);
    }

}
