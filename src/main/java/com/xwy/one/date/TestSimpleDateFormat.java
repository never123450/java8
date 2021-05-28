package com.xwy.one.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 下午8:18 2021/5/28
**/

public class TestSimpleDateFormat{
    public static void main(String[] args) throws Exception{
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        // java.lang.NumberFormatException: For input string: ".2202211E.22022114E4"
////        Callable<Date> call = () -> sdf.parse("20210528");
//        Callable<Date> call = () -> DateFormatThreadLocal.convert("20210528");
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<Future<Date>> results = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            results.add(executorService.submit(call));
//        }
//
//        for(Future<Date> future : results){
//            System.out.println(future.get());
//        }
//
//        executorService.shutdown();


        // -----------------------------------
        DateTimeFormatter sdf =  DateTimeFormatter.ofPattern("yyyyMMdd");
        // java.lang.NumberFormatException: For input string: ".2202211E.22022114E4"
//        Callable<Date> call = () -> sdf.parse("20210528");
        Callable<LocalDate> call = () -> LocalDate.parse("20210528", sdf);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(call));
        }

        for(Future<LocalDate> future : results){
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}