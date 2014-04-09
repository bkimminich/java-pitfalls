package de.kimminich.pitfalls;

import java.io.Serializable;
import java.util.Comparator;

// missed Serializable interface (see SmartComparatorHint for example what might happen from that)
public class SmartComparatorFixed implements Comparator<ValueObjectFixed>, Serializable {

    private boolean reverseOrder = false;

    public SmartComparatorFixed(boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
    }

    @Override
    public int compare(ValueObjectFixed o1, ValueObjectFixed o2) {
        int result = o1.compareTo(o2);
        return reverseOrder ? invert(result) : result;
    }

    /* simply negating a compareTo() int result will cause wrong behavior if result happens to be Integer.MIN_VALUE
     because -Integer.MIN_VALUE == Integer.MIN_VALUE */
    private int invert(int result) {
        if (result == 0) {
            return 0;
        } else {
            return result < 0 ? 1 : -1;
        }
    }

}
