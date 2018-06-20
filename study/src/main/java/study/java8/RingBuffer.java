package study.java8;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并发生产者和消费者数不能多于queue的length，默认是2^16
 * 简易版 无锁并发框架，基于一个环数组作为缓冲
 */
public class RingBuffer<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6976960108708949038L;

    private volatile AtomicInteger head;

    private volatile AtomicInteger tail;

    private int length;

    final T EMPTY = null;

    private volatile T[] queue;

    public RingBuffer(Class<T> type, int length){
        this.head = new AtomicInteger(0);
        this.tail = new AtomicInteger(0);
        this.length = length == 0 ? 2 << 16 : length; // 默认2^16
        this.queue = (T[]) Array.newInstance(type, this.length);
    }

    public void enQueue(T t){
        if(t == null) t= (T) new Object();
        // 阻塞 -- 避免多生成者循环生产同一个节点
        while(this.getTail() - this.getHead() >= this.length);
        int ctail = this.tail.getAndIncrement();
        while(this.queue[this.getTail(ctail)] != EMPTY); // 自旋
        this.queue[this.getTail(ctail)] = t;
    }

    public T deQueue(){
        T t = null;
        // 阻塞 -- 避免多消费者循环消费同一个节点
        while(this.head.get() >= this.tail.get());
        int chead = this.head.getAndIncrement();
        while(this.queue[this.getHead(chead)] == EMPTY); // 自旋
        t = this.queue[this.getHead(chead)];

        System.out.println(this.getHead(chead));
        this.queue[this.getHead(chead)] = EMPTY;
        return t;
    }

    public int getHead(int index){
        return index & (this.length - 1);
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i>>1);
//        }
////        System.out.println(13&(10-1));
//    }
    public int getTail(int index) {
        return index & (this.length - 1);
    }

    public int getHead() {
        return head.get() & (this.length - 1);
    }

    public int getTail() {
        return tail.get() & (this.length - 1);
    }

    public T[] getQueue() {
        return queue;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}