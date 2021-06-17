package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Model.ListProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ListProductServiceTest {

    @Test
    void ListProduct(){
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        ListProductService listProductService = new ListProductService(productRepository);
        ListProductRequest listProductRequest = new ListProductRequest();
        ListProductResponse listProductResponse = listProductService.execute(listProductRequest);
        assertDoesNotThrow(()->listProductService.execute(listProductRequest));
    }

}