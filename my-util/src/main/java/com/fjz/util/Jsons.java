package com.fjz.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Charles
 * java bean与JSON格式的转换
 *
 */
public class Jsons{
	//
	public static boolean checkString2Json(String str){
		try {
			JSON.parse(str);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	public static String toString(Object obj){
		return JSON.toJSONStringWithDateFormat(obj, JSON.DEFFAULT_DATE_FORMAT, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
	}
	/** 
	 * @Author: Charles
	 * @Description: 把对象转换为json字符串
	 * @param obj
	 * @return String: 
	 */
	public static String toJsonString(Object obj){
		return toJsonString(obj, JSON.DEFFAULT_DATE_FORMAT);
	}
	/** 
	 * @Author: Charles
	 * @Description: 把对象转换为json字符串
	 * @param obj
	 * @param dateFormat	日期格式
	 * @return String: 
	 */
	public static String toJsonString(Object obj, String dateFormat){
		return JSON.toJSONStringWithDateFormat(obj, dateFormat, SerializerFeature.WriteDateUseDateFormat);
	}
	
	/** 
	 * @Author: Charles
	 * @Description: 把对象数组转换为json字符串
	 * @param obj
	 * @return String: 
	 */
	public static String toJsonString(Object[] obj){
		return JSON.toJSONString(obj, true);
	}
	/** 
	 * @Author: Charles
	 * @Description: 把Collection转换为json字符串
	 * @param conllection
	 * @return String: 
	 */
	public static String toJsonString(Collection<?> conllection){
		return toJsonString(conllection, JSON.DEFFAULT_DATE_FORMAT);
	}
	/** 
	 * @Author: Charles
	 * @Description: 把Collection转换为json字符串并且附上日期格式
	 * @param conllection
	 * @param dateFormat
	 * @return String: 
	 */
	public static String toJsonString(Collection<?> conllection, String dateFormat){
		return JSON.toJSONStringWithDateFormat(conllection, dateFormat, SerializerFeature.WriteDateUseDateFormat);
	}
	/** 
	 * @Author: Charles
	 * @Description: 把Map转换为json字符串
	 * @param map
	 * @return String: 
	 */
	public static String toJsonString(Map<?,?> map){
		return toJsonString(map, JSON.DEFFAULT_DATE_FORMAT);
	}
	
	/** 
	 * @Author: Charles
	 * @Description: 把Map转换为json字符串并且附上日期格式
	 * @param map
	 * @param dataFormat
	 * @return String: 
	 */
	public static String toJsonString(Map<?,?> map, String dataFormat){
		return JSON.toJSONStringWithDateFormat(map, dataFormat, SerializerFeature.WriteDateUseDateFormat);
	}

	/** 
	 * @Author: Charles
	 * @Description: 把json字符串转java bean
	 * @param json
	 * @param entityClazz
	 * @return T: 
	 */
	public  static <T> T parseObject(String json, Class<T> entityClazz){
		return JSON.parseObject(json, entityClazz);
	}
	
	/** 
	 * @Author: Charles
	 * @Description: 把json字符串转list
	 * @param json格式：
	 * [{"age":16,"id":"P001","name":"TOM"},
	 *  {"age":21,"id":"P002","name":"JACKSON"}]
	 * @param entityClazz
	 * @return List<T>: 
	 */
	public static <T> List<T> parseList(String json, Class<T> entityClazz){
		List<T> objList = JSON.parseArray(json, entityClazz);
// TODO: Consider simply returning the value vs storing it in local variable 'objList'
		return objList;
	}
	/** 
	 * @Author: fjz
	 * @Description: 把json字符串转list  {}一个也可以装换成list{}
	 * @param json格式：
	 * [{"age":16,"id":"P001","name":"TOM"},
	 *  {"age":21,"id":"P002","name":"JACKSON"}]
	 *  or
	 *  {"age":16,"id":"P001","name":"TOM"}
	 * @param entityClazz
	 * @return List<T>: 
	 */
	public static <T> List<T> parseListOrOneList(String json, Class<T> entityClazz){
		List<T> objList=null;
		if(json.startsWith("{")&&json.endsWith("}")){
			T t=parseObject(json,entityClazz);
			objList=new ArrayList<T>(1);
			objList.add(t);
		}else{
			objList = JSON.parseArray(json, entityClazz);
		}
		return objList;
	}
	public static List<Map<String, Object>> parseListMap(String json){
		return JSON.parseObject(json, new TypeReference<List<Map<String,Object>>>(){});
	}
	/** 
	 * @Author: fjz
	 * @Description: 把json字符串转list
	 * @param json
	 * @param type	用 new TypeReference<List<String>>(){}取得
	 * @return  List<T>
	 */
	public static <T> List<T> parseList(String json, TypeReference<List<T>> type){
		List<T> objMap = JSON.parseObject(json, type);
// TODO: Consider simply returning the value vs storing it in local variable 'objMap'
		return objMap;
	}
	/** 
	 * @Author: Charles
	 * @Description: 把json字符串转map
	 * @param json格式：
	 * {"age":16,"id":"P001"}
	 * @return Map<K,V>: 
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> parseMap(String json){
		Map<K, V> objMap = (Map<K, V>) JSON.parseObject(json);
// TODO: Consider simply returning the value vs storing it in local variable 'objMap'
		return objMap;
	}
	
	/** 
	 * @Author: Charles
	 * @Description: 把json字符串转map
	 * @param json
	 * @param type	用 new TypeReference<Map<String,Demo>>(){}取得
	 * @return Map<K,V>: 
	 */
	public static <K, V> Map<K, V> parseMap(String json, TypeReference<Map<K, V>> type){
		Map<K, V> objMap = JSON.parseObject(json, type);
// TODO: Consider simply returning the value vs storing it in local variable 'objMap'
		return objMap;
	}

	/** Prevent instantiation */
	private Jsons() {
	}
}
