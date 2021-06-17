package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;

import java.util.Collection;

public class ListOrderResponse implements ApplicationResponse {

    private final Collection<Order> orders;

    public ListOrderResponse(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<Order> getOrders() {
        return orders;
    }
}
