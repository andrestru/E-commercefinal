package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.Validate;

import java.util.Objects;
import java.util.regex.Pattern;

public class CheckPrice {

    private final double value;

    private final Pattern pattern = Pattern.compile("^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$");

    public CheckPrice(double value) {
       // Validate.NotNull(value, "Base Price cannot be null.");
        Validate.isTrue(pattern.matcher(String.valueOf(value)).matches(),"Invalid, Base price cannot be < 0");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckPrice verifier = (CheckPrice) o;
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
