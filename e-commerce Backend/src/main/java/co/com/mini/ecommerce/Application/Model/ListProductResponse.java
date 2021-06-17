package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.Domain.Product;

import java.util.Collection;

public class ListProductResponse implements ApplicationResponse {
    private final Collection<Product> products;

    public ListProductResponse(Collection<Product> products) {
        this.products = products;
    }

    public Collection<Product> getProducts() {
        return products;
    }
}
