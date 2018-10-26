package study.jar.disruptor;

/**
 * @description disruptor代码样例。每10ms向disruptor中插入一个元素，消费者读取数据，并打印到终端
 */
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;


public class DisruptorMain
{
    public static void main(String[] args) throws Exception
    {
        // 队列中的元素
        class Element {
            private int value;
            public int get(){
                return value;
            }
            public void set(int value){
                this.value= value;
            }
        }

        // 生产者的线程工厂
        ThreadFactory threadFactory = new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "simpleThread");
            }
        };

        // RingBuffer生产工厂,初始化RingBuffer的时候使用
        EventFactory<Element> factory = new EventFactory<Element>() {
            @Override
            public Element newInstance() {
                return new Element();
            }
        };

        // 处理Event的handler
        EventHandler<Element> handler = new EventHandler<Element>(){
            @Override
            public void onEvent(Element element, long sequence, boolean endOfBatch)
            {
                System.out.println("Element: " + element.get());
            }
        };
//        BlockingWaitStrategy	加锁	                        CPU资源紧缺，吞吐量和延迟并不重要的场景
//        BusySpinWaitStrategy	自旋	                        通过不断重试，减少切换线程导致的系统调用，而降低延迟。推荐在线程绑定到固定的CPU的场景下使用
//        PhasedBackoffWaitStrategy	自旋 + yield + 自定义策略	CPU资源紧缺，吞吐量和延迟并不重要的场景
//        SleepingWaitStrategy	自旋 + yield + sleep	        性能和CPU资源之间有很好的折中。延迟不均匀
//        TimeoutBlockingWaitStrategy	加锁，有超时限制	    CPU资源紧缺，吞吐量和延迟并不重要的场景
//        YieldingWaitStrategy	自旋 + yield + 自旋	            性能和CPU资源之间有很好的折中。延迟比较均匀
        // 阻塞策略
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();

        // 指定RingBuffer的大小
        int bufferSize = 16;

        // 创建disruptor，采用单生产者模式
        Disruptor<Element> disruptor = new Disruptor(factory, bufferSize, threadFactory, ProducerType.SINGLE, strategy);

        // 设置EventHandler
        disruptor.handleEventsWith(handler);

        // 启动disruptor的线程
        disruptor.start();

        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();

        for (int l = 0; true; l++)
        {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try
            {
                // 返回可用位置的元素
                Element event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.set(l);
            }
            finally
            {
                ringBuffer.publish(sequence);
            }
            Thread.sleep(10);
        }
    }
}