package co.com.mini.ecommerce.Application.Domain;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CheckTaxRateTest {


    @ParameterizedTest
    @ValueSource(doubles = {
            0,
            0.1,
            0.2,
            0.3,
            0.4,
            0.5,
            0.6,
            0.7,
            0.8,
            0.9,
            1
    })
    void checkTax(double tax){

        Executable operation = () -> new CheckTaxRate(tax);

        assertDoesNotThrow(operation);
    }

}