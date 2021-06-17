package co.com.mini.ecommerce.ApplicationOrder.Ports.Out;

import co.com.mini.ecommerce.ApplicationOrder.Domain.CCNumber;
import co.com.mini.ecommerce.ApplicationOrder.Domain.Order;
import co.com.mini.ecommerce.Common.NonEmptyString;

import java.util.Collection;

public interface OrderRepository {

    void SaveOrder(Order order);

    Collection<Order> ListOrder();

    void DeleteOrder(NonEmptyString numOrder);

    Collection<Order> ListNumOrder(NonEmptyString numOrder);

    void EditOrder(Order order);

    void EditStatus(NonEmptyString numOrder);

    Collection<Order> GetById(CCNumber id);

}
