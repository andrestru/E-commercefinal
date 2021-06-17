package co.com.mini.ecommerce.Application.Ports.Out;


import co.com.mini.ecommerce.Application.Domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {


    Collection<User> ListUser(User user);

   // void Login(User user);

}
