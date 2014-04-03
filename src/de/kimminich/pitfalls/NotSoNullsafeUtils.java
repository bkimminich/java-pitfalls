package de.kimminich.pitfalls;

public class NotSoNullSafeUtils {

    public static boolean nullSafeEquals(Integer x, Integer y) {
        return (x == null && y == null) || x.equals(y);
    }

}
