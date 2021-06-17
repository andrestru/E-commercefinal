package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ListOrderServiceTest {

    @Test
    void ListOrder(){
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        ListOrderService listOrderService = new ListOrderService(orderRepository);
        ListOrderRequest listOrderRequest = new ListOrderRequest();
        ListOrderResponse listOrderResponse = listOrderService.execute(listOrderRequest);
        assertAll(
                () -> assertDoesNotThrow(()->listOrderService.execute(listOrderRequest))
        );
    }

}