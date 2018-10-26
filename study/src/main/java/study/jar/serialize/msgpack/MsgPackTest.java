package study.jar.serialize.msgpack;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import org.junit.Test;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import study.java8.JsonUtilsTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/6/16.
 */
public class MsgPackTest {
    @Test
    public void objectToByte() throws JsonProcessingException {
        Person person = new Person("Jecced", 18, true);
        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        byte[] bytes = mapper.writeValueAsBytes(person);
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
    }
    @Test
    public void byteToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        byte[] bytes = { -125, -92, 110, 97, 109, 101, -90, 74, 101, 99, 99, 101, 100, -93, 97, 103, 101,
                18, -93, 115, 101, 120, -61 };
        Person person = mapper.readValue(bytes, Person.class);
        System.out.println(person);
    }
    @Test
    public void byteToArray() throws IOException {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Jecced", 18, true));
        list.add(new Person("Ruby", 3, false));

        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        byte[] bytes = mapper.writeValueAsBytes(list);
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        System.out.println("=======================");

        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Person.class);
        List<Person> list2 = mapper.readValue(bytes, javaType);
        System.out.println(list2);
    }
    @Test
    public void test() throws IOException {
        System.out.println("=====对象转换bytes=====");
        Person person = new Person("Jecced", 18, true);
        byte[] bytes = MsgPackUtil.toBytes(person);
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        System.out.println("=====bytes转对象=====");
        Person value = MsgPackUtil.toObject(bytes, Person.class);
        System.out.println(value);
        System.out.println("=====集合转换bytes=====");
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Jecced", 18, true));
        list.add(new Person("Ruby", 3, false));
        bytes = MsgPackUtil.toBytes(list);
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));
        System.out.println("=====bytes转换集合=====");
        List<Person> list2 = MsgPackUtil.toList(bytes, Person.class);
        System.out.println(list2);
    }
    private static int count=100;
    private static int threadNum=10;
    @Test
    public void time() throws IOException {
//        List<Person> list = new ArrayList<Person>();
//        for(int i = 0 ; i < 10000; i ++){
//            list.add(new Person("name:" + i, i, 0 == i % 2));
//        }
        Person person = new Person("123",123,true);
        Tests.thReadForEach(new RunableForEach("msgPack",threadNum,count) {
            @Override
            public void action()  {
                byte[] msgBytes = MsgPackUtil.toBytes(person);
            }
        });
        Tests.thReadForEach(new RunableForEach("Json",threadNum,count) {
            @Override
            public void action()  {
                byte[] jsonBytes = JSON.toJSONBytes(person);
            }
        });
    }
    @Test
    public void size() throws IOException {
        List<Person> list = new ArrayList<Person>();
        for(int i = 0 ; i < 10000; i ++){
            list.add(new Person("name:" + i, i, 0 == i % 2));
        }

        byte[] msgBytes = MsgPackUtil.toBytes(list);
        ByteArrayInputStream bis = new ByteArrayInputStream(msgBytes);

        File msgFile = File.createTempFile("msgpack_file", ".data");
        msgFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(msgFile);
        saveTo(bis, fos);
        bis = null;
        fos = null;
        System.out.printf("msgpack序列化1w个对象后大小：%f kb\n", msgFile.length() / 1024.0d);


        byte[] jsonBytes = JSON.toJSONBytes(list);
        bis = new ByteArrayInputStream(jsonBytes);

        File jsonFile = File.createTempFile("json_file", ".data");
        jsonFile.deleteOnExit();
        fos = new FileOutputStream(jsonFile);
        saveTo(bis, fos);
        bis = null;
        fos = null;
        System.out.printf("json序列化1w个对象后大小：%f kb\n", jsonFile.length() / 1024.0d);
    }
    public static void saveTo(InputStream is, OutputStream out) throws IOException {
        try {
            byte[] buffer = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            is.close();
        }
    }
}
