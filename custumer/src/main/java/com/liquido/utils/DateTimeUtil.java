package com.liquido.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DateTimeUtil.class);

    public static Date parse(String dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            LOG.error("转换成日期错误，字符串：{}，格式：{}", dateStr, pattern);
            return null;
        }
    }

    public static String format(Date dateStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(dateStr);
    }

    /**
     * 获取指定日期后n天的日期
     */
    public static Date afterDays(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        return calendar.getTime();
    }
}
