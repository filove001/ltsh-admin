package study.test;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.junit.Test;
import study.java8.RpcInvocation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * Created by Administrator on 2018/6/11.
 */
public class ArrayAndMap {
    private static int count=100;
    private static int threadNum=200;
    static AtomicLong atomicLong = new AtomicLong();
    static AtomicLong atomicLongArr = new AtomicLong();
    @Test
    public void test() throws IOException {
        RpcInvocation inv = new RpcInvocation();
        inv.setAttachment("dubbo","2.0.1");
        inv.setAttachment("path","com.alibaba.dubbo.performance.demo.provider.IHelloService");
        inv.setAttachment("version","2.22");
        inv.setMethodName("hash");
        inv.setParameterTypes("Ljava/lang/String;");
        for (int i = 0; i < count; i++) {
            MapTemp.put(i+"",inv);
            Arr.put(i + "", inv);
//            RpcInvocation r=MapTemp.get(atomicLong.incrementAndGet()+"");
        }
        Tests.thReadForEach(new RunableForEach("map",threadNum,count) {
            @Override
            public void action()  {
                int index=(int)atomicLong.incrementAndGet();
                RpcInvocation rpcInvocation = MapTemp.get(index + "");
                if (rpcInvocation != null) {
                    MapTemp.remove(index+"");
                    MapTemp.put(index+"",rpcInvocation);
                }
            }
        });

        Tests.thReadForEach(new RunableForEach("array",threadNum,count) {
            @Override
            public void action()  {
                int index=(int)atomicLongArr.incrementAndGet();
                RpcInvocation rpcInvocation = Arr.get(index + "");
//                if (rpcInvocation != null) {
//                    Arr.remove(index+"");
//                    Arr.put(index+"",rpcInvocation);
//                }
            }
        });
    }
    public static class MapTemp{
        private static ConcurrentHashMap<String,RpcInvocation> processingRpc = new ConcurrentHashMap<>();
        public static void put(String requestId,RpcInvocation rpcFuture){
            processingRpc.put(requestId,rpcFuture);
        }

        public static RpcInvocation get(String requestId){
            return processingRpc.get(requestId);
        }

        public static void remove(String requestId){
            processingRpc.remove(requestId);
        }
//    }
    }
    public static class Arr {
            private static RpcInvocation[] processingRpcArr = new RpcInvocation[10000];
    public static void put(String requestId,RpcInvocation rpcFuture){
        int id = Integer.parseInt(requestId);
        if (id > 9000) {
            id = 9000;
            atomicLongArr.set(0);
        }
        processingRpcArr[id]=rpcFuture;
    }

    public static RpcInvocation get(String requestId){
        int id = Integer.parseInt(requestId);
        return processingRpcArr[id];
    }

    public static void remove(String requestId){
        int id = Integer.parseInt(requestId);
        processingRpcArr[id]=null;
    }
    }
}
