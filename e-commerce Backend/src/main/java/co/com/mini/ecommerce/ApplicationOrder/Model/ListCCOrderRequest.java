package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class ListCCOrderRequest implements ApplicationRequest {

    private int identification;

    public ListCCOrderRequest() {
    }

    public ListCCOrderRequest(int identification) {
        this.identification = identification;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListCCOrderRequest that = (ListCCOrderRequest) o;
        return identification == that.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "ListCCOrderRequest{" +
                "identification=" + identification +
                '}';
    }
}
