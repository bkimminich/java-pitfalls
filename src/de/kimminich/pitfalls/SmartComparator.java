package de.kimminich.pitfalls;

import java.util.Comparator;

public class SmartComparator implements Comparator<SmartComparator.ValueObject> {

    private boolean reverseOrder = false;

    public SmartComparator(boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
    }

    @Override
    public int compare(ValueObject o1, ValueObject o2) {
        int result = o1.compareTo(o2);
        return reverseOrder ? -result : result;
    }

    public static final class ValueObject implements Comparable<ValueObject> {
        private Integer value;

        public ValueObject(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(ValueObject o) {
            return value.compareTo(o.getValue());
        }

        @Override
        public String toString() {
            return "ValueObject{" +
                    "value=" + value +
                    '}';
        }
    }

}
