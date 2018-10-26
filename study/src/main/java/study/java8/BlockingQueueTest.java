package study.java8;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import com.fjz.util.Times;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * RingBuffer测试
 */
public class BlockingQueueTest{
    public static AtomicInteger index = new AtomicInteger(0);
    private static int count=10000;
    private static int threadNum=200;
    private static int size=1000000;
    public static ArrayBlockingQueue queue=new ArrayBlockingQueue(size);
    static int tCount = 10; // thread count
    public static void main(String[] args){
        Times times=new Times();
        Runnable pr = new Runnable(){
            @Override
            public void run() {
                while(true) {
                    int tindex = index.getAndIncrement();
                    try {
                        queue.put(tindex);
                        if (tindex >= size) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable cr = new Runnable(){
            @Override
            public void run() {
                while(true){
                    try {
                        int tindex =(int)queue.take();
//                        System.out.println(tindex+" "+times.getTimeDifferenceNanoTime());
                        if (tindex >= size) {
                            if(tindex == size) {
                                System.out.println(times.getTimeDifference());
                            }
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        for(int i=0; i<tCount; i++){
            new Thread(cr).start();
        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for(int i=0; i<tCount; i++){
            new Thread(pr).start();
        }
    }
}