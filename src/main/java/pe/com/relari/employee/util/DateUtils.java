package pe.com.relari.employee.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {}

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);

    public static LocalDate parse(String dateString) {
        return LocalDate.parse(dateString, FORMATTER);
    }

    public static String format(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
    }

}
