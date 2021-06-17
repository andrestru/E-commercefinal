package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderServiceTest {

    @Test
    void CreateOrderTest(){
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        CreateOrderService createOrderService = new CreateOrderService(orderRepository);
        final int id = 123;
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(
                "Michael trujillo",
                "Medellin",
                id,
                "celular xiaomi",
                1000000
        );
        CreateOrderResponse createOrderResponse = createOrderService.execute(createOrderRequest);
        assertAll(
                ()->assertDoesNotThrow(()-> createOrderService.execute(createOrderRequest)),
                ()->assertEquals(id, createOrderRequest.getIdentification())
        );
    }

}