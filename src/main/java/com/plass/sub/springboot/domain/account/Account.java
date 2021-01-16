package com.plass.sub.springboot.domain.account;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(unique = true)
    private String phone;

    //이메일 인증 여부 확인
    private boolean emailVerified;
    //이메일 토큰
    private String emailCheckToken;

    @Builder
    public Account(String email, String name, String password, String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }
}
