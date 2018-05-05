package com.company.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static Date fromStringToDate(String date) {
        return convertToDate(fromStringToLocalDate(date));
    }

    public static LocalDate fromStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date convertToDate(LocalDate localDate) {
        Instant instant = localDate
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();

        return Date.from(instant);
    }
}
