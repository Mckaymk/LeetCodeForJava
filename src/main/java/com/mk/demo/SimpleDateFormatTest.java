package com.mk.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author Mckay
 * @create 2019-12-10
 * @description
 **/
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.format(new Date());
        simpleDateFormat.parse("");

        LocalDate localDate = LocalDate.of(2019,2,28);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.get(ChronoField.DAY_OF_YEAR));
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getMonth());
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
//        localDateTime.plusNanos(12);
        LocalDate localDate1 = LocalDate.parse("2019-09-10");
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate1.format(dateTimeFormatter));
        System.out.println(localDate1);

    }
}
