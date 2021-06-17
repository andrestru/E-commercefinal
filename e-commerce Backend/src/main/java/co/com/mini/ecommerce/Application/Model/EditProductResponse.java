package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Application.Domain.Product;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;

public class EditProductResponse implements ApplicationResponse {

    private final Product product;

    public EditProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "EditProductResponse{" +
                "product=" + product +
                '}';
    }
}
