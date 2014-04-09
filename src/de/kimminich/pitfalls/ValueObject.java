package de.kimminich.pitfalls;

public final class ValueObject implements Comparable<ValueObject> {
    private Integer value;

    public ValueObject() {
    }

    public ValueObject(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isNegative() {
        return value < 0;
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