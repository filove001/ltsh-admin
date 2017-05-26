package com.ltsh.admin.mvc.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



/**
 * 缓存Controller
 * @author fjz
 *
 */
@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController{
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
	@RequestMapping("/clearAll")
	@ResponseBody
	public Object clearAll(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		return Caches.removeAll();
	}
}
