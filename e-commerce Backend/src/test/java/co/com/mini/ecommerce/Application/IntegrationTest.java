package co.com.mini.ecommerce.Application;

import co.com.mini.ecommerce.Application.Model.CreateProductRequest;
import co.com.mini.ecommerce.Infrastructure.Adapters.In.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    private ProductController productController;

    @Test
    void Product() {
        final int id = 123;
        CreateProductRequest createProductRequest = new CreateProductRequest(
                id,
                "name",
                "description",
                1000,
                0.2,
                "Published",
                5
        );

        productController.CreateProduct(createProductRequest);

        assertDoesNotThrow(() -> productController);
    }
}
