package co.com.mini.ecommerce.Application.Domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CheckPriceTest {

    @Test
    void checkPrice(){

        double price = -1000;

        Executable operation = () -> new CheckPrice(price);

        assertThrows(IllegalArgumentException.class, operation);

    }


}