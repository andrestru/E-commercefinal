package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.ListOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;

import java.util.Collection;

public class ListOrderService implements ListOrderUseCase {

    private final OrderRepository orderRepository;

    public ListOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ListOrderResponse execute(ListOrderRequest request) {
        Collection<Order> orders = orderRepository.ListOrder();
        return new ListOrderResponse(orders);
    }
}
