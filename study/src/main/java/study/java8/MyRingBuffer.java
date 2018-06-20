//package study.java8;
//
//import java.io.Serializable;
//import java.lang.reflect.Array;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.atomic.AtomicLong;
//
///**
// * 并发生产者和消费者数不能多于queue的length，默认是2^16
// * 简易版 无锁并发框架，基于一个环数组作为缓冲
// */
//public class MyRingBuffer<T> implements Serializable {
//    private Object[] ringBuffer = null;
//    private Object[] ringBuffer = null;
//    private AtomicInteger offerSeq = new AtomicInteger(-1);
//    private AtomicInteger takeSeq = new AtomicInteger(-1);
//    private int size;
//    private int mask;
//
//    public OptimisticQueue(int sizePower) {
//        this.size = 1 &lt;&lt; sizePower;
//        this.ringBuffer = new Object[size];
//        for (int i = 0; i &lt; size; i++) {
//            ringBuffer[i] = new Entry(i + 1);
//        }
//        this.mask = 0x7FFFFFFF >> (31 - sizePower);
//    }
//
//    @SuppressWarnings("unchecked")
//    private Entry nextOffer() {
//        return (Entry) ringBuffer[offerSeq.incrementAndGet() & mask];
//    }
//
//    @SuppressWarnings("unchecked")
//    private Entry nextTake() {
//        return (Entry) ringBuffer[takeSeq.incrementAndGet() & mask];
//    }
//}