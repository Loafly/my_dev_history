package kr.com.ns.mydevhistory.user.business.application;

import kr.com.ns.mydevhistory.common.annotation.Facade;
import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import kr.com.ns.mydevhistory.user.business.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Facade
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userService.getById(id);
    }

}
