package de.kimminich.pitfalls;

import org.junit.Test;

import java.util.logging.Logger;

public class PrettyExceptionPrinterTest {

    @Test
    public void testPrintPrettyExceptions() {
        PrettyExceptionPrinter printer = new PrettyExceptionPrinter();
        Logger logger = Logger.getAnonymousLogger();

        printer.prettyPrint(new IllegalAccessException("Access denied!"), logger);
        printer.prettyPrint(new NullPointerException(), logger);
    }

}
