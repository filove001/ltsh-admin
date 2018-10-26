package study.jar.jctools;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import io.netty.util.collection.LongObjectHashMap;
import org.jctools.maps.ConcurrentAutoTable;
import org.jctools.maps.NonBlockingHashMap;
import org.jctools.maps.NonBlockingHashMapLong;
import org.jctools.maps.NonBlockingIdentityHashMap;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2018/6/16.
 */
public class NonBlockingIdentityHashMapTest {
    private static int count=100000;
    private static int threadNum=200;
    NonBlockingHashMap map = new NonBlockingHashMap();
    ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
    NonBlockingIdentityHashMap nonBlockingIdentityHashMap=new NonBlockingIdentityHashMap();
    NonBlockingHashMapLong nonBlockingHashMapLong=new NonBlockingHashMapLong();
    LongObjectHashMap longObjectHashMap=new LongObjectHashMap();
    @Test
    public void test(){
//        new Thread(()->{
//            while (true) {
//                concurrentHashMap.put("123", "123");
//                map.put("123", "123");
//                nonBlockingIdentityHashMap.put("123", "123");
//            }
//        }).start();

        nonBlockingIdentityHashMap.put("123", "123");
        System.out.println(nonBlockingIdentityHashMap.get("123"));
        for (int i = 0; i < 10000; i++) {
            
        }
        Tests.thReadForEach(new RunableForEach("concurrentHashMap",threadNum,count) {
            public void action()  {
                concurrentHashMap.put("123", "123");
                concurrentHashMap.get("123");
                concurrentHashMap.remove("123");
            }
        });

        Tests.thReadForEach(new RunableForEach("NonBlockingHashMap",threadNum,count) {
            public void action()  {
                map.put("123", "123");
                map.get("123");
                map.remove("123");
            }
        });
        Tests.thReadForEach(new RunableForEach("nonBlockingIdentityHashMap",threadNum,count) {
            public void action()  {
                nonBlockingIdentityHashMap.put("123", "123");
                nonBlockingIdentityHashMap.get("123");
                nonBlockingIdentityHashMap.remove("123");
            }
        });
        Tests.thReadForEach(new RunableForEach("nonBlockingHashMapLong",threadNum,count) {
            public void action()  {
                nonBlockingHashMapLong.put(123, "123");
                nonBlockingHashMapLong.get(123);
                nonBlockingHashMapLong.remove(123);
            }
        });
//        Tests.thReadForEach(new RunableForEach("longObjectHashMap",threadNum,count) {
//            public void action()  {
//                longObjectHashMap.put(123, "123");
//                longObjectHashMap.get(123);
//                longObjectHashMap.remove(123);
//            }
//        });

    }
}
