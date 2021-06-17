package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Application.Domain.User;
import co.com.mini.ecommerce.Application.Errors.InputDataError;
import co.com.mini.ecommerce.Application.Model.UserRequest;
import co.com.mini.ecommerce.Application.Model.UserResponse;
import co.com.mini.ecommerce.Application.Ports.In.UserUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.UserRepository;

import java.util.Collection;

public class LoginUserService implements UserUseCase {

    private final UserRepository userRepository;

    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse execute(UserRequest request) {
            User user = Validate(request);
            Collection<User> users = userRepository.ListUser(user);
            return new UserResponse(users);
    }

    private User Validate(UserRequest request){
        try{
            NonEmptyName email = new NonEmptyName(request.getEmail());
            NonEmptyName password = new NonEmptyName(request.getPassword());
            return new User(
                    email,
                   password
            );
        }catch (Exception e){
            throw new InputDataError(e.getMessage());
        }
    }
}
