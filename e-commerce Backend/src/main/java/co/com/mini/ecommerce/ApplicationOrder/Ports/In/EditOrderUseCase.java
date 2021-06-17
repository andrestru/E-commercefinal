package co.com.mini.ecommerce.ApplicationOrder.Ports.In;

import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

public interface EditOrderUseCase extends ApplicationUseCase<EditOrderRequest, EditOrderResponse> {
}
