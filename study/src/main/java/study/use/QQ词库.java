package study.use;

import com.fjz.util.Files;
import org.junit.Test;

import java.io.File;
import java.util.*;

public class QQ词库 {
    @Test
    public void test1(){
        List<String> str= Files.readLines(new File(basePath+"测试.txt"));
//        List<String> str=Files.readLines(new File(basePath+"zzdyx_perfect.dict.yaml"));
//        List<String> str1=Files.readLines(new File(basePath+"zzdyx_perfect.dict (1).yaml"));
//        str.removeAll(str1);
        for (String s1:str
             ) {
            System.out.print(s1+"  ");
        }
    }
    @Test
    public void test2(){
        List<String> str=Files.readLines(new File(basePath+"zzdyx_perfect.dict.yaml"));
        List<String> str1=Files.readLines(new File(basePath+"zzdyx_perfect.dict (1).yaml"));
        str1.removeAll(str);
        for (String s1:str1
                ) {
            System.out.print(s1+"  ");
        }
    }
    static String basePath = "E:\\输入法\\";
    @Test
    public void 系统词库(){
        List<String> str=Files.readLines(new File(basePath+"zzdyx_perfect.dict.yaml"));
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for (String s:str) {
            String[] ss = s.trim().split("\t");
            String key=ss[1];
            String value = ss[0];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + " "+value);
            }else{
                map.put(key, key+ " "+value);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> m:map.entrySet()) {
            list.add(m.getValue());
        }
        Collections.sort(list);
        for (String s:list) {
            sb.append(s).append("\n");
        }
        Files.write(basePath+"哲哲豆系统词库.txt",sb.toString());
    }
    @Test
    public void 自定义多多格式() {
        List<String> str = Files.readLines(new File(basePath + "zzdyx_perfect.dict.yaml"));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String s:str) {
            String[] ss = s.trim().split("\t");
            String key=ss[1];
            String value = ss[0];
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
            int num = map.get(key);
            sb.append(key).append("=").append(num).append(",").append(value).append("\n");
        }
        Files.write(basePath+"哲哲豆自定义1.txt",sb.toString());
    }
    @Test
    public void 自定义(){
        List<String> str=Files.readLines(new File(basePath+"zzdyx_perfect.dict.yaml"));
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for (String s:str) {
            String[] ss = s.trim().split("\t");
            String key=ss[1];
            String value = ss[0];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + " "+value);
            }else{
                map.put(key, key+ " "+value);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String,String> m:map.entrySet()) {
            list.add(m.getValue());
        }
        Collections.sort(list);
        for (String s:list) {
            String[] ss = s.split(" ");
            for (int i = 1; i < ss.length; i++) {
                sb.append(ss[0]).append("=").append(i).append(",").append(ss[i]).append("\n");
            }
        }
        Files.write(basePath+"哲哲豆自定义.txt",sb.toString());
//        System.out.println(map);
    }
}
