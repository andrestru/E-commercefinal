package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class ListNumOrderRequest implements ApplicationRequest {

    private String number_order;

    public ListNumOrderRequest() {
    }

    public ListNumOrderRequest(String number_order) {
        this.number_order = number_order;
    }

    public String getNumber_order() {
        return number_order;
    }

    public void setNumber_order(String number_order) {
        this.number_order = number_order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNumOrderRequest that = (ListNumOrderRequest) o;
        return Objects.equals(number_order, that.number_order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_order);
    }

    @Override
    public String toString() {
        return "ListNumOrderRequest{" +
                "number_order='" + number_order + '\'' +
                '}';
    }
}
