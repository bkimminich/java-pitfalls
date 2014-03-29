package de.kimminich.pitfalls;

import java.util.logging.Logger;

public class PrettyExceptionPrinter {

    public void prettyPrint(Throwable t, Logger logger) {
        String classname = t.getClass().getName();
        String message = t.getMessage();
        logger.severe("A" + (classname.matches("AEIOU.*") ? "n " : " ") + classname + " has occurred: " + message != null ? message : "No message");
    }

}
