package study.java8;

import com.fjz.util.Times;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * RingBuffer测试
 */
public class TestBuffer {
    public static AtomicInteger index = new AtomicInteger(0);
    private static int size=100000;
    public static void main(String[] args){
        int tCount = 10; // thread count
        int length = 0;  // buffer length -> 2^16
        final RingBuffer<Integer> buffer = new RingBuffer<Integer>(Integer.class, length);
        Times times=new Times();
        // provider
        Runnable pr = new Runnable(){
            @Override
            public void run() {
                while(true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    int tindex = index.getAndIncrement();
                    buffer.enQueue(tindex);
                    if (tindex >= size) {
                        break;
                    }
//                    System.out.println("buffer enQueue: " + tindex);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        // consumer
        Runnable cr = new Runnable(){
            @Override
            public void run() {
                while(true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    Integer tindex = buffer.deQueue();
//                    System.out.println(tindex+" "+times.getTimeDifferenceNanoTime());
                    if (tindex == size) {
                        System.out.println(times.getTimeDifference());
                        break;
                    } else if (tindex > size) {
                        break;
                    }
//                    System.out.println("buffer deQueue: " + cindex);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        for(int i=0; i<tCount; i++){
            new Thread(cr).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<tCount; i++){
            new Thread(pr).start();
        }
    }
}