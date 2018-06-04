package study.jar.smart.socket;

import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

/**
 * Created by Administrator on 2018/5/31.
 */
public class IntegerServer {
    public static void main(String[] args) {
        AioQuickServer server = new AioQuickServer(8888,new IntegerProtocol(),new IntegerServerProcessor());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}