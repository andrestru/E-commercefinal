package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.Application.Errors.InputDataError;
import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.CreateOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.CreateOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.Common.Generator;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;

public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponse execute(CreateOrderRequest request) {
        Order order = validate(request);
        orderRepository.SaveOrder(order);
        return new CreateOrderResponse(order);
    }


    private Order validate(CreateOrderRequest request){
        try{
            NonEmptyName name = new NonEmptyName(request.getName());
            NonEmptyString address = new NonEmptyString(request.getAddress());
            CCNumber identification = new CCNumber(request.getIdentification());
            NonEmptyString description = new NonEmptyString(request.getDescription());
            CheckPrice total = new CheckPrice(request.getTotal());
            return new Order(
              new NonEmptyString(Generator.Generator()),
              name,
              address,
              identification,
              new NonEmptyString("Pending"),
              description,
              total
            );
        } catch (Exception e) {
            throw new InputDataError(e.getMessage());
        }
    }
}
