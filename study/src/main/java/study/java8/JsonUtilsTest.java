package study.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.PooledByteBufAllocator;
import net.minidev.json.JSONValue;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ken.lj
 * @date 02/04/2018
 */
public class JsonUtilsTest {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        StringWriter writer1 = new StringWriter();
        RpcInvocation inv = new RpcInvocation();
        inv.setAttachment("dubbo","2.0.1");
        inv.setAttachment("path","/");
        inv.setAttachment("version","/");
        inv.setMethodName("name");
        inv.setParameterTypes("name");

        inv.setArguments(new byte[]{0,1});
//        writeObject(inv, writer,true);
//        System.out.println(JSON.toJSONString(inv.getAttachments()));
//        System.out.println(mapToJson(inv.getAttachments()));
//        ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer();
//        byteBuf.writeBytes(new String("123").getBytes());
//        byteBuf.writeBytes(new String("123").getBytes());
//        writeObject( "2.0.1", byteBuf);
//        System.out.println(new String(ByteBufUtil.getBytes(byteBuf)));
//        writeObject(inv, byteBuf);
//        System.out.println(new String(ByteBufUtil.getBytes(byteBuf)));
//            JsonUtils.writeObject(inv,byteBuf);
//            System.out.println(byteBuf.readableBytes());
//            byte[] bytes = ByteBufUtil.getBytes(byteBuf);

    }
    public static String mapToJson(Map<String,String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            sb.append("{");
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                sb.append("\"").append(stringStringEntry.getKey()).append("\"").append(":").
                        append("\"").append(stringStringEntry.getValue()).append("\"").append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("}");
        }
        return sb.toString();
    }
    public static void writeObject(RpcInvocation inv, ByteBuf writer) throws IOException {
        writeObject(inv.getAttachment("dubbo", "2.0.1"), writer);
        writeObject(inv.getAttachment("path"), writer);
        writeObject(inv.getAttachment("version"), writer);
        writeObject(inv.getMethodName(), writer);
        writeObject(inv.getParameterTypes(), writer);
        writer.writeBytes(new String(inv.getArguments()).getBytes());
        writer.writeBytes(mapToJson(inv.getAttachments()).getBytes());
        writer.writeByte('\n');
    }
    public static void writeObject(String msg, ByteBuf byteBuf) throws IOException {
//        ByteBufUtil.writeAscii(byteBuf, getWriterString(msg));
        byteBuf.writeBytes(getWriterString(msg).getBytes());
        byteBuf.writeByte('\n');
    }
    public static void writeObject(RpcInvocation inv, ByteArrayOutputStream writer) throws IOException {
        writeObject(inv.getAttachment("dubbo", "2.0.1"), writer);
        writeObject(inv.getAttachment("path"), writer);
        writeObject(inv.getAttachment("version"), writer);
        writeObject(inv.getMethodName(), writer);
        writeObject(inv.getParameterTypes(), writer);
        writer.write(new String(inv.getArguments()).getBytes());
        writer.write(mapToJson(inv.getAttachments()).getBytes());
        writer.write('\n');
        writer.flush();
    }

    private static final byte[] nullByte = "null".getBytes();
    public static void writeObject(Object obj, ByteArrayOutputStream writer) throws IOException {
//        writer.println(getWriterString(obj));
        if (obj == null) {
            writer.write(nullByte);
        } else {
            writer.write('"');
            writer.write(obj.toString().getBytes());
            writer.write('"');
            writer.write('\n');
        }
    }
    public static void writeObject(RpcInvocation inv, BufferedWriter writer) throws IOException {
        writeObject(inv.getAttachment("dubbo", "2.0.1"), writer);
        writeObject(inv.getAttachment("path"), writer);
        writeObject(inv.getAttachment("version"), writer);
        writeObject(inv.getMethodName(), writer);
        writeObject(inv.getParameterTypes(), writer);
        writer.write(new String(inv.getArguments()));
        writer.write(mapToJson(inv.getAttachments()));
        writer.write('\n');
//        writer.newLine();
        writer.flush();
    }

    public static void writeObject(Object obj, BufferedWriter writer) throws IOException {
        writer.write(getWriterString(obj));
        writer.write('\n');
    }
    public static String getWriterString(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        return "\"" +obj+ "\"";
    }

    public static void writeObject(RpcInvocation inv, PrintWriter writer,boolean flag) throws IOException {
        writeObject(inv.getAttachment("dubbo", "2.0.1"), writer, flag);
        writeObject(inv.getAttachment("path"), writer, flag);
        writeObject(inv.getAttachment("version"), writer, flag);
        writeObject(inv.getMethodName(), writer, flag);
        writeObject(inv.getParameterTypes(), writer, flag);
        writer.print(new String(inv.getArguments()));
        writer.println(mapToJson(inv.getAttachments()));
//        writeObject(inv.getAttachments(), writer, flag);
        writer.flush();
    }
    public static void writeObject(Object obj, PrintWriter writer,boolean flag) throws IOException {
//        writer.println(getWriterString(obj));
        if (obj == null) {
            writer.println("null");
        } else {
            writer.print('"');
            writer.print(obj);
            writer.print('"');
            writer.println();
        }
    }
    public static void writeObject(Object obj, PrintWriter writer) throws IOException {
        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.config(SerializerFeature.WriteEnumUsingToString, true);
        serializer.write(obj);
        out.writeTo(writer);
        out.close(); // for reuse SerializeWriter buf
        writer.println();
        writer.flush();
//        writer.close();
    }
    public static void writeObject(RpcInvocation inv, Writer writer) throws IOException {
        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.config(SerializerFeature.WriteEnumUsingToString, true);
        serializer.write(inv.getAttachment("dubbo", "2.0.1"));
        serializer.println();
        serializer.write(inv.getAttachment("path"));
        serializer.println();
        serializer.write(inv.getAttachment("version"));
        serializer.println();
        serializer.write(inv.getMethodName());
        serializer.println();
        serializer.write(inv.getParameterTypes());
        serializer.println();
        serializer.write(new String(inv.getArguments()));
        serializer.println();
        serializer.write(new HashMap<>());
        serializer.println();
        out.writeTo(writer);
        out.close();
        writer.flush();
    }


    public static void writeBytes(byte[] b, PrintWriter writer) {
        writer.print(new String(b));
        writer.flush();
//        writer.close();
    }
}
