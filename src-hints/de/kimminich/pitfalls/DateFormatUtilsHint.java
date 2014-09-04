package de.kimminich.pitfalls;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DateFormatUtilsHint {

    @Test
    public void multiThreadedDateParsing() {
        try {
            Callable<Date> task = new Callable<Date>() {
                DateFormatUtils dateFormatUtils = new DateFormatUtils();

                public Date call() throws Exception {
                    return dateFormatUtils.toDate("1 Jan 2014");
                }
            };

            ExecutorService exec = Executors.newFixedThreadPool(5);
            List<Future<Date>> results = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                results.add(exec.submit(task));
            }
            exec.shutdown();

            for (Future<Date> result : results) {
                System.out.println(result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
