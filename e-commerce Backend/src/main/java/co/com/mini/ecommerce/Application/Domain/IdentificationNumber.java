package co.com.mini.ecommerce.Application.Domain;

import co.com.mini.ecommerce.Common.StringUtils;
import co.com.mini.ecommerce.Common.Validate;

import java.util.Objects;

public class IdentificationNumber {

    private final int identification;

    public IdentificationNumber(int identification) {
       // Validate.NotNull(identification, "Identification cannot be null.");
        Validate.isTrue(StringUtils.nonBlank(String.valueOf(identification)), "Identification cannot be empty.");
        Validate.isTrue(StringUtils.rangeId(identification), "Invalid Identification number.");
        this.identification = identification;
    }

    public int getIdentification() {
        return identification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationNumber that = (IdentificationNumber) o;
        return identification == that.identification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification);
    }

    @Override
    public String toString() {
        return "IdentificationNumber{" +
                "identification=" + identification +
                '}';
    }
}
