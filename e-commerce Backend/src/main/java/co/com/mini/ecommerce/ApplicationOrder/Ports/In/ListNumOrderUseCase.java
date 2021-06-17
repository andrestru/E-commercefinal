package co.com.mini.ecommerce.ApplicationOrder.Ports.In;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListNumOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface ListNumOrderUseCase extends ApplicationUseCase<ListNumOrderRequest, ListOrderResponse> {
}
