package co.com.mini.ecommerce.Application.Domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckInventoryTest {

    @Test
    void InventoryInt(){
      int id = -1;

        Executable operation = () -> new CheckInventory(id);

        assertThrows(IllegalArgumentException.class, operation);

    }




}