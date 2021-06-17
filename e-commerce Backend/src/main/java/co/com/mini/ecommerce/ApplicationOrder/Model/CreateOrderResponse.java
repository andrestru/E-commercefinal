package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;

public class CreateOrderResponse implements ApplicationResponse {

    private final Order order;

    public CreateOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
