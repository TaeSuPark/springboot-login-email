package com.plass.sub.springboot.web.dto;

import lombok.Data;

@Data
public class SignUpDto {

    private String email;
    private String name;
    private String password;
    private String phone;

}
