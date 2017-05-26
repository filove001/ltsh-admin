package com.ltsh.admin.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.fjz.util.Empty;
import com.fjz.util.Jsons;

/**
 * Cache工具类
 */
public class Caches {
	private static CacheManager cacheManager=((EhCacheCacheManager)SpringContextHolder.getBean("cacheManager")).getCacheManager();
//	private static CacheManager cacheManager=(CacheManager)SpringContextHolder.getBean("cacheManager");
	private static volatile Object locker = new Object();
	private static final Logger log =  LoggerFactory.getLogger(Caches.class);
	private static final String SYS_CACHE = "sysCache";
	@SuppressWarnings("unchecked")
	public static Map<String,Map<Object,Object>> getAll() {
		Map<String,Map<Object,Object>> maps=new HashMap<>();
		for(final String name:cacheManager.getCacheNames()){
			Cache c=cacheManager.getCache(name);
			List<Object> keys=c.getKeys();
			if(Empty.is(keys)){
				continue;
			}
			Map<Object,Object> map=new HashMap<>();
			maps.put(name, map);
			c.getKeys().forEach(key->{
				map.put(key, get(c,key));
			});
		}
		return maps;
	}
	/**
	 * 获取SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static Object get(Object key) {
		return get(SYS_CACHE, key);
	}
	
	/**
	 * 写入SYS_CACHE缓存
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(SYS_CACHE, key, value);
	}
	
	/**
	 * 从SYS_CACHE缓存中移除
	 * @param key
	 * @return
	 */
	public static void remove(Object key) {
		remove(SYS_CACHE, key);
	}
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(Cache cache, Object key) {
		Element element = cache.get(key);
		return element==null?null:element.getObjectValue();
	}
	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, Object key) {
		return get(getCache(cacheName),key);
	}

	/**
	 * 写入缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, Object key, Object value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}
	/**
	 * 移除缓存里面所有的值
	 * @param cacheName
	 */
	public static boolean removeAll() {
		for(final String name:cacheManager.getCacheNames()){
			getCache(name).removeAll();
		}
		return true;
	}
	/**
	 * 移除缓存里面所有的值
	 * @param cacheName
	 */
	public static void removeAll(String cacheName) {
		getCache(cacheName).removeAll();
	}
	/**
	 * 从缓存中移除
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, Object key) {
		getCache(cacheName).remove(key);
	}
	
	/**
	 * 获得一个Cache，没有则创建一个。
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName){
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null){
			synchronized(locker) {
				cacheManager.addCache(cacheName);
				cache = cacheManager.getCache(cacheName);
				cache.getCacheConfiguration().setEternal(true);
				log.info("cache add cacheName["+cacheName+"]");
			}
		}

		return cache;
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}
	
}
