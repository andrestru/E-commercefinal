package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;

public class User {

    NonEmptyName email;
    NonEmptyName password;

    public User(NonEmptyName email, NonEmptyName password) {
        this.email = email;
       this.password = password;
    }

    public NonEmptyString getEmail() {
        return email;
    }

    public NonEmptyString getPassword() {
      return password;
    }
}
