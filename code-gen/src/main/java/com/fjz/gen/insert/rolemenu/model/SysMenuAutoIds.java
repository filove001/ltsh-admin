package com.fjz.gen.insert.rolemenu.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 自增长
 * @author fengjianzhong
 *
 */
public class SysMenuAutoIds {
	
	private static AtomicLong id;
	static{
		Long max=null;
		if(max==null){
			max=0L;
		}
		id=new AtomicLong(max+1);
	}
//	 定义原子变量
	 public  static Long getId(){
		 return id.getAndIncrement();
	 }
}
