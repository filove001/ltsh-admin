package com.fjz.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lists {
	public final static List<String> emptyStringList=new ArrayList<>(0);
	public static <T>List<T> newList(){
		return new ArrayList<>();
	}
	@SafeVarargs
	public static <T>List<T> as(T... t){
		if(t==null){
			return null;
		}
		List<T> list=new ArrayList<T>();
		Collections.addAll(list, t);
		return list;
	}
	public static <T,K>void compareList(String keyName, List<T> list,String keyName1, List<K> list1,CallBack<T,K> cb){
		Map<String,T> map=listToMap(keyName,list);
		String key=null;
		for (K k : list1) {
			key=get(keyName1,k).toString();
			if(map.containsKey(key)){
				//有相同
				cb.eq(map.get(key), k);
			}else{//没相同
				cb.neq(map.get(key), k);
			}
		}
	}
	public interface CallBack<T,K>{
		void eq(T t,K k);
		void neq(T t,K k);
	}
	public static Object get(String name,Object t){
         try {
        	Field field  = t.getClass().getDeclaredField(name);
            field.setAccessible(true);
			Object o = field.get(t);
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		} 
        throw new RuntimeException();
	}
	 public static Map<String, String> arrayToMap(String[] ss){
	        Map<String, String> m = new HashMap<String, String>();
	        for (String s : ss) {
	            m.put(s, s);
	        }
	        return m;
	 }
	 public static <T> Map<String, T> arrayToMap(String keyName, T[] ts){
        Map<String, T> m = new HashMap<String, T>();
        for (T t : ts) {
            m.put(get(keyName,t).toString(), t);
        }
        return m;
	 }
    /**
     * 效率稍微比带key的慢一点
     * 用于把List<Object>转换成Map<String,Object>形式，便于存入缓存
     * @param keyName 主键属性
     * @param list 集合
     * @return 返回对象
     */
    public static <T> Map<String, T> listToMap(String keyName, List<T> list){
        Map<String, T> m = new HashMap<String, T>();
        for (T t : list) {
            m.put(get(keyName,t).toString(), t);
        }
        return m;
    }
    public static <T> Map<String,List<T>> listToMapList(String keyName, List<T> list){
    	Map<String, List<T>> m = new HashMap<String,List<T>>();
    	List<T> data=null;
    	String key=null;
    	for (T t : list) {
    		key=get(keyName,t).toString();
    		data=m.get(key);
    		if(data==null){
    			data=new ArrayList<T>();
    			m.put(key, data);
    		}
    		data.add(t);
		}
    	return m;
    }
    public static <T> Map<String,Map<String,T>> listToMapMap(String keyName,String keyName2, List<T> list){
    	Map<String,Map<String,T>> m = new HashMap<>();
    	Map<String,T> data=null;
    	String key=null;
    	for (T t : list) {
    		key=get(keyName,t).toString();
    		data=m.get(key);
    		if(data==null){
    			data=new HashMap<>();
    			m.put(key, data);
    		}
    		data.put(get(keyName2,t).toString(), t);
		}
    	return m;
    }
    /**
     * 用于把List<Object>转换成Map<String,Object>形式，便于存入缓存
     * @param key 取得主键属性
     * @param list 集合
     * @return 返回对象
     */
    public static <T> Map<String, T> listToMap(List<T> list,Key<T> key){
        Map<String, T> m = new HashMap<String, T>();
        for (T t : list) {
            m.put(key.getKey(t).toString(), t);
        }
        return m;
    }
    public interface Key<T>{
    	Object getKey(T t);
    }
	public static void main(String[] args) {
		List<String> list=Lists.as(new String[]{"111","222"});
		System.out.println(list.get(0));
	}
}