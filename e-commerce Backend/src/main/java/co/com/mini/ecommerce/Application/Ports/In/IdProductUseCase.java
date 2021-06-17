package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.Model.IdProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;

public interface IdProductUseCase extends ApplicationUseCase<IdProductRequest, ListProductResponse> {
}
