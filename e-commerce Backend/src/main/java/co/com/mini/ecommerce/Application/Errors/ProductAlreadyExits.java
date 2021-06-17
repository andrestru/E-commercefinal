package co.com.mini.ecommerce.Application.Errors;

import co.com.mini.ecommerce.Common.Errors.ApplicationError;
import co.com.mini.ecommerce.Common.Errors.HttpStatusCode;
import co.com.mini.ecommerce.Application.Domain.IdentificationNumber;

import java.util.Map;

public class ProductAlreadyExits extends ApplicationError {


    private final IdentificationNumber identificationNumber;

    public ProductAlreadyExits(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String getMessage() {
        return "Product with Id: "+identificationNumber+" Already exits.";
    }

    @Override
    public String errorCode() {
        return "PRODUCT_ALREADY_EXITS.";
    }

    @Override
    public HttpStatusCode httpstatuscode() {
        return HttpStatusCode.BAD_REQUEST;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "Identification", identificationNumber
        );
    }
}
