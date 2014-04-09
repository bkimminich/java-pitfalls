package de.kimminich.pitfalls;

import java.util.Comparator;

public class SmartComparator implements Comparator<ValueObject> {

    private boolean reverseOrder = false;

    public SmartComparator(boolean reverseOrder) {
        this.reverseOrder = reverseOrder;
    }

    @Override
    public int compare(ValueObject o1, ValueObject o2) {
        int result = o1.compareTo(o2);
        return reverseOrder ? -result : result;
    }

}
