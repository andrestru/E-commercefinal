package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.StringUtils;
import co.com.mini.ecommerce.Common.Validate;

import java.util.Objects;


public class CheckTaxRate {

    private final double value;

    public CheckTaxRate(double value) {
        // Validate.NotNull(value, "Tax rate Can not be null");
        Validate.isTrue(StringUtils.rangeTax(value), "Invalid, Tax rate exceeds parameters");
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckTaxRate that = (CheckTaxRate) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CheckTaxRate{" +
                "value=" + value +
                '}';
    }
}
