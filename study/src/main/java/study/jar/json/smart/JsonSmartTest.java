package study.jar.json.smart;
import com.alibaba.fastjson.JSON;
import com.fjz.util.RunableForEach;
import com.fjz.util.Tests;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONStyle;
import net.minidev.json.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.util.*;

/*
 * Home page: http://code.google.com/p/json-smart/
 *
 * compiler:  javac -cp json-smart-1.1.1.jar JsonSmartTest.java
 *
 * Run:       java -cp ./:json-smart-1.1.1.jar JsonSmartTest
 *
 */


public class JsonSmartTest {

    //1. String <==> JsonObject
    public static void DecodingTest() throws ParseException {
        System.out.println("=======decode=======");

        String s="[0,{'1':{'2':{'3':{'4':[5,{'6':7}]}}}}]";
        Object obj=JSONValue.parse(s);
        JSONArray array=(JSONArray)obj;
        System.out.println("======the 2nd element of array======");
        System.out.println(array.get(1));
        System.out.println();

        JSONObject obj2=(JSONObject)array.get(1);
        System.out.println("======field \"1\"==========");
        System.out.println(obj2.get("1"));

        s="{}";
        obj=JSONValue.parse(s);
        System.out.println(obj);

        s="{\"key\":\"Value\"}";
        // JSONValue.parseStrict()
        // can be use to be sure that the input is wellformed
        obj=JSONValue.parseStrict(s);
        JSONObject obj3=(JSONObject)obj;
        System.out.println("====== Object content ======");
        System.out.println(obj3.get("key"));
        System.out.println();

    }


    public static void EncodingTest() {
        System.out.println("=======EncodingTest=======");

        // Json Object is an HashMap<String, Object> extends
        JSONObject obj = new JSONObject();
        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", 1000.21);
        obj.put("is_vip", true);
        obj.put("nickname",null);

        System.out.println("Standard RFC4627 JSON");
        System.out.println(obj.toJSONString());

        System.out.println("Compacted JSON Value");
        System.out.println(obj.toJSONString(JSONStyle.MAX_COMPRESS));

        // if obj is an common map you can use:

        System.out.println("Standard RFC4627 JSON");
        System.out.println(JSONValue.toJSONString(obj));

        System.out.println("Compacted JSON Value");
        System.out.println(JSONValue.toJSONString(obj, JSONStyle.MAX_COMPRESS));

    }

    public static void EncodingTest2() {
        System.out.println("=======EncodingTest2=======");

        // Json Object is an HashMap<String, Object> extends
        JSONObject obj = new JSONObject();
        obj.put("name", "foo");
        obj.put("num", 100);
        obj.put("balance", 1000.21);
        obj.put("is_vip", true);
        obj.put("nickname",null);

        //Output Compressed json
        Object value = obj;
        String com_json = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS);
        String json = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS);

        System.out.println("Compacted JSON Value");
        System.out.println(com_json);
        System.out.println("From RFC4627 JSON String: " + JSONValue.compress(json));
        System.out.println("From Compacted JSON String: " + JSONValue.compress(com_json));

        System.out.println("Standard RFC4627 JSON Value");
        System.out.println(json);
        System.out.println("From RFC4627 JSON String: " + JSONValue.uncompress(json));
        System.out.println("From Compacted JSON String: " + JSONValue.uncompress(com_json));

        //from compress json string
        System.out.println("From compress json string(JSONObject)");
        Object obj2=JSONValue.parse(com_json);
        System.out.println(JSONValue.toJSONString(obj2, JSONStyle.NO_COMPRESS));
        System.out.println(JSONValue.toJSONString(obj2, JSONStyle.MAX_COMPRESS));
    }


    //2. Java Struct <==> JsonSmart object
    public class Person {
        String  name;
        int     age;
        boolean single;
        long    mobile;

        public String getName(){
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public boolean getSingle() {
            return this.single;
        }
        public void setSingle(boolean single) {
            this.single = single;
        }
        public long getMobile() {
            return mobile;
        }
        public void setMobile(long mobile) {
            this.mobile = mobile;
        }
    }

    public class JSONDomain {    // for convert struct <==> json
        public Object result = new JSONObject();

        public Object getResult() {
            return result;
        }
        public void setResult(Object result) {
            this.result = result;
        }
    }

    public void Struct2JsonObject() {
        System.out.println("========Struct2JsonObject=======");

        Person person = new Person();
        person.setName("json smart");
        person.setAge(13);
        person.setMobile(20130808);

        Person person2 = new Person();
        person2.setName("test");
        person2.setAge(123);
        person2.setMobile(888666);

        List<Person> array = new ArrayList<Person>();
        array.add(person);
        array.add(person2);

        //1. struct <==> JsonObject
        JSONObject obj = new JSONObject();
        //obj = (Object)person;  // compiler error!
        // way 1:
        JSONDomain data = new JSONDomain();   // for convert
        data.setResult(person);
        // obj = (JSONObject)data.getResult(); // run error: ClassCastException
        obj.put("person", data.getResult());
        System.out.println(JSONValue.toJSONString(obj));

        // way 2:
        obj.put("person", array.get(1));
        System.out.println(JSONValue.toJSONString(obj));


        //2. Container <==> JsonObject
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(person);
        jsonArray.add(person2);
        JSONObject result = new JSONObject();
        result.put("persons", jsonArray);
        System.out.println(JSONValue.toJSONString(result));
    }

    //3. JsonSmartSerializationTest
    public static Map<String, Object> testBytes2Map(byte[] bytes) {
        Map<String, Object> map = null;
        try {
            map = (Map<String, Object>) JSONValue.parseStrict((new String(bytes, "UTF-8")));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    // JsonSmartSerializationTest
    public static byte[] testMap2Bytes(Map<String, Object> map) {
        String str = JSONObject.toJSONString(map);
        byte[] result = null;
        try {
            result = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        System.out.println((char)34);
        System.out.println((char)125);
        System.out.println((char)10);
        System.out.println(new String(new byte[]{34,125,10}));
        byte[] bs = {34, 50, 46, 48, 46, 49, 34, 0, 0, 0};
        System.out.println(new String(bs));
        byte[] bs1 = {34, 50, 46, 48, 46, 49, 34, 10, 34, 99, 111, 109, 46, 97, 108, 105, 98, 97, 98, 97, 46, 100, 117, 98, 98, 111, 46, 112, 101, 114, 102, 111, 114, 109, 97, 110, 99, 101, 46, 100, 101, 109, 111, 46, 112, 114, 111, 118, 105, 100, 101, 114, 46, 73, 72, 101, 108, 108, 111, 83, 101, 114, 118, 105, 99, 101, 34, 10, 110, 117, 108, 108, 10, 34, 104, 97, 115, 104, 34, 10, 34, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 34, 10, 34, 99, 72, 68, 83, 99, 75, 80, 75, 97, 100, 115, 68, 112, 109, 69, 53, 106, 120, 84, 98, 65, 110, 49, 120, 120, 104, 53, 88, 105, 89, 72, 54, 86, 115, 86, 52, 79, 101, 72, 101, 106, 50, 65, 72, 65, 118, 110, 49, 90, 110, 108, 67, 108, 98, 69, 75, 50, 54, 83, 85, 86, 98, 66, 102, 104, 81, 56, 68, 81, 106, 121, 99, 98, 107, 118, 87, 67, 100, 103, 82, 79, 57, 52, 55, 103, 78, 81, 68, 115, 108, 76, 88, 77, 116, 77, 99, 49, 50, 75, 121, 65, 78, 115, 73, 112, 88, 70, 109, 89, 82, 68, 50, 68, 66, 86, 115, 120, 116, 121, 112, 49, 79, 76, 121, 71, 85, 87, 50, 83, 120, 74, 108, 115, 109, 101, 72, 75, 88, 49, 121, 65, 112, 79, 83, 68, 99, 69, 70, 51, 57, 57, 70, 100, 105, 48, 54, 69, 71, 103, 76, 55, 115, 117, 57, 106, 75, 70, 116, 114, 84, 71, 113, 78, 102, 76, 75, 117, 75, 109, 50, 79, 76, 105, 80, 82, 90, 119, 119, 78, 73, 83, 103, 48, 83, 85, 118, 107, 48, 77, 55, 90, 84, 83, 66, 85, 101, 100, 101, 49, 75, 105, 106, 87, 53, 69, 68, 116, 108, 118, 97, 114, 57, 113, 97, 76, 100, 70, 104, 82, 84, 66, 112, 68, 112, 110, 52, 50, 87, 107, 117, 79, 48, 76, 97, 117, 66, 55, 98, 75, 83, 54, 84, 113, 73, 77, 89, 73, 57, 75, 83, 108, 110, 101, 103, 118, 121, 82, 78, 51, 113, 88, 88, 110, 87, 113, 85, 120, 79, 73, 112, 105, 67, 89, 56, 118, 113, 113, 71, 76, 97, 57, 110, 110, 81, 121, 72, 108, 111, 52, 105, 53, 101, 115, 75, 89, 52, 116, 65, 71, 68, 98, 104, 66, 48, 89, 99, 113, 119, 84, 100, 75, 53, 65, 106, 56, 99, 48, 74, 98, 112, 65, 115, 76, 73, 106, 83, 114, 54, 111, 90, 90, 118, 98, 82, 111, 85, 97, 114, 107, 104, 89, 69, 77, 98, 117, 81, 114, 69, 111, 108, 72, 111, 55, 112, 87, 76, 97, 118, 99, 102, 100, 122, 70, 55, 50, 57, 121, 89, 81, 57, 87, 50, 79, 106, 99, 51, 48, 98, 113, 81, 70, 115, 70, 120, 84, 110, 107, 90, 57, 109, 110, 111, 75, 70, 49, 115, 108, 109, 81, 77, 75, 111, 111, 49, 52, 102, 86, 98, 82, 103, 99, 78, 70, 70, 80, 49, 68, 88, 116, 113, 111, 90, 69, 121, 106, 69, 108, 83, 81, 113, 116, 104, 53, 105, 117, 51, 56, 49, 77, 57, 54, 69, 107, 89, 117, 97, 69, 104, 108, 118, 115, 98, 50, 119, 69, 83, 71, 83, 120, 82, 75, 113, 82, 117, 118, 70, 85, 97, 81, 48, 76, 73, 108, 112, 53, 79, 81, 50, 101, 80, 101, 115, 73, 78, 68, 100, 120, 52, 118, 101, 72, 101, 111, 112, 68, 108, 86, 81, 90, 103, 72, 107, 113, 55, 118, 50, 84, 105, 111, 107, 85, 100, 68, 108, 76, 97, 54, 87, 52, 89, 99, 88, 118, 107, 71, 82, 114, 98, 113, 54, 112, 57, 69, 110, 74, 56, 54, 51, 115, 79, 68, 100, 76, 34, 13, 10, 34, 123, 34, 112, 97, 116, 104, 34, 58, 34, 99, 111, 109, 46, 97, 108, 105, 98, 97, 98, 97, 46, 100, 117, 98, 98, 111, 46, 112, 101, 114, 102, 111, 114, 109, 97, 110, 99, 101, 46, 100, 101, 109, 111, 46, 112, 114, 111, 118, 105, 100, 101, 114, 46, 73, 72, 101, 108, 108, 111, 83, 101, 114, 118, 105, 99, 101, 34, 125, 34, 10};
        System.out.println(new String(bs1));
        int threadNum=20;
        System.out.println("");
        Map<String, String> map = new HashMap<>();
        map.put("name", "钟");
        map.put("age", "123");
        System.out.println(JSON.toJSONString(map));
        System.out.println(JSONValue.toJSONString(map));
//        Tests.thReadForEach(new RunableForEach("JSONValue",threadNum,100000) {
//            @Override
//            public void action() {
//                JSONValue.toJSONString(map);
//            }
//        });
//        Tests.thReadForEach(new RunableForEach("JSON",threadNum,100000) {
//            @Override
//            public void action() {
//                JSON.toJSONString(map);
//            }
//        });
//        DecodingTest();
//
//        EncodingTest();
//
//        EncodingTest2();
//
//
//        JsonSmartTest test = new JsonSmartTest();
//        test.Struct2JsonObject();

    }
}