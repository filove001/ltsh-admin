package study.java8;

/**
 * @Author: fengjianzhong
 * @Date: 2018/6/21 10:40
 * @Description:
 */
public class RingBuffer1 {
    private final static int bufferSize = 1024;
    private String[] buffer = new String[bufferSize];
    private int head = 0;
    private int tail = 0;

    private Boolean empty() {
        return head == tail;
    }
    private Boolean full() {
        return (tail + 1) % bufferSize == head;
    }
    public Boolean put(String v) {
        if (full()) {
            return false;
        }
        buffer[tail] = v;
        tail = (tail + 1) % bufferSize;
        return true;
    }
    public String get() {
        if (empty()) {
            return null;
        }
        String result = buffer[head];
        head = (head + 1) % bufferSize;
        return result;
    }
    public String[] getAll() {
        if (empty()) {
            return new String[0];
        }
        int copyTail = tail;
        int cnt = head < copyTail ? copyTail - head : bufferSize - head + copyTail;
        String[] result = new String[cnt];
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
