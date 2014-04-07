package de.kimminich.pitfalls;

import de.kimminich.ValueObject;

public class PositiveCopyUtils {

    public ValueObject copy(ValueObject original) {
        ValueObject copy = new ValueObject();
        copy.setValue(original.isNegative() ? 0 : original.getValue());
        return copy;
    }

}
