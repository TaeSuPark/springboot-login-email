package com.plass.sub.springboot.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

// mybatis에서의 Dao 역할
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

}
