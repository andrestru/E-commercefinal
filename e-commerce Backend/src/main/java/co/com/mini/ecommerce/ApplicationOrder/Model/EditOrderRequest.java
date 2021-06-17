package co.com.mini.ecommerce.ApplicationOrder.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class EditOrderRequest implements ApplicationRequest {

    private String number_order;
    private String name;
    private String address;
    private int identification;
    private String orderstatus;
    private String description;
    private double total;

    public EditOrderRequest() {
    }

    public EditOrderRequest(String number_order, String name, String address, int identification, String orderstatus, String description, double total) {
        this.number_order = number_order;
        this.name = name;
        this.address = address;
        this.identification = identification;
        this.orderstatus = orderstatus;
        this.description = description;
        this.total = total;
    }

    public String getNumber_order() {
        return number_order;
    }

    public void setNumber_order(String number_order) {
        this.number_order = number_order;
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

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
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
        EditOrderRequest that = (EditOrderRequest) o;
        return identification == that.identification && Double.compare(that.total, total) == 0 && Objects.equals(number_order, that.number_order) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(orderstatus, that.orderstatus) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_order, name, address, identification, orderstatus, description, total);
    }

    @Override
    public String toString() {
        return "EditOrderRequest{" +
                "number_order='" + number_order + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", identification=" + identification +
                ", orderstatus='" + orderstatus + '\'' +
                ", description='" + description + '\'' +
                ", total=" + total +
                '}';
    }
}
