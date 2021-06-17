package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Application.Model.CreateProductResponse;
import co.com.mini.ecommerce.Application.Model.IdProductRequest;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface EditInventoryUseCase extends ApplicationUseCase<IdProductRequest, CreateProductResponse> {
}
