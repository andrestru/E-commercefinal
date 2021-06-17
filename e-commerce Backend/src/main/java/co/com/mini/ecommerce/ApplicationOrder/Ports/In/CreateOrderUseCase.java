package co.com.mini.ecommerce.ApplicationOrder.Ports.In;

import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface CreateOrderUseCase extends ApplicationUseCase<CreateOrderRequest, CreateOrderResponse> {
}
