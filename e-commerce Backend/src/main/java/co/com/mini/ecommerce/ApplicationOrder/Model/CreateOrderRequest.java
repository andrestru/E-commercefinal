package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class CreateOrderRequest  implements ApplicationRequest {

    private String name;
    private String address;
    private int identification;
    private String description;
    private double total;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(String name, String address, int identification, String description, double total) {
        this.name = name;
        this.address = address;
        this.identification = identification;
        this.description = description;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderRequest that = (CreateOrderRequest) o;
        return identification == that.identification && Double.compare(that.total, total) == 0 && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, identification, description, total);
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", identification=" + identification +
                ", description='" + description + '\'' +
                ", total=" + total +
                '}';
    }
}
