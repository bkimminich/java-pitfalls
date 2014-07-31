package de.kimminich.pitfalls;

import org.junit.Test;

public class ValueLabelizerHint {

    @Test
    public void labelize() {
        System.out.println(ValueLabelizer.labelize(new ValueObject()));
        System.out.println(ValueLabelizer.labelize(new ValueObject(1)));
        System.out.println(ValueLabelizer.labelize(new ValueObject(2)));
    }

}
