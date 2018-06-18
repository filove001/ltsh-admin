package study.jar.jctools;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.jctools.maps.ConcurrentAutoTable;
import org.junit.Test;
import study.java8.JsonUtilsTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2018/6/16.
 */
public class ConcurrentAutoTableTest {
    ConcurrentAutoTable table=new ConcurrentAutoTable();
    AtomicLong atomicLong=new AtomicLong();
    private static int count=100000;
    private static int threadNum=200;
    @Test
    public void test(){

        Tests.thReadForEach(new RunableForEach("ConcurrentAutoTable",threadNum,count) {
            public void action()  {
                table.increment();
            }
        });
        System.out.println(table.intValue());

        Tests.thReadForEach(new RunableForEach("atomicLong",threadNum,count) {
            public void action()  {
                atomicLong.incrementAndGet();
            }
        });
        System.out.println(atomicLong.intValue());

    }
}
