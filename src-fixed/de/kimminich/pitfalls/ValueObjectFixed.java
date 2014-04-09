package de.kimminich.pitfalls;

public final class ValueObjectFixed implements Comparable<ValueObjectFixed> {
    private Integer value;

    public ValueObjectFixed() {
    }

    public ValueObjectFixed(Integer value) {
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
    public int compareTo(ValueObjectFixed o) {
        return value.compareTo(o.getValue());
    }

    @Override
    // compareTo() and equals() should be consistent so one should not rely on Object.equals()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueObjectFixed that = (ValueObjectFixed) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    // hashCode() and equals() must always be consistent as well
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "value=" + value +
                '}';
    }
}