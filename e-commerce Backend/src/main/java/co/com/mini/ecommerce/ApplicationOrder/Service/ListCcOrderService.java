package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListCCOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.ListCCOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;

import java.util.Collection;

public class ListCcOrderService implements ListCCOrderUseCase {

    private final OrderRepository orderRepository;

    public ListCcOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ListOrderResponse execute(ListCCOrderRequest request) {
        Collection<Order>  orderCollection = orderRepository.GetById(new CCNumber(request.getIdentification()));
        return new ListOrderResponse(orderCollection);
    }
}
