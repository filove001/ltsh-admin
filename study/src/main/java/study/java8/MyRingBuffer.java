package study.java8;

import com.fjz.util.Times;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 */
public class MyRingBuffer<T> implements Serializable {
    private int bufferSize;
    private T[] buffer;

    private AtomicInteger headAtomic=new AtomicInteger(0);
    private AtomicInteger tailAtomic=new AtomicInteger(0);
    private Class<T> type;
    final T EMPTY = null;
    public MyRingBuffer(Class<T> type, int length) {
        this.buffer = buffer;
        this.bufferSize = length <= 0 ? 2<<16 : length; // 默认2^16
        this.type=type;
        this.buffer = (T[]) Array.newInstance(type, this.bufferSize);
    }

    private Boolean empty() {
        return headAtomic.get() == tailAtomic.get();
    }
    private Boolean full() {
        return (tailAtomic.get() + 1) % bufferSize == headAtomic.get();
    }
    public Boolean put(T v) {
//        if (full()) {
//            return false;
//        }
        while (full());
        int tail=tailAtomic.getAndIncrement();
        buffer[getTail(tail)] = v;
//        tail = (tail + 1) % bufferSize;
        return true;
    }
    public int getTail(){
        return  tailAtomic.get();
    }

    public int getHead(){
        return  headAtomic.get();
    }
    public int getTail(int tail){
        return  (tail + 1) % bufferSize;
    }

    public int getHead(int head){
        return  (head + 1) % bufferSize;
    }
    public T get() {
        while (empty());
        int head=headAtomic.getAndIncrement();
        T result=null;

        int tempHead=getHead(head);
        //防止 tailAtomic加了，buffer 没有设置值
        while ((result=buffer[tempHead]) == null);
        buffer[tempHead]=EMPTY;
        return result;
    }

    public static AtomicInteger index = new AtomicInteger(0);
    private static int size=100000;
    public static void main(String[] args) {
//        MyRingBuffer myRingBuffer = new MyRingBuffer<>(String.class,0);
//        for (int i = 0; i < 2048; i++) {
//            myRingBuffer.put(i+"");
//        }
        int tCount = 10; // thread count
        int length = 0;  // buffer length -> 2^16
        final MyRingBuffer<Integer> buffer = new MyRingBuffer<Integer>(Integer.class, length);
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
                        System.out.println(buffer.getHead());
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