package de.kimminich.pitfalls;

public class PositiveCopyUtilsFixed {

    public ValueObjectFixed copy(ValueObjectFixed original) {
        ValueObjectFixed copy = new ValueObjectFixed();
        // mixing primitive and wrapper types in a ternary operator causes unboxing and immediate reboxing of the wrapper type
        copy.setValue(original.isNegative() ? Integer.valueOf(0) : original.getValue());
        return copy;
    }

}
