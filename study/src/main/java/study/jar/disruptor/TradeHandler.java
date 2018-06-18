package study.jar.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * Created by Administrator on 2018/6/16.
 */
// 消费者, 这里实现一个接口就行, 写两个是为了同时测试EventProcessor和WorkPool
public class TradeHandler implements EventHandler<Trade>, WorkHandler<Trade> {
    @Override
    public void onEvent(Trade event, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(event);
    }
    @Override
    public void onEvent(Trade event) throws Exception {
        //具体的消费逻辑
        System.out.println(event.getId()+" "+event.getPrice());
    }
}