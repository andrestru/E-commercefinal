package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListNumOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.ListNumOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.Common.NonEmptyString;
import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;
import co.com.mini.ecommerce.Common.Operation.ApplicationResponse;
import co.com.mini.ecommerce.Common.Operation.ApplicationUseCase;

import java.util.Collection;

public class ListNumOrderService implements ListNumOrderUseCase {

    private final OrderRepository orderRepository;

    public ListNumOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ListOrderResponse execute(ListNumOrderRequest request) {
        Collection<Order> orders = orderRepository.ListNumOrder(new NonEmptyString(request.getNumber_order()));
        return new ListOrderResponse(orders);
    }
}
