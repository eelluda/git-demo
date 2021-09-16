package com.ad.boot_thymeleaf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
