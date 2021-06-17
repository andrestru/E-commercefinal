package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.Domain.Product;

public class CreateProductResponse implements ApplicationResponse {

    private final Product product;

    public CreateProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "CreateProductResponse{" +
                "product=" + product +
                '}';
    }
}
