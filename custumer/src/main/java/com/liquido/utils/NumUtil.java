package com.liquido.utils;

import java.util.Date;

public class NumUtil {

    public static Integer generate3() {
        return (int)(((Math.random() * 9) + 1) * 100);
    }

    public static Integer generate6() {
        return (int)(((Math.random() * 9) + 1) * 100000);
    }

    public static String genOrderNo() {
        String no = DateTimeUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        int random = (int) (Math.random() * 900 + 100);
        no = no + random;
        return no;
    }

    public static String genPayNo() {
        String no = DateTimeUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        int random = (int) (Math.random() * 900 + 100);
        no = no + random;
        return no;
    }

    public static String genRefundNo() {
        String no = DateTimeUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        int random = (int) (Math.random() * 900 + 100);
        no = no + random;
        return no;
    }
}
