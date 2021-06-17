package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Model.IdProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IdProductServiceTest {

    @Test
    void IdProduct() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        IdProductService idProductService = new IdProductService(productRepository);

        final int id = 2;
        IdProductRequest idProductRequest = new IdProductRequest(id);

        ListProductResponse listProductResponse = idProductService.execute(idProductRequest);

        assertDoesNotThrow(()->idProductService.execute(idProductRequest));

    }

}