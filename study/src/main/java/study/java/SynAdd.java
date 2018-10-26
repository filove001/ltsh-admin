package study.java;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.junit.Test;
import study.java8.JsonUtilsTest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/6/11.
 */
public class SynAdd {
    int count=0;
    @Test
    public void test(){
        byte[] bytes = "123".getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(new String(bytes).getBytes()));
        Tests.thReadForEach(new RunableForEach("PrintWriter println",100,100) {
            @Override
            public void action()  {
                synchronized (this) {
                    count++;
                }

            }
        });
        System.out.println(count);
    }
}
