package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static String DateToday(){
        LocalDate today = LocalDate.now();
        String DateToday = today.format(DateTimeFormatter.ofPattern("E,dd-MMM-yyyy"));
        return DateToday;
    }

}
