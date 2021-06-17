package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;

public class EditOrderResponse implements ApplicationResponse {

    private final Order order;

    public EditOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "EditOrderResponse{" +
                "order=" + order +
                '}';
    }
}
