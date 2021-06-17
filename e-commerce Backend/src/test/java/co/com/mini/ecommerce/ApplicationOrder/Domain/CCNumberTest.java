package co.com.mini.ecommerce.ApplicationOrder.Domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CCNumberTest {

    @Test
    void CC(){
        int id = 0;
        Executable operation = () -> new CCNumber(id);
        assertThrows(IllegalArgumentException.class, operation);
    }

}