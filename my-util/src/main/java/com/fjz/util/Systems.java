package com.fjz.util;

/**
 * 系统工具类
 * Created by fengjianzhong on 2017/6/16.
 */
public class Systems {
    public final static boolean isWin;
    static {
        String os = System.getProperty("os.name");
        isWin=os.toLowerCase().startsWith("win");
    }
}
