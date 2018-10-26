package study.java;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 */
public class StringTest{
    @Test
   public void longtime(){
   }

    @Test
    public void read() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("C:\\Users\\fengjianzhong\\Downloads\\key (1).txt"));
        String p="private String ";
        StringBuilder sb = new StringBuilder();
        for (String temp:list
             ) {
            String[] ss=temp.split("\t");
            if(ss.length==4){
                sb.append("\n").append(p).append(ss[0]).append(";").append("\t\t//").append(ss[3]);
            }else if(ss.length==1){
                sb.append(ss[0]);
            }
        }
        System.out.println(sb.toString());

        String temp = "depId\tString32\tY\t科室ID";
    }
}