package kr.com.ns.mydevhistory.user.presentation.mapper;

import kr.com.ns.mydevhistory.common.mapper.BaseMapper;
import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import kr.com.ns.mydevhistory.user.presentation.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<User, UserDto> {

    protected UserMapper(ModelMapper modelMapper) {
        super(modelMapper, User.class);
        this.registerDtoMapping(UserDto.class);
    }

    public UserDto toDto(User user) {
        return super.toDto(user, UserDto.class);
    }
}