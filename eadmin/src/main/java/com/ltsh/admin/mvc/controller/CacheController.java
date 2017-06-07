package com.ltsh.admin.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.Empty;
import com.fjz.util.Reflect;
import com.ltsh.admin.config.DbConfig;
import com.ltsh.admin.mvc.base.BaseController;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjz.util.Jsons;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Caches;

import java.util.Map;


/**
 * 缓存Controller
 * @author fjz
 *
 */
@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController {
//	@Autowired
//	private CacheManager cacheManager;
//	private  net.sf.ehcache.CacheManager c;
	@RequestMapping("/all")
	@ResponseBody
	public Object all(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		return Caches.getAll();
	}
	@RequestMapping("/key")
	@ResponseBody
	public Object key(String cacheName,String key) {
		cacheName=cacheName==null?"userCache":cacheName;
		return Caches.get(cacheName, key);
	}
	@RequestMapping("/clear")
	@ResponseBody
	public Object clear(HttpServletRequest request,HttpServletResponse response,String cacheName) {
		if(Empty.is(cacheName)){
			Caches.removeAll();
		}else{
			Caches.removeAll(cacheName);
		}
		return true;
	}

	@RequestMapping("/dbKey")
	@ResponseBody
	public Object dbKey(String cacheName,String key) {
		return DbConfig.cache.getCacheManger().getCache(cacheName,key);
	}
	@RequestMapping("/dbAll")
	@ResponseBody
	public Object dbAll(String cacheName) {
		Map<String, Map<Object,Object>> cache=new Reflect(DbConfig.cache.getCacheManger()).get("cache");
		return cache;
	}
	@RequestMapping("/dbClear")
	@ResponseBody
	public Object dbClear(String cacheName) {
		boolean ok=false;
		for (String ns: DbConfig.cache.getNsSet()) {
			if(Empty.not(cacheName)&&ns.equals(cacheName)||Empty.is(cacheName)){
				DbConfig.cache.clearCache(ns);
				ok=true;
			}
		}
		return ok;
	}
}
