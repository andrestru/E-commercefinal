package co.com.mini.ecommerce.Common;

public class NonEmptyName extends NonEmptyString{

    private final String value;

    public NonEmptyName(String value) {
        super(value);
        StringUtils.character100(value, "NonEmpty can't be > 100");
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
