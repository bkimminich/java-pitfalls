package de.kimminich.pitfalls;

public class NumberConverter {

    public long toLong(String number) {
        return Long.valueOf(number).longValue();
    }

    public int toInt(String number) {
        return Integer.valueOf(number).intValue();
    }

}