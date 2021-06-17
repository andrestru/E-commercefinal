package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Application.Model.EditProductRequest;
import co.com.mini.ecommerce.Application.Model.EditProductResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface EditProductUseCase extends ApplicationUseCase<EditProductRequest, EditProductResponse> {
}
