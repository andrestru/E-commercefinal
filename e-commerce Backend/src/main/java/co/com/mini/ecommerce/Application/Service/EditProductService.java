package co.com.mini.ecommerce.Application.Service;

import co.com.mini.ecommerce.Application.Domain.*;
import co.com.mini.ecommerce.Application.Errors.InputDataError;
import co.com.mini.ecommerce.Application.Model.EditProductRequest;
import co.com.mini.ecommerce.Application.Model.EditProductResponse;
import co.com.mini.ecommerce.Application.Ports.In.EditProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import co.com.mini.ecommerce.Common.NonEmptyDescription;
import co.com.mini.ecommerce.Common.NonEmptyName;

public class EditProductService implements EditProductUseCase {

    private final ProductRepository productRepository;

    public EditProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public EditProductResponse execute(EditProductRequest request) {
        Product product = ValidateProductEdit(request);
        productRepository.EditProduct(product);
        return new EditProductResponse(product);
    }


    private Product ValidateProductEdit(EditProductRequest request){
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
