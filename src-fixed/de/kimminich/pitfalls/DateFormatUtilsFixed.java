package de.kimminich.pitfalls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtilsFixed {

    /* DateFormat is not thread safe so using a static constant can cause problems! Run DateFormatUtilsHint
     to get an idea what might happen in a multi-threaded environment.
     */
    private final DateFormat DD_MMM_YYYY = new SimpleDateFormat("dd MMM yyyy");

    public Date toDate(String date) throws ParseException {
        return DD_MMM_YYYY.parse(date);
    }

    public String toString(Date date) {
        return DD_MMM_YYYY.format(date);
    }

}
