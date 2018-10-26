package study.jar.netty.bytes;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/5/26.
 */
public class MessageObject implements Serializable {
    private static String[] fields=null;
    static {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(MessageObject.class);
        fields = new String[propertyDescriptors.length];
        for (int i = 0; i < propertyDescriptors.length; i++) {
            fields[i] = propertyDescriptors[i].getName();
        }
        System.out.println(Arrays.toString(fields));
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new MessageObject()));
        System.out.println(new MessageObject().toString());
        System.out.println(new MessageObject().toString().getBytes().length);
    }
    public String interfaceName; // required
    public String method; // required
    public String parameterTypesString; // required
    public String parameter; // required
    public String requestTime; // required
    public long requestId; // required
    public long responseTime; // required
    public long receiveTime; // required
    public String result; // required
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

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(long receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static MessageObject getMessageObject(byte[] bytes){
        return null;
    }

    @Override
    public String toString() {
        return interfaceName +
                "," + method +
                "," + parameterTypesString +
                "," + parameter +
                "," + requestTime +
                "," + requestId +
                "," + responseTime +
                "," + receiveTime +
                "," + result;
    }

    public static byte[] getBytes(MessageObject object){
        return null;
    }
}
