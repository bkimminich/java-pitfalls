package de.kimminich.pitfalls;

public class NumberConverterFixed {

    public long toLong(String number) {
        return Long.parseLong(number);
    } // avoids unnecessary unboxing

    public int toInt(String number) {
        return Integer.parseInt(number);
    } // avoids unnecessary unboxing

}