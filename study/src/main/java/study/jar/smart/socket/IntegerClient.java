package study.jar.smart.socket;

import org.smartboot.socket.transport.AioQuickClient;

/**
 * Created by Administrator on 2018/5/31.
 */
public class IntegerClient {
    public static void main(String[] args) throws Exception {
        IntegerClientProcessor processor=new IntegerClientProcessor();
        AioQuickClient aioQuickClient=new AioQuickClient("localhost",8888,new IntegerProtocol(),processor);
        aioQuickClient.start();
        processor.getSession().write(1);
        Thread.sleep(1000);
        aioQuickClient.shutdown();
    }
}