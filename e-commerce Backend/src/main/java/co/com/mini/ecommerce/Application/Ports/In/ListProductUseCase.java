package co.com.mini.ecommerce.Application.Ports.In;

import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.Model.ListProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductResponse;

public interface ListProductUseCase extends ApplicationUseCase<ListProductRequest, ListProductResponse> {
}
