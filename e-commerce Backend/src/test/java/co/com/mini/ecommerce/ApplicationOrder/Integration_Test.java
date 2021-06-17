package co.com.mini.ecommerce.ApplicationOrder;

import co.com.mini.ecommerce.Application.Model.UserRequest;
import co.com.mini.ecommerce.Infrastructure.Adapters.In.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class Integration_Test {

    @Autowired
    private UserController userController;

    @Test
    void User(){
        UserRequest userRequest = new UserRequest(
                "andrestrujillo@gmail.com",
                "123456"
        );

        userController.responseEntity(userRequest);

        assertDoesNotThrow(()->userController);
    }


}
