package kr.com.ns.mydevhistory.user.infrastructure.repository;

import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {
            "userActivities", "userCareers", "userCertificates",
    })
    Optional<User> findFetchById(Long id);
}
