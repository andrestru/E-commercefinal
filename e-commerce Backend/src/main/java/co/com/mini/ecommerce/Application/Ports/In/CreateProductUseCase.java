package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.Model.CreateProductRequest;
import co.com.mini.ecommerce.Application.Model.CreateProductResponse;

public interface CreateProductUseCase extends ApplicationUseCase<CreateProductRequest, CreateProductResponse> {
}
