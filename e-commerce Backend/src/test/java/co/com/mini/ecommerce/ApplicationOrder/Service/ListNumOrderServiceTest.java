package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListNumOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ListNumOrderServiceTest {

    @Test
    void ListNOrderTest(){
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        ListNumOrderService listNumOrderService = new ListNumOrderService(orderRepository);
        final String id = "32312123";
        ListNumOrderRequest listNumOrderRequest = new ListNumOrderRequest(id);
        ListOrderResponse listOrderResponse = listNumOrderService.execute(listNumOrderRequest);
        assertAll(
                () -> assertDoesNotThrow(()->listNumOrderService.execute(listNumOrderRequest)),
                () -> assertEquals(id, listNumOrderRequest.getNumber_order())
        );
    }

}