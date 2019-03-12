package study.test;

import com.fjz.util.Kv;
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
public class MapAndNewBean {
    private static int count=10000000;
    private static int threadNum=100;
    @Test
    public void test() throws IOException {
        Tests.thReadForEach(new RunableForEach("new",threadNum,count) {
            @Override
            public void action()  {
                RpcInvocation r=new RpcInvocation();
//                r.setMethodName("abc");
//                r.setParameterTypes("abc");
//                r.getMethodName();
//                r.getParameterTypes();
            }
        });
        Tests.thReadForEach(new RunableForEach("map",threadNum,count) {
            @Override
            public void action()  {
                Map<String,Object> map = new HashMap(2);
//                map.put("methodName", "abc");
//                map.put("parameterTypes", "abc");
//                map.get("methodName");
//                map.get("parameterTypes");
//                Kv kv = Kv.by("methodName", "abc").set("parameterTypes", "abc");
            }
        });
    }
}
