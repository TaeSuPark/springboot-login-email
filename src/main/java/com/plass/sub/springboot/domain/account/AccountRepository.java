package com.plass.sub.springboot.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

// mybatis에서의 Dao 역할
// JPA 사용한 Database 관련 코드 -> 참고하지 않아도 됨
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

}
