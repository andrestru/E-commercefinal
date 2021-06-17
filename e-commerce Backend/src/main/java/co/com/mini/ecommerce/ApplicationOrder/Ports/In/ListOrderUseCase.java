package co.com.mini.ecommerce.ApplicationOrder.Ports.In;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface ListOrderUseCase extends ApplicationUseCase<ListOrderRequest, ListOrderResponse> {
}
