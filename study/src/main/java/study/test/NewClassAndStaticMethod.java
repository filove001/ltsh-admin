package study.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import com.fjz.util.Times;
import io.netty.channel.ChannelHandlerContext;
import org.junit.Test;
import study.java8.RpcInvocation;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Administrator on 2018/6/13.
 */
public class NewClassAndStaticMethod {
    public static ResultCallback invoke(String interfaceName, String method, String parameterTypesString, String parameter) {
        ResultCallback callback=new ResultCallback() {
            public void callback(Object result) {
                String string = interfaceName + method + parameterTypesString + parameter;
            }
        };
        return callback;
    }
//    public static Param invokeParam(String interfaceName, String method, String parameterTypesString, String parameter) {
//        return new Param(interfaceName, method, parameterTypesString, parameter);
//    }
    private static int count=100000;
    private static int threadNum=300;
    private static LongAdder atomicLong=new LongAdder();
    @Test
    public void test(){
        Tests.thReadForEach(new RunableForEach("callback",threadNum,count) {
            @Override
            public void action()  {
                put(atomicLong.longValue()+"",invoke("123","123","123","123"));
            }
        });
        Times times = new Times();
        times.longTime(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<String, ResultCallback> e : processingRpc.entrySet()) {
                    e.getValue().callback(e);
                    processingRpc.remove(e.getKey());
                }
            }
        });
        atomicLong.reset();
        Tests.thReadForEach(new RunableForEach("staticMethod",threadNum,count) {
            @Override
            public void action()  {
                putParam(atomicLong.longValue() + "", new Param("123", "123", "123", "123"));
            }
        });
        times.longTime(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<String, Param> e : mapParam.entrySet()) {
                    callback(e.getValue(),e);
                    processingRpc.remove(e.getKey());
                }
            }
        });
    }
    class Param{
        private String interfaceName;
        private String method;
        private String parameterTypesString;
        private String parameter;

        public Param(String interfaceName, String method, String parameterTypesString, String parameter) {
            this.interfaceName = interfaceName;
            this.method = method;
            this.parameterTypesString = parameterTypesString;
            this.parameter = parameter;
        }

        public String getInterfaceName() {
            return interfaceName;
        }

        public void setInterfaceName(String interfaceName) {
            this.interfaceName = interfaceName;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getParameterTypesString() {
            return parameterTypesString;
        }

        public void setParameterTypesString(String parameterTypesString) {
            this.parameterTypesString = parameterTypesString;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }

    public static void callback(Param param,Object result){
        String string = param.getParameterTypesString() + param.getMethod() + param.getParameterTypesString() + param.getParameter();
    }
    public interface ResultCallback {
        void callback(Object result);
    }

    private static ConcurrentHashMap<String,Param> mapParam = new ConcurrentHashMap<>();
    public static void putParam(String requestId,Param rpcFuture){
        mapParam.put(requestId,rpcFuture);
    }

    public static Param getParam(String requestId){
        return mapParam.get(requestId);
    }
    public static void removeParam(String requestId){
        mapParam.remove(requestId);
    }


    private static ConcurrentHashMap<String,ResultCallback> processingRpc = new ConcurrentHashMap<>();
    public static void put(String requestId,ResultCallback rpcFuture){
        processingRpc.put(requestId,rpcFuture);
    }

    public static ResultCallback get(String requestId){
        return processingRpc.get(requestId);
    }

    public static void remove(String requestId){
        processingRpc.remove(requestId);
    }
}
