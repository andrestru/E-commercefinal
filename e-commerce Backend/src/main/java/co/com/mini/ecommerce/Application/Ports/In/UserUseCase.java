package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.Model.UserRequest;
import co.com.mini.ecommerce.Application.Model.UserResponse;

public interface UserUseCase extends ApplicationUseCase<UserRequest, UserResponse> {
}
