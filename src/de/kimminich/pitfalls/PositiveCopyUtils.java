package de.kimminich.pitfalls;

public class PositiveCopyUtils {

    public ValueObject copy(ValueObject original) {
        ValueObject copy = new ValueObject();
        copy.setValue(original.isNegative() ? 0 : original.getValue());
        return copy;
    }

    private static final class ValueObject {
        private Integer value;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public boolean isNegative() {
            return value < 0;
        }
    }

}
