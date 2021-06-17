package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Domain.*;
import co.com.mini.ecommerce.Application.Errors.ProductAlreadyExits;
import co.com.mini.ecommerce.Application.Model.CreateProductRequest;
import co.com.mini.ecommerce.Application.Model.CreateProductResponse;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreateProductServiceTest {

    @Test
    void IfProductIsPresented(){
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.GetProductId(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.empty());
        CreateProductService createProductService = new CreateProductService(productRepository);

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

        CreateProductResponse createProductResponse = createProductService.execute(createProductRequest);

        assertAll(
                () -> assertDoesNotThrow(()->  createProductService.execute(createProductRequest)),
                () -> assertEquals(
                        createProductResponse.getProduct().getIdentificationNumber().getIdentification(),
                        id
                )
        );
    }

    @Test
    void ProductException(){
        Product product = new Product(
                new IdentificationNumber(123),
                new NonEmptyName("name"),
                new NonEmptyDescription("description"),
                new CheckPrice(1.000),
                new CheckTaxRate(0.2),
                ProductStatus.Rough_copy,
                new CheckInventory(6)
        );
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(productRepository.GetProductId(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.of(product));
        CreateProductService createProductService = new CreateProductService(productRepository);

        CreateProductRequest createProductRequest = new CreateProductRequest(
                product.getIdentificationNumber().getIdentification(),
                product.getName().getValue(),
                product.getDescription().getValue(),
                product.getBase_Price().getValue(),
                product.getTax_Rate().getValue(),
                product.getProductstatus().name(),
                product.getInventory().getValue()
        );

      assertAll(
              () -> assertThrows(ProductAlreadyExits.class, ()->createProductService.execute(createProductRequest)),
              () -> Mockito.verify(productRepository, Mockito.times(0)).SavaProduct(ArgumentMatchers.any(Product.class))
      );
    }

}