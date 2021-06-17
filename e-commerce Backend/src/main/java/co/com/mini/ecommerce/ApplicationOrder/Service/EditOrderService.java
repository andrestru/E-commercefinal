package co.com.mini.ecommerce.ApplicationOrder.Service;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.Application.Errors.InputDataError;
import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.Model.EditOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.EditOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;

public class EditOrderService implements EditOrderUseCase {

    private final OrderRepository orderRepository;

    public EditOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public EditOrderResponse execute(EditOrderRequest request) {
        Order order = validate(request);
        orderRepository.EditOrder(order);
        return new EditOrderResponse(order);
    }

    private Order validate(EditOrderRequest request){
        try{
            NonEmptyString number_order = new NonEmptyString(request.getNumber_order());
            NonEmptyName name = new NonEmptyName(request.getName());
            NonEmptyString address = new NonEmptyString(request.getAddress());
            CCNumber identification = new CCNumber(request.getIdentification());
            NonEmptyString orderstatus = new NonEmptyString(request.getOrderstatus());
            NonEmptyString description = new NonEmptyString(request.getDescription());
            CheckPrice total = new CheckPrice(request.getTotal());
            return new Order(
              number_order,
              name,
              address,
              identification,
              orderstatus,
              description,
              total
            );
        }catch (Exception e){
            throw new InputDataError(e.getMessage());
        }
    }
}
