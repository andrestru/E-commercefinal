package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Model.UserRequest;
import co.com.mini.ecommerce.Application.Model.UserResponse;
import co.com.mini.ecommerce.Application.Ports.Out.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LoginUserServiceTest {

    @Test
    void Login(){
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        LoginUserService loginUserService = new LoginUserService(userRepository);
        UserRequest userRequest = new UserRequest(
                "maicoltrujillo382@gmail.com",
                "andres123"
        );
        UserResponse userResponse = loginUserService.execute(userRequest);
        assertAll(
                () -> assertDoesNotThrow(()->loginUserService.execute(userRequest))
        );
    }

}