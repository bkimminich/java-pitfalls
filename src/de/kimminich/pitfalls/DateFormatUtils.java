package de.kimminich.pitfalls;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

    private static final DateFormat DD_MMM_YYYY = new SimpleDateFormat("dd MMM yyyy");

    public Date toDate(String date) throws ParseException {
        return DD_MMM_YYYY.parse(date);
    }

    public String toString(Date date) {
        return DD_MMM_YYYY.format(date);
    }

}
