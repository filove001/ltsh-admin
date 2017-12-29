package com.fjz.util;

import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fengjianzhong on 2017/12/10.
 */
public class FilesTest {
    @Test
    public void unicode() throws ParseException {
        String file = "E:\\ltsh-admin\\eadmin\\src\\main\\resources\\application.properties";
        String temp=Files.read(file);
        System.out.println(temp);
    }
    @Test
    public void test() throws ParseException {
        String file="C:\\Users\\fengjianzhong\\Documents\\WeChat Files\\xiaoyao409099585\\Files\\haima.access-2017-12-09.log";
        List<String> list = Files.readLines(new File(file), "UTF-8");
        int num=0;
        long time=0;
        Date one=null;
        Date tow=null;
        for (String s:list
             ) {
            if(s.contains("115.183.28.142")&&s.contains("Baiduspider")){
                num++;
                Date n=Dates.toDateHHmmss(s.substring(s.indexOf("[")+13,s.indexOf(" +0800]")));
                if(one==null){
                    one=n;
                    tow=n;
                }else if(n.after(Dates.addMinutes(tow,12))||s.contains("23:58:")){
//                    tow=tow==null?Dates.addMinutes(one,10):tow;
                    tow=s.contains("23:58:")?n:tow;
                    time=time+Dates.addMinutes(tow,12).getTime()-one.getTime();
                    one=null;
                    tow=null;
                }
                tow=Dates.toDateHHmmss(s.substring(s.indexOf("[")+13,s.indexOf(" +0800]")));
//                time+=Integer.parseInt(s.substring(s.indexOf(" 200 ")+5,s.indexOf(" \"-\" \"")));
//                System.out.println(s.substring(s.indexOf("[")+12,s.indexOf(" +0800]")));
//                time+=Integer.parseInt(s.substring(s.indexOf("[")+12,s.indexOf(" +0800]")));
                System.out.println(s);
            }
        }
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date now1 = df.parse("2017-12-09 11:50:41");
//        java.util.Date date1=df.parse("2017-12-09 11:45:10");
//        long l1=now1.getTime()-date1.getTime()+10*60*1000;
//
//
//        java.util.Date now = df.parse("2017-12-09 23:58:45");
//        java.util.Date date=df.parse("2017-12-09 14:36:24");
//        long l=now.getTime()-date.getTime();l=l+l1+10*60*1000;
        long l=time;
        long day=l/(24*60*60*1000);
        long hour=(l/(60*60*1000)-day*24);
        long min=((l/(60*1000))-day*24*60-hour*60);
        long s=(l/1000-day*24*60*60-hour*60*60-min*60);
        System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
        System.out.println();
        System.out.println(time/60/60);
        System.out.println(num);
    }
}
