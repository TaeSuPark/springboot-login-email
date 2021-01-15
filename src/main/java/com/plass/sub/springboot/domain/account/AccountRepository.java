package com.plass.sub.springboot.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
// mybatis에서의 Dao 역할
public interface AccountRepository extends JpaRepository<Account, Long> {
}
