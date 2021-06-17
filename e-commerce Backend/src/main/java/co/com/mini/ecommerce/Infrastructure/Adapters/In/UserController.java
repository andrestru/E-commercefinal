package co.com.mini.ecommerce.Infrastructure.Adapters.In;

import co.com.mini.ecommerce.Application.Model.UserRequest;
import co.com.mini.ecommerce.Application.Ports.In.UserUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.UserRepository;
import co.com.mini.ecommerce.Infrastructure.Commons.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final UserUseCase userUseCase;
    private final UserRepository userRepository;

    public UserController(UseCaseHttpExecutor useCaseHttpExecutor, UserUseCase userUseCase, UserRepository userRepository) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.userUseCase = userUseCase;
        this.userRepository = userRepository;
    }

    @PostMapping(path = {"/list"})
    public ResponseEntity responseEntity(
            @RequestBody UserRequest request
            ){
        return useCaseHttpExecutor.execute(
          userUseCase,
          request
        );
    }


}
