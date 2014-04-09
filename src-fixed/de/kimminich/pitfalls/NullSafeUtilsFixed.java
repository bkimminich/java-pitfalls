package de.kimminich.pitfalls;

import java.util.Objects;

public class NullSafeUtilsFixed {

    public static boolean nullSafeEquals_sinceJava7(ValueObjectFixed o1, ValueObjectFixed o2) {
        return Objects.equals(o1, o2);
    }

    public static boolean nullSafeEquals_preJava7(ValueObjectFixed o1, ValueObjectFixed o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    public int nullSafeCompare(ValueObjectFixed o1, ValueObjectFixed o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        // previous version lacked handling of either o1 or o2 being null...
        if (o1 == null || o1.getValue() == null) {
            return -1;
        }
        if (o2 == null || o2.getValue() == null) {
            return 1;
        }
        // no more unattended null pointer dereference possible when this line is reached
        return o1.getValue().compareTo(o2.getValue());
    }

}
