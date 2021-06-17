package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @Test
    void ProductEmpty(){
        int id = -3;
        String name = " ";
        String description = " ";
        double price = -1.000;
        double tax = 1.1;
        String status = " ";
        int inventory = -1;
        Executable operation = ()-> new Product(new IdentificationNumber(id), new NonEmptyName(name), new NonEmptyDescription(description),
                new CheckPrice(price), new CheckTaxRate(tax), ProductStatus.valueOf(status), new CheckInventory(inventory));

        assertThrows(IllegalArgumentException.class, operation);
    }

    @Test
    void ProductNull(){
        int id = -3;
        double price = -1.000;
        double tax = 1.1;
        int inventory = -1;
        Executable operation = ()-> new Product(new IdentificationNumber(id), new NonEmptyName(null), new NonEmptyDescription(null),
                new CheckPrice(price), new CheckTaxRate(tax), ProductStatus.valueOf(null), new CheckInventory(inventory));

        assertThrows(IllegalArgumentException.class, operation);
    }


}