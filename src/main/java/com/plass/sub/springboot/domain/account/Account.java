package com.plass.sub.springboot.domain.account;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// JPA 사용한 Database 관련 코드 -> 참고하지 않아도 됨
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


    @Builder
    public Account(String email, String name, String password, String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }
}
