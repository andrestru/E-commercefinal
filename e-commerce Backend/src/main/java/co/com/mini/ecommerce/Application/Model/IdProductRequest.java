package co.com.mini.ecommerce.Application.Model;

import co.com.mini.ecommerce.Common.Operation.ApplicationRequest;

import java.util.Objects;

public class IdProductRequest implements ApplicationRequest {

    private int id;

    public IdProductRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdProductRequest that = (IdProductRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "IdProductRequest{" +
                "id=" + id +
                '}';
    }
}
