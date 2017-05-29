package com.fjz.util;


import java.util.Arrays;
import java.util.Random;

/**
 * Created by fengjianzhong on 2017/5/29.
 */
public class Randoms {
    //  定义所有的字符组成的串
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //  定义所有的小写字符组成的串（不包括数字）
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //  定义所有的数字字符组成的串
    public static final String numberChar = "0123456789";
    private static final Random r = new Random();
    public static int getInt(int start, int end) {
        Assert.isTrue(end>=start&&start>=0,"end必须大于等于start,并且start大于等于0");
        if (start == end) {return start;}
        return start + r.nextInt(end - start);
    }
    public static long getLong(long start, long end) {
        Assert.isTrue(end>=start&&start>=0,"end必须大于等于start,并且start大于等于0");
        if (start == end) {return end;}
        return (long)getDouble(start, end);
    }
    public static double getDouble(double start, double end) {
        Assert.isTrue(end>=start&&start>=0,"end必须大于等于start,并且start大于等于0");
        if (start == end) {return end;}
        return start + (end - start) * r.nextDouble();
    }
    public static String getNumberString(int length) {
        Assert.isTrue(length>=0,"length必须大于等于0");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <length ; i++) {
            sb.append(r.nextInt(10));
        }
        return  sb.toString();
    }
    public static String getLetterString(int length){
        Assert.isTrue(length>=0,"length必须大于等于0");
        StringBuilder sb = new StringBuilder();
        char[] chars=letterChar.toCharArray();
        for (int i = 0; i <length ; i++) {
            sb.append(chars[r.nextInt(chars.length)]);
        }
        return  sb.toString();
    }
    /**
     * 返回随机名称, prefix字符串+  (0-number)随机数字.
     */
    public static String getRandomName(String prefix,int number) {
        return prefix + r.nextInt(number);
    }
}
