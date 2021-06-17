package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Model.EditProductRequest;
import co.com.mini.ecommerce.Application.Model.EditProductResponse;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EditProductServiceTest {

    @Test
    void Edit(){
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        EditProductService editProductService = new EditProductService(productRepository);

        EditProductRequest editProductRequest = new EditProductRequest(
                123,
                "name",
                "description",
                1000,
                0.2,
                "Published",
                5
        );

        final int id = 123;
        EditProductResponse editProductResponse = editProductService.execute(editProductRequest);

        assertAll(
                ()->assertEquals(
                        editProductResponse.getProduct().getIdentificationNumber().getIdentification(),
                        id
                ),
                () -> assertDoesNotThrow(()-> editProductService.execute(editProductRequest))
        );
    }

}