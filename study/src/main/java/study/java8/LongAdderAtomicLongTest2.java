package study.java8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Administrator on 2018/6/7.
 */
public class LongAdderAtomicLongTest2 {
    private static long count = 100000000;
    private static int threads = Runtime.getRuntime().availableProcessors();

    private static String type = "atomic";

    private static CountDownLatch startLatch;
    private static CountDownLatch endLatch;

    private static ExecutorService executorService;

    private static AtomicLong totalTime = new AtomicLong(0);

    private static AtomicLong atomicCount = new AtomicLong();
    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        threads = Integer.valueOf(System.getProperty("threads", String.valueOf(threads)));
        count = Long.valueOf(System.getProperty("count", String.valueOf(count)));
        type = System.getProperty("count", type);
        executorService = Executors.newFixedThreadPool(threads);
        startLatch = new CountDownLatch(1);
        endLatch = new CountDownLatch(threads);

        creatThread();

        startLatch.countDown();
        System.out.println("启动测试...");
        endLatch.await();
        System.out.println("Counter：" + getLong());

        System.out.println("测试结束...");
        System.out.println("avg time:" + totalTime.longValue()/1000/threads);
        System.out.println("tps:" + (getLong()/(totalTime.longValue()/1000/threads)));
        System.out.println(sum);
        executorService.shutdown();
    }

    private static long getLong() {
        if("atomic".equals(type))
            return atomicCount.longValue();
        else if("longAdder".equals(type))
            return longAdder.longValue();
        else
            return 0l;
    }

    private static long incr() {
        if("atomic".equals(type))
            return atomicCount.incrementAndGet();
        else if("longAdder".equals(type)) {
            longAdder.increment();
            return longAdder.longValue();
        }
        return 0;
    }
    private static long sum=0;
    private static void creatThread() {
        for(int i = 0; i < threads; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        long startTime = System.currentTimeMillis();

                        for(int j=0; j<count; j++)
                            sum=incr();

                        long time = System.currentTimeMillis() - startTime;
                        totalTime.addAndGet(time);
                        endLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
