package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.Domain.User;

import java.util.Collection;

public class UserResponse implements ApplicationResponse {

    private final Collection<User> user;

    public UserResponse(Collection<User> user) {
        this.user = user;
    }

    public Collection<User> getUser() {
        return user;
    }
}
