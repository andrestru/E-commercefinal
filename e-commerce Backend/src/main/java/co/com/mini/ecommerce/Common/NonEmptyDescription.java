package co.com.mini.ecommerce.Common;
public class NonEmptyDescription extends NonEmptyString{

        private final String value;

        public NonEmptyDescription(String value) {
            super(value);
            StringUtils.character280(value, "NonEmpty can't be > 280");
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


