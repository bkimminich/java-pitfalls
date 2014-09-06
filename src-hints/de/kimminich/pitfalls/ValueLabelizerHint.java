package de.kimminich.pitfalls;

import org.junit.Test;

public class ValueLabelizerHint {

    @Test
    public void labelize() {
        try {
            System.out.println(ValueLabelizer.labelize(new ValueObject()));
            System.out.println(ValueLabelizer.labelize(new ValueObject(1)));
            System.out.println(ValueLabelizer.labelize(new ValueObject(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
