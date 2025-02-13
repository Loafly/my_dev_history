package kr.com.ns.mydevhistory.user.business.domain.service;

import kr.com.ns.mydevhistory.common.exception.ApiException;
import kr.com.ns.mydevhistory.common.exception.ErrorCode;
import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import kr.com.ns.mydevhistory.user.business.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    }

    public User getDetailById(Long id) {
        return userRepository.findFetchById(id).orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    }
}
