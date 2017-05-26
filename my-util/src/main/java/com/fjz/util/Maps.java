package com.fjz.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Maps {
	public static <K, V> HashMap<K, V> newMap() {
	    return new HashMap<K, V>();
	 }
	public static Map<String, Object> newMap(String key, Object o) {
		Map<String, Object> m = newMap();
		m.put(key, o);
		return m;
	}
	public static Map<String, Object> newMap(String[] keys, Object[] os) {
		Assert.notEmpty(keys, "keys can't is empty");
		Assert.notEmpty(os, "os can't is empty");
		Assert.isTrue(keys.length==os.length, "keys and os lenght must equal");
		Map<String, Object> m = newMap();
		for (int i = 0; i < os.length; i++) {
			m.put(keys[i],os[i]);
		}
		return m;
	}
	public static Map<String, String> newMap(String key, String o) {
		Map<String, String> m = newMap();
		m.put(key, o);
		return m;
	}
	
	public static Map<String, String> convertMapString(Map<String, Object> m) {
		Map<String, String> newMap = newMap();
		for (String key : m.keySet()) {
			newMap.put(key, m.get(key).toString());
		}
		return newMap;
	}
	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public static Object mapToBean(Class type, Map map) {
		Object obj=null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			// 获取类属性
			obj = type.newInstance(); // 创建 JavaBean 对象
			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
					Object value = map.get(propertyName);

					Object[] args = new Object[1];
					args[0] = value;

					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({"unchecked" })
	public static Map beanToMap(Object bean) {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
}
