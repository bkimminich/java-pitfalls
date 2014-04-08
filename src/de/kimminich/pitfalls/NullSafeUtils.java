package de.kimminich.pitfalls;

import de.kimminich.ValueObject;

public class NullSafeUtils {

    public static boolean nullSafeEquals(ValueObject o1, ValueObject o2) {
        return (o1 == null && o2 == null) || o1.equals(o2);
    }

    public int nullSafeCompare(ValueObject o1, ValueObject o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 != null && o1.getValue() == null) {
            return -1;
        }
        if (o2 != null && o2.getValue() == null) {
            return 1;
        }
        return o1.getValue().compareTo(o2.getValue());
    }

}
