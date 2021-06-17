package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Application.Domain.*;
import co.com.mini.ecommerce.Application.Errors.InputDataError;
import co.com.mini.ecommerce.Application.Errors.ProductAlreadyExits;
import co.com.mini.ecommerce.Application.Model.CreateProductRequest;
import co.com.mini.ecommerce.Application.Model.CreateProductResponse;
import co.com.mini.ecommerce.Application.Ports.In.CreateProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;

import java.util.Optional;

public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public CreateProductResponse execute(CreateProductRequest request) {
        Product product = ValidateProduct(request);
        Optional<Product> Productid = productRepository.GetProductId(product.getIdentificationNumber());
        if(Productid.isPresent()){
            throw new ProductAlreadyExits(product.getIdentificationNumber());
        }

        productRepository.SavaProduct(product);
        return new CreateProductResponse(product);
    }

    private Product ValidateProduct(CreateProductRequest request){
        try{
            IdentificationNumber identificationNumber = new IdentificationNumber(request.getIdentificationNumber());
            NonEmptyName name = new NonEmptyName(request.getName());
            NonEmptyDescription description = new NonEmptyDescription(request.getDescription());
            CheckPrice base_price = new CheckPrice(request.getBase_Price());
            CheckTaxRate tax_rate = new CheckTaxRate(request.getTax_Rate());
            ProductStatus product_status = ProductStatus.valueOf(request.getProductstatus());
            CheckInventory quantity = new CheckInventory(request.getInventory());

            return new Product(
                    identificationNumber,
                    name,
                    description,
                    base_price,
                    tax_rate,
                    product_status,
                    quantity
            );
        } catch (Exception e) {
            throw new InputDataError(e.getMessage());
        }
    }
}
