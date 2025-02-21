package kr.com.ns.mydevhistory.unit.user.business.domain.service;

import kr.com.ns.mydevhistory.common.exception.ApiException;
import kr.com.ns.mydevhistory.common.exception.ErrorCode;
import kr.com.ns.mydevhistory.user.business.domain.entity.User;
import kr.com.ns.mydevhistory.user.business.domain.repository.UserRepository;
import kr.com.ns.mydevhistory.user.business.domain.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    @DisplayName("유저 조회")
    public class getByIdTest {
        @Test
        void 유저조회_성공() {

            // given
            Long userId = 1L;
            User user = new User();
            ReflectionTestUtils.setField(user, "id", userId);

            // when
            when(userRepository.findById(userId)).thenReturn(Optional.of(user));
            User resultUser = userService.getById(userId);

            // then
            then(userRepository).should().findById(userId);

            assertEquals(userId, resultUser.getId());
        }

        @Test
        void 유저조회_실패_유저가없는경우() {
            // given
            Long userId = 1L;
            User user = new User();
            ReflectionTestUtils.setField(user, "id", userId);

            // when
            when(userRepository.findById(userId)).thenReturn(Optional.empty());
            ApiException apiException = assertThrows(ApiException.class, () -> userService.getById(userId));

            // then
            then(userRepository).should().findById(userId);
            assertEquals(ErrorCode.USER_NOT_FOUND, apiException.getErrorCode());
        }
    }

    @Nested
    @DisplayName("유저 상세 조회")
    public class getDetailByIdTest {
        @Test
        void 유저상세조회_성공() {

            // given
            Long userId = 1L;
            User user = new User();
            ReflectionTestUtils.setField(user, "id", userId);

            // when
            when(userRepository.findFetchById(userId)).thenReturn(Optional.of(user));
            User resultUser = userService.getDetailById(userId);

            // then
            then(userRepository).should().findFetchById(userId);

            assertEquals(userId, resultUser.getId());
        }

        @Test
        void 유저상세조회_실패_유저가없는경우() {
            // given
            Long userId = 1L;
            User user = new User();
            ReflectionTestUtils.setField(user, "id", userId);

            // when
            when(userRepository.findFetchById(userId)).thenReturn(Optional.empty());
            ApiException apiException = assertThrows(ApiException.class, () -> userService.getDetailById(userId));

            // then
            then(userRepository).should().findFetchById(userId);
            assertEquals(ErrorCode.USER_NOT_FOUND, apiException.getErrorCode());
        }
    }
}