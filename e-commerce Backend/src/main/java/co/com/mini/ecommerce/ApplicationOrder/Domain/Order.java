package co.com.mini.ecommerce.ApplicationOrder.Domain;

import co.com.mini.ecommerce.Application.Domain.CheckPrice;
import co.com.mini.ecommerce.Common.NonEmptyName;
import co.com.mini.ecommerce.Common.NonEmptyString;

public class Order {

    NonEmptyString number_order;
    NonEmptyName name;
    NonEmptyString address;
    CCNumber identification;
    NonEmptyString orderstatus;
    NonEmptyString description;
    CheckPrice total;

    public Order(NonEmptyString number_order, NonEmptyName name, NonEmptyString address, CCNumber identification, NonEmptyString orderstatus, NonEmptyString description, CheckPrice total) {
        this.number_order = number_order;
        this.name = name;
        this.address = address;
        this.identification = identification;
        this.orderstatus = orderstatus;
        this.description = description;
        this.total = total;
    }

    public NonEmptyString getNumber_order() {
        return number_order;
    }

    public NonEmptyName getName() {
        return name;
    }

    public NonEmptyString getAddress() {
        return address;
    }

    public CCNumber getIdentification() {
        return identification;
    }

    public NonEmptyString getOrderstatus() {
        return orderstatus;
    }

    public NonEmptyString getDescription() {
        return description;
    }

    public CheckPrice getTotal() {
        return total;
    }
}
