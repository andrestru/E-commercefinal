package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.NonEmptyName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void User(){
        String email = "";

        String pass = " ";

        Executable operation = () -> new User(new NonEmptyName(email),new NonEmptyName(pass));

        assertThrows(IllegalArgumentException.class, operation);

    }

    @Test
    void _UserNull(){

        Executable operation = () -> new User(new NonEmptyName(null),new NonEmptyName(null));

        assertThrows(NullPointerException.class, operation);

    }

}