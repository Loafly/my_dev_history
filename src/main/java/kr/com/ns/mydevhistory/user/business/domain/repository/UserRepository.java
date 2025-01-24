package kr.com.ns.mydevhistory.user.business.domain.repository;

import kr.com.ns.mydevhistory.user.business.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);
}
