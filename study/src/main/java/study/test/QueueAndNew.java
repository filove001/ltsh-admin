package study.test;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Administrator on 2018/6/15.
 */
public class QueueAndNew {
    private static int count=10000;
    private static int threadNum=20;
//    private static LongAdder atomicLong=new LongAdder();
    private static BlockingQueue<Request> queue = new ArrayBlockingQueue(1000);
    public static AtomicLong atomicLong = new AtomicLong();
    public static Request[] requests = new Request[1000];
    @Test
    public void test() throws InterruptedException {
        Tests.thReadForEach(new RunableForEach("new",threadNum,count) {
            @Override
            public void action()  {
                try {
                    Request request = Request.createRequest("", "", "", "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        new Thread(()->{
            try {
                while (true) {
                    for (int i = 0; i < requests.length; i++) {
                        if(requests[i]==null){
                            requests[i] = Request.createRequest("", "", "", "");
                        }
                    }

                }
//                for (int i = 0; i < count * threadNum; i++) {
////                    queue.put( Request.createRequest("", "", "", ""));
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(()-> {
//            while (true) {
//                if (atomicLong.intValue() > 600) {
//                    System.out.println("================");
//                    atomicLong.set(0);
//                }
//            }
//        }
//        ).start();
        Thread.sleep(1000);
        Tests.thReadForEach(new RunableForEach("new",threadNum,count) {
            @Override
            public void action()  {
                try {
                    int index=(int)atomicLong.getAndIncrement();
                    if (index > 900) {
                        atomicLong.set(0);
                    }
                    Request request = requests[index];//queue.take();
                    request.setId(index);
//                    request.setId(atomicLong.incrementAndGet());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        Thread.sleep(100000);
    }
}
