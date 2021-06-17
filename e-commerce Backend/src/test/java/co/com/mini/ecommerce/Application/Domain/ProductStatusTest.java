package co.com.mini.ecommerce.Application.Domain;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ProductStatusTest {

    @ParameterizedTest
    @ValueSource(strings =  {
            "Rough_copy",
            "Published"
    })
    void Status(String value){
        Executable operation = () -> ProductStatus.valueOf(value);
        assertDoesNotThrow(operation);
    }

}