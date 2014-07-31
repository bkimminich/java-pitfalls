package de.kimminich.pitfalls;

import org.junit.Test;

public class ExpectedValueCopierHint {

    @Test
    public void expectationMet() {
        ValueObject source = new ValueObject(1);
        ValueObject target = new ValueObject();
        ExpectedValueCopier.copyIfExpectationIsMet(source, target, "1");
        System.out.println(target);
    }

    @Test
    public void expectationNotMet() {
        ValueObject source = new ValueObject(1);
        ValueObject target = new ValueObject();
        ExpectedValueCopier.copyIfExpectationIsMet(source, target, "2");
        System.out.println(target);
    }

}
