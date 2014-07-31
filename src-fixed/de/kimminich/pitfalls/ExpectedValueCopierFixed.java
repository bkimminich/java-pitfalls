package de.kimminich.pitfalls;

public class ExpectedValueCopierFixed {

    public static void copyIfExpectationIsMet(ValueObjectFixed source, ValueObjectFixed target, String expectation) {
        if (source != null && expectation.equals(String.valueOf(source.getValue()))) { // String.equals(Integer) was always false before regardless of the values at runtime
            target.setValue(source.getValue());
        }
    }

}
