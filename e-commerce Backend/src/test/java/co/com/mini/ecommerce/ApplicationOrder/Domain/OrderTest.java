package co.com.mini.ecommerce.ApplicationOrder.Domain;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void OrderNull(){
        int id = 0;
        double total = -1;
        Executable operation = () -> new Order(new NonEmptyString(null), new NonEmptyName(null), new NonEmptyString(null),
                new CCNumber(id), new NonEmptyString(null), new NonEmptyString(null), new CheckPrice(total));

        assertThrows(NullPointerException.class, operation);
    }

    @Test
    void OrderEmpty(){
        int id = 0;
        double total = -1;
        String numOrder = " ";
        String name = "";
        String address = " ";
        String status = "";
        String description = " ";
        Executable operation = () -> new Order(new NonEmptyString(numOrder), new NonEmptyName(name), new NonEmptyString(address),
                new CCNumber(id), new NonEmptyString(status), new NonEmptyString(description), new CheckPrice(total));

        assertThrows(IllegalArgumentException.class, operation);
    }

}