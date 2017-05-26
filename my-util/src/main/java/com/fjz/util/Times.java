package com.fjz.util;

import com.fjz.util.log.Logs;

public class Times {
	public static long timer(Action action,String msg){
		long time=System.currentTimeMillis();
		action.action();
		time=System.currentTimeMillis()-time;
		Logs.info(msg+"用时："+time);
		return time;
	}
	
	public interface Action{
		public Object action();
	};
}
