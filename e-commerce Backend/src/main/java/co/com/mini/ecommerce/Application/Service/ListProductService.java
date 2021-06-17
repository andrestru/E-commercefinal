package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.Domain.Product;
import co.com.mini.ecommerce.Application.Model.ListProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;
import co.com.mini.ecommerce.Application.Ports.In.ListProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;

import java.util.Collection;
import java.util.Optional;


public class ListProductService implements ListProductUseCase{

    private final ProductRepository productRepository;

    public ListProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ListProductResponse execute(ListProductRequest request) {
        Collection<Product> products = productRepository.ListProduct();
        return new ListProductResponse(products);
    }

}
