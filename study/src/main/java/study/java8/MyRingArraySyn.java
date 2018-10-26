package study.java8;

import com.fjz.util.Times;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 环形数组
 * 线程安全
 * @Author: fengjianzhong
 * @Date: 2018/6/21 10:40
 * @Description:
 */
public class MyRingArraySyn<T> {
    private int bufferSize;
    private T[] buffer;
    private int head = 0;
    private int tail = 0;
    private Class<T> type;
    final T EMPTY = null;
    private RingArray<T> ringArray;
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    public MyRingArraySyn(Class<T> type, int length) {
        this.bufferSize = length <= 0 ? 2<<16 : length; // 默认2^16
        this.type=type;
        this.buffer = (T[]) Array.newInstance(type, this.bufferSize);
        ringArray = new RingArray<T>(type, 1000);
//        executor.submit(()->{
//            T t= ringArray.getLoop();
//            if (t != null) {
//                buffer[tail] = t;
//                tail = (tail + 1) % bufferSize;
//            }
//        });
    }
    private Boolean empty() {
        return head == tail;
    }
    private Boolean full() {
        return (tail + 1) % bufferSize == head;
    }
    public Boolean put(T v) {
        if (buffer[tail]!=null) {
//            synchronized (this) {
                tail = (tail + 1) % bufferSize;
                return put(v);
//            }
        }
        buffer[tail] = v;
        tail = (tail + 1) % bufferSize;
        return true;
    }
    final ReentrantLock lock=new ReentrantLock(false);
    public T get() {
        if (head >= tail) {
            throw new RuntimeException("为空！");
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            T result = buffer[head];
            if (result == null) {
                head = (head + 1) % bufferSize;
                return get();
            }
            buffer[head] = null;
            head = (head + 1) % bufferSize;
            return result;
        }finally {
            lock.unlock();
        }
    }
    public static AtomicInteger index = new AtomicInteger(0);
    private static int size=1000000;
    public static void main(String[] args) {
//        MyRingBuffer myRingBuffer = new MyRingBuffer<>(String.class,0);
//        for (int i = 0; i < 2048; i++) {
//            myRingBuffer.put(i+"");
//        }
        int tCount = 10; // thread count
        int length = 0;  // buffer length -> 2^16
        final MyRingArraySyn<Integer> buffer = new MyRingArraySyn<Integer>(Integer.class, length);
        Times times=new Times();
        // provider
        Runnable pr = new Runnable(){
            @Override
            public void run() {
                while(true){
                    int tindex = index.getAndIncrement();
                    if (tindex >= size) {
                        break;
                    }
                    buffer.put(tindex);

                }
            }
        };
        // consumer
        Runnable cr = new Runnable(){
            @Override
            public void run() {
                while(true){

                    try {
                        Integer tindex = buffer.get();
                        if (tindex!=null&&tindex == size-1) {
                            System.out.println(times.getTimeDifference());
                            break;
                        } else if (tindex!=null&&tindex > size-1) {
                            break;
                        }
                    } catch (Exception e) {
//                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        for(int i=0; i<tCount; i++){
            new Thread(pr).start();
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for(int i=0; i<tCount; i++){
            new Thread(cr).start();
        }
//        for(int i=0; i<tCount; i++){
//            new Thread(pr).start();
//        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(Arrays.toString(buffer.buffer));
        int num=0;
        for (int i = 0; i < buffer.buffer.length; i++) {
            if (buffer.buffer[i] == null) {
                num++;
            }else  if(i != buffer.buffer[i]) {
//                System.out.println(i+"  "+ buffer.buffer[i]);
            }
        }
        System.out.println(num+"  "+buffer.buffer.length+"  "+buffer.tail);
    }
}
