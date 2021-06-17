package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EditOrderServiceTest {

    @Test
    void EditOrderServiceTest(){
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        EditOrderService editOrderService = new EditOrderService(orderRepository);
        final int id = 123;
        EditOrderRequest editOrderRequest = new EditOrderRequest(
                "order123",
                "andres",
                "medellin",
                id,
                "Approved",
                "Huawei",
                600403
        );
        EditOrderResponse editOrderResponse = editOrderService.execute(editOrderRequest);

        assertAll(
                () -> assertDoesNotThrow(()->editOrderService.execute(editOrderRequest)),
                () -> assertEquals(id, editOrderRequest.getIdentification())
        );

    }

}