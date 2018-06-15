package study.test;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.junit.Test;
import study.java8.RpcInvocation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by Administrator on 2018/6/11.
 */
public class MapAndStringByte {
    private static int count=1000000;
    private static int threadNum=300;
    static Map<String, byte[]> data = new HashMap<>(100);
    static Map<String, byte[]> dataMap = new ConcurrentHashMap<>(100);
    byte[] byte111=null;
    @Test
    public void test() throws IOException {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        String obj = "123";
        System.out.println(Arrays.toString(("\""+obj+"\"\n").getBytes()));
        writer.write('"');
        writer.write(obj.getBytes());
        writer.write('"');
        writer.write('\n');
        System.out.println(Arrays.toString((writer.toByteArray())));

//        data.put(null, "null\n".getBytes());
//        System.out.println(data.get(null));
//        RpcInvocation inv = new RpcInvocation();
//        inv.setAttachment("dubbo","2.0.1");
//        inv.setAttachment("path","com.alibaba.dubbo.performance.demo.provider.IHelloService");
//        inv.setAttachment("version","2.22");
//        inv.setMethodName("hash");
//        inv.setParameterTypes("Ljava/lang/String;");
        Tests.thReadForEach(new RunableForEach("map",threadNum,count) {
            @Override
            public void action()  {
                RpcInvocation inv = new RpcInvocation();
                inv.setAttachment("dubbo","2.0.1");
                inv.setAttachment("path","com.alibaba.dubbo.performance.demo.provider.IHelloService");
                String path = inv.getAttachment("path");
                byte[] bytes = dataMap.get(path);
                if (bytes==null) {
                    bytes = path.getBytes();
                    dataMap.put(path, bytes);
                }
                byte111=bytes;
            }
        });
        Tests.thReadForEach(new RunableForEach("ConcurrentHashMap",threadNum,count) {
            @Override
            public void action()  {
                RpcInvocation inv = new RpcInvocation();
                inv.setAttachment("dubbo","2.0.1");
                inv.setAttachment("path","com.alibaba.dubbo.performance.demo.provider.IHelloService");
                String path = inv.getAttachment("path");
                byte[] bytes = data.get(path);
                if (bytes==null) {
                    bytes = path.getBytes();
                    data.put(path, bytes);
                }
                byte111=bytes;
            }
        });
        Tests.thReadForEach(new RunableForEach("getBytes",threadNum,count) {
            @Override
            public void action()  {
//                byte111 = inv.getAttachment("path").getBytes();
            }

        });
    }
}
