package kr.com.ns.mydevhistory.user.infrastructure.repository;

import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import kr.com.ns.mydevhistory.user.business.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id);
    }
}
