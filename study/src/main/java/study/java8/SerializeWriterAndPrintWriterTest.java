package study.java8;

import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.PooledByteBufAllocator;
import net.minidev.json.JSONValue;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/6/9.
 */
public class SerializeWriterAndPrintWriterTest {
    private static int count=10000;
    private static int threadNum=200;
    @Test
    public void testSerializeWriterPrintWriter() throws IOException, InterruptedException {
//        OutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\新建文本文档 (2).txt");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        RpcInvocation inv = new RpcInvocation();
        inv.setAttachment("dubbo","2.0.1");
        inv.setAttachment("path","/duboo");
        inv.setAttachment("version","2.22");
        inv.setMethodName("name");
        inv.setParameterTypes("name");
        inv.setArguments(new byte[]{12,21,43,55,99});
        /////////////多线程下很烂
        Tests.thReadForEach( new RunableForEach("BufferedWriter",threadNum,count) {
            @Override
            public void action()  {
//                PrintWriter writer = new PrintWriter();
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                try {
                    JsonUtilsTest.writeObject(inv,writer);
//                    System.out.println(Arrays.toString(out.toByteArray()));
                    out.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Tests.thReadForEach(new RunableForEach("ByteArrayOutputStream",threadNum,count) {
            @Override
            public void action()  {
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
                ByteArrayOutputStream writer = new ByteArrayOutputStream();
                try {
                    JsonUtilsTest.writeObject(inv, writer);
                    out.write(writer.toByteArray());
//                    System.out.println(Arrays.toString(writer.toByteArray()));
                    out.reset();
//                    writer.reset();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Tests.thReadForEach(new RunableForEach("ByteBuf",threadNum,count) {
            @Override
            public void action()  {
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
                ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer();
                try {
                    JsonUtilsTest.writeObject(inv, byteBuf);
                    out.write(ByteBufUtil.getBytes(byteBuf));
//                    System.out.println(Arrays.toString(writer.toByteArray()));
                    byteBuf.release();
                    out.reset();
//                    writer.reset();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Tests.thReadForEach(new RunableForEach("PrintWriter SerializeWriter",threadNum,count) {
            @Override
            public void action()  {
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
//                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
                try {
                    JsonUtilsTest.writeObject(inv, writer);
                    out.reset();
//                    System.out.println(Arrays.toString(out.toByteArray()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //这个多线程差
        Tests.thReadForEach( new RunableForEach("PrintWriter println",threadNum,count) {
            @Override
            public void action()  {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
                try {
                    JsonUtilsTest.writeObject(inv, writer,true);
                    out.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
//        Tests.thReadForEach(threadNum, new Tests.RunableForEach(count) {
//            @Override
//            public void action()  {
////                PrintWriter writer = new PrintWriter();
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
//                try {
//                boolean flag=true;
//                    JsonUtilsTest.writeObject(inv.getAttachment("dubbo", "2.0.1"), writer, flag);
//                    JsonUtilsTest.writeObject(inv.getAttachment("path"), writer, flag);
//                    JsonUtilsTest.writeObject(inv.getAttachment("version"), writer, flag);
//                    JsonUtilsTest.writeObject(inv.getMethodName(), writer, flag);
//                    JsonUtilsTest.writeObject(inv.getParameterTypes(), writer, flag);
//                    writer.write(new String(inv.getArguments()));
////        writer.println(JSONValue.toJSONString((inv.getAttachments())));
//                    writer.write(JSONValue.toJSONString((inv.getAttachments())));
//                    writer.newLine();
////        writeObject(inv.getAttachments(), writer);
//                    writer.flush();
//
////                    JsonUtilsTest.writeObjectToFastJson(inv, writer,true);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        Thread.sleep(1000);
    }
}
