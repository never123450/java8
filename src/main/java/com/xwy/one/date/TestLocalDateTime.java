package com.xwy.one.date;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @description:
 * @author: xwy
 * @create: 下午8:49 2021/5/28
 **/

public class TestLocalDateTime {

    public static void main(String[] args) throws InterruptedException {
        // LocalDate、LocalTime、LocalDateTime

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime of = LocalDateTime.of(2021, 5, 28, 20, 52, 22);
        System.out.println(of);

        LocalDateTime localDateTime1 = of.plusYears(2);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.minusDays(2);
        System.out.println(localDateTime2);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());

        System.out.println("-----------------------------");
        // Instant : 时间戳(以 Unix 元年:1970 年 1 月 1 日 00:00:00 到某个时间之间的毫秒值到)
        Instant now = Instant.now();// 默认获取 UTC 时区
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(offsetDateTime.toEpochSecond());

        Instant instant = Instant.ofEpochSecond(60);
        System.out.println(instant);
        System.out.println("--------------------------------");

        // Duration : 计算 2 个时间之间的间隔
        // Period : 计算 2 个日期之前的间隔

        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();
        Duration between = Duration.between(ins1, ins2);
        System.out.println(between.toMillis());

        LocalTime localTime = LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime1 = LocalTime.now();
        System.out.println(Duration.between(localTime,localTime1).toMillis());

        LocalDate localDate = LocalDate.of(2020,1,1);
        LocalDate localDate1 = LocalDate.now();
        Period between1 = Period.between(localDate, localDate1);
        System.out.println(between1);
        System.out.println(between1.getYears());
        System.out.println("---------------------------");

        // TemporalAdjuster : 时间矫正器
        LocalDateTime localDateTime3 = LocalDateTime.now();
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime3.withDayOfMonth(10);
        System.out.println(localDateTime4);

        // 下个周五是几号
        LocalDateTime with = localDateTime3.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(with);

        // 自定义:下一个工作日
        localDateTime3.with(l->{
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)){
                ldt4.plusDays(3);
            }else if (dayOfWeek.equals(DayOfWeek.SATURDAY)){
                ldt4.plusDays(2);
            }else {
                ldt4.plusDays(1);
            }
            return l;
        });

    }
}