package com.plass.sub.springboot.web.dto;

import lombok.Data;

@Data // lombok에서 지원하는 @Getter, @Setter 등을 모두 포함한 어노테이션
public class SignUpDto {

    private String email;
    private String name;
    private String password;
    private String phone;

}
