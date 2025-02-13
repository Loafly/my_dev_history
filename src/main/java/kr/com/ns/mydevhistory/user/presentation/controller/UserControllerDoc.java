package kr.com.ns.mydevhistory.user.presentation.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kr.com.ns.mydevhistory.user.presentation.dto.UserDto;
import org.springdoc.core.annotations.ParameterObject;

@Tag(name = "User", description = "User API")
public interface UserControllerDoc {

    UserDto getById(@ParameterObject Long userId);

    UserDto.DetailResponse getDetailById(@ParameterObject Long userId);
}
