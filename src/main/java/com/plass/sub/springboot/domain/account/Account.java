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
    private String nickname;

    private String password;

    //이메일 인증 여부 확인
    private boolean emailVerified;
    //이메일 토큰
    private String emailCheckToken;

    @Builder
    public Account(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
    }
}
