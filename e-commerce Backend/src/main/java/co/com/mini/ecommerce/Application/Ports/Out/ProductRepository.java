package co.com.mini.ecommerce.Application.Ports.Out;

import co.com.mini.ecommerce.Application.Domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.Domain.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> GetProductId(IdentificationNumber identificationNumber);

    void SavaProduct(Product product);

    Collection<Product> ListProduct();

    void delete(int id);

    Collection<Product> GetId(IdentificationNumber identificationNumber);

    void EditProduct(Product product);

    void EditInventory(int id);

}
