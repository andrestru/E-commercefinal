package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.Domain.Product;
import co.com.mini.ecommerce.Application.Model.IdProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;
import co.com.mini.ecommerce.Application.Ports.In.IdProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;

import java.util.Collection;
import java.util.Optional;

public class IdProductService implements IdProductUseCase {

    private final ProductRepository productRepository;

    public IdProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ListProductResponse execute(IdProductRequest request) {
        Collection<Product> products = productRepository.GetId(new IdentificationNumber(request.getId()));
        return new ListProductResponse(products);
    }
}
