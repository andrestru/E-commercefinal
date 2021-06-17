package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Model.ListCCOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ListCcOrderServiceTest {

    @Test
    void ListOrderTest(){
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        ListCcOrderService listCcOrderService = new ListCcOrderService(orderRepository);
        final int id = 32312123;
        ListCCOrderRequest listCCOrderRequest = new ListCCOrderRequest(id);
        ListOrderResponse listOrderResponse = listCcOrderService.execute(listCCOrderRequest);
        assertAll(
                () -> assertDoesNotThrow(()->listCcOrderService.execute(listCCOrderRequest)),
                () -> assertEquals(id, listCCOrderRequest.getIdentification())
        );
    }

}