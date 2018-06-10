package com.fjz.util.log;

import com.fjz.util.Systems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLogger;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * 对slf4j日志类进行了简单封装，使用该封装类的优势在于以下两点
 * 不必在每个类中去创建对象，直接类名 + 方法即可
 * 可以很方便的打印出堆栈信息
 * @Description 日志记录类
 * @author fjz
 * @date 2017
 */
public class Logs {
	public static Logger log = LoggerFactory.getLogger(Logs.class);

    public static void warn(String msg,Object... value) {
        log.warn(getCodeLocationMsg(msg),value);
    }
    /**
     * 打印警告
     * 
     * @param obj
     */
    public static void warn(Object obj) {
        String logStr = getLocationLog(obj);
        log.warn(logStr);
    }
    public static void debug(String msg,Object... value) {
        log.debug(getCodeLocationMsg(msg),value);
    }
    /**
     * 打印debug信息
     * @param obj
     */
    public static void debug(Object obj) {
        String logStr = getLocationLog(obj);
        log.debug(logStr);
    }
    public static void info(String msg,Object... value) {
        log.info(getCodeLocationMsg(msg),value);
    }
    /**
     * 打印信息
     * 
     * @param obj
     */
    public static void info(Object obj) {
        String logStr = getLocationLog(obj);
        log.info(logStr);
    }
    public static void error(String msg,Object... value) {
        log.error(getCodeLocationMsg(msg),value);
    }
    /**
     * 打印错误
     * 
     * @param obj
     */
    public static void error(Object obj) {
        String logStr = getLocationLog(obj);
        log.error(logStr);
    }
    
    /**
     * 向数据库告警表中插入信息
     * @param obj
     */
    public static void dbWarn(Object obj) {
//        try{
//            String printInfo = "";
//            /*** 获取输出信息的代码的位置 ***/
//            String location = "";
//            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//            location = stacks[2].getClassName() + "." + stacks[2].getMethodName()
//                    + "(" + stacks[2].getLineNumber() + ")";
//
//            /*** 是否是异常  ***/
//            if (obj instanceof Exception) {
//                Exception e = (Exception) obj;
//                printInfo = location + e.getMessage();
//                log.fatal(printInfo.substring(0, printInfo.length() > 512?512:printInfo.length()));
//            } else {
//                printInfo = location + obj.toString();
//                log.fatal(printInfo.substring(0, printInfo.length() > 512?512:printInfo.length()));
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    private static String getLocationLog(Object obj) {
        /*** 获取输出信息的代码的位置 ***/
        String location =Systems.getCodeLocation(4)+" ";
        String logStr=null;
        /*** 是否是异常  ***/
        if (obj instanceof Exception) {
            Exception e = (Exception) obj;
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            String str = sw.toString();
            logStr=location + str;
        } else {
            logStr=location + obj.toString();
        }
        return logStr;
    }
    public static String getCodeLocationMsg(String msg){
        return Systems.getCodeLocation(4)+" "+msg;
    }

}
