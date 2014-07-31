package de.kimminich.pitfalls;

public class ExpectedValueCopier {

    public static void copyIfExpectationIsMet(ValueObject source, ValueObject target, String expectation) {
        if (source != null && expectation.equals(source.getValue())) {
            target.setValue(source.getValue());
        }
    }

}
