package co.com.mini.ecommerce.ApplicationOrder.Ports.In;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListCCOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface ListCCOrderUseCase extends ApplicationUseCase<ListCCOrderRequest, ListOrderResponse> {
}
