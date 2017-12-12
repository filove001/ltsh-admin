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
    /**
     * 获取调用此函数的代码的位置
     * @return 包名.类名.方法名(行数)
     */
    public static String getCodeLocation(int index){
        /*** 获取输出信息的代码的位置 ***/
//            由于调用多了一层所有stack[3]才对
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        String location = stacks[index].getClassName() + "." + stacks[index].getMethodName()
                + "(" + stacks[index].getLineNumber() + ")";
        return location;
    }
}
