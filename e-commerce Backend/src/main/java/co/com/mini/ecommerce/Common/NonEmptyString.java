package co.com.mini.ecommerce.Common;

public class NonEmptyString {

        private final String value;

    public NonEmptyString(String value) {
        Validate.NotNull(value, "NonEmpty cannot be null");
        Validate.isTrue(StringUtils.nonBlank(value), "NonEmpty cannot be empty");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyString{" +
                "value='" + value + '\'' +
                '}';
    }
}
