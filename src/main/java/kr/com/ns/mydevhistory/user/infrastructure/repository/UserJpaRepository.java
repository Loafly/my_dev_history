package kr.com.ns.mydevhistory.user.infrastructure.repository;

import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
