package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.Validate;

import java.util.Objects;
import java.util.regex.Pattern;

public class CheckInventory {

    private final int value;

    private final Pattern pattern = Pattern.compile("^\\d+$");

    public CheckInventory(int value) {
      //  Validate.NotNull(value, "Inventory Quantity cannot be null.");
        Validate.isTrue(pattern.matcher(String.valueOf(value)).matches(),"Invalid, Inventory Quantity cannot be < 0");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckInventory verifier = (CheckInventory) o;
        return Objects.equals(value, verifier.value) && Objects.equals(pattern, verifier.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, pattern);
    }

    @Override
    public String toString() {
        return "Verifier{" +
                "value=" + value +
                ", pattern=" + pattern +
                '}';
    }
}
