package de.kimminich.pitfalls;

import java.util.logging.Logger;

public class PrettyExceptionPrinterFixed {

    public void prettyPrint(Throwable t, Logger logger) {
        String className = t.getClass().getName();
        String message = t.getMessage();

        logger.severe(indefiniteArticleFor(className) + " " + className + " has occurred: " +
                (message != null ? message : "No message")); // missing parenthesis resulted in unintended log messages
    }

    private String indefiniteArticleFor(String className) {
        return "A" + (className.matches("[AEIOU].*") ? "n" : "");
    }

}
