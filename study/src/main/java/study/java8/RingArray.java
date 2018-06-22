package study.java8;

import java.lang.reflect.Array;

/**
 * 环形数组
 * 线程不安全
 * @Author: fengjianzhong
 * @Date: 2018/6/21 10:40
 * @Description:
 */
public class RingArray<T> {
    private int bufferSize;
    private T[] buffer;
    private int head = 0;
    private int tail = 0;
    private Class<T> type;
    final T EMPTY = null;
    public RingArray(Class<T> type, int length) {
        this.bufferSize = length <= 0 ? 2<<16 : length; // 默认2^16
        this.type=type;
        this.buffer = (T[]) Array.newInstance(type, this.bufferSize);
    }
    private Boolean empty() {
        return head == tail;
    }
    private Boolean full() {
        return (tail + 1) % bufferSize == head;
    }
    public Boolean put(T v) {
        //如果buffer不是空，证明get()，循环,等get后再put
        while (buffer[tail]!=null);
        buffer[tail] = v;
        tail = (tail + 1) % bufferSize;
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
    public T[] getAll() {
        if (empty()) {
            return  (T[]) Array.newInstance(type,0);
        }
        int copyTail = tail;
        int cnt = head < copyTail ? copyTail - head : bufferSize - head + copyTail;
        T[] result =(T[]) Array.newInstance(type,cnt);
        if (head < copyTail) {
            for (int i = head; i < copyTail; i++) {
                result[i - head] = buffer[i];
            }
        } else {
            for (int i = head; i < bufferSize; i++) {
                result[i - head] = buffer[i];
            }
            for (int i = 0; i < copyTail; i++) {
                result[bufferSize - head + i] = buffer[i];
            }
        }
        head = copyTail;
        return result;
    }
}
