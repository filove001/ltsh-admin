package study.java8;

import com.fjz.util.Times;

import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 环形数组
 * 线程安全
 * @Author: fengjianzhong
 * @Date: 2018/6/21 10:40
 * @Description:
 */
public class RingArraySyn<T> {
    private int bufferSize;
    private T[] buffer;
    private int head = 0;
    private int tail = 0;
    private Class<T> type;
    final T EMPTY = null;
    private RingArray<T> ringArray;
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    public RingArraySyn(Class<T> type, int length) {
        this.bufferSize = length <= 0 ? 2<<16 : length; // 默认2^16
        this.type=type;
        this.buffer = (T[]) Array.newInstance(type, this.bufferSize);
        ringArray = new RingArray<T>(type, 1000);
        executor.submit(()->{
            T t= ringArray.getLoop();
            if (t != null) {
                buffer[tail] = t;
                tail = (tail + 1) % bufferSize;
            }
        });
    }
    private Boolean empty() {
        return head == tail;
    }
    private Boolean full() {
        return (tail + 1) % bufferSize == head;
    }
    public Boolean put(T v) {
        ringArray.put(v);
        return true;
    }
    public T get() {
        //buffer[head]==null 说明是空的还没有put值，循环不获取
        while (buffer[head]==null);
        T result = buffer[head];
        buffer[head]=null;
        head = (head + 1) % bufferSize;
        return result;
    }
    public static AtomicInteger index = new AtomicInteger(0);
    private static int size=100;
    public static void main(String[] args) {
//        MyRingBuffer myRingBuffer = new MyRingBuffer<>(String.class,0);
//        for (int i = 0; i < 2048; i++) {
//            myRingBuffer.put(i+"");
//        }
        int tCount = 10; // thread count
        int length = 0;  // buffer length -> 2^16
        final RingArraySyn<Integer> buffer = new RingArraySyn<Integer>(Integer.class, length);
        Times times=new Times();
        // provider
        Runnable pr = new Runnable(){
            @Override
            public void run() {
                while(true){
                    int tindex = index.getAndIncrement();
                    buffer.put(tindex);
                    if (tindex >= size) {
                        break;
                    }
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
                    try {
                        Integer tindex = buffer.get();
//                    System.out.println(tindex+" "+times.getTimeDifferenceNanoTime());
                        if (tindex == size) {
                            System.out.println(times.getTimeDifference());
                            break;
                        } else if (tindex > size) {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
