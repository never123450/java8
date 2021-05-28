package com.xwy.one.date;

import com.sun.javafx.tools.packager.PackagerException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 下午8:29 2021/5/28
**/

public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static Date convert(String source) throws Exception {
        return df.get().parse(source);
    }


}