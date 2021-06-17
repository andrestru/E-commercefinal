package co.com.mini.ecommerce.Application.Domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdentificationNumberTest {

    @Test
    void Identification(){

        int id = 0;

        Executable operation = () -> new IdentificationNumber(id);

        assertThrows(IllegalArgumentException.class, operation);

    }

}