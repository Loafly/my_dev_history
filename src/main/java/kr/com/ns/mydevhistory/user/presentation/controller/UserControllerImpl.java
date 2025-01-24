package kr.com.ns.mydevhistory.user.presentation.controller;

import kr.com.ns.mydevhistory.user.business.application.UserFacade;
import kr.com.ns.mydevhistory.user.presentation.dto.UserDto;
import kr.com.ns.mydevhistory.user.presentation.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserControllerDoc {

    private final UserFacade userFacade;
    private final UserMapper userMapper;

    @Override
    @GetMapping("/{userId}")
    public UserDto getById(Long userId) {
        return userMapper.toDto(userFacade.getById(userId));
    }
}
