package com.fjz.util;


import com.fjz.util.log.Logs;

public class Times {
	public static long timer(Action action,String msg){
		long time=System.currentTimeMillis();
		action.action();
		time=System.currentTimeMillis()-time;
//		System.out.println(msg+"用时："+time);
		Logs.info(msg+"用时："+time);
		return time;
	}
	public static long timer(Action action){
		return timer(action, Systems.getCodeLocation(3));
	}
	public static void main(String[] args){
		timer(() -> {
			return null;
		});

	}
	public interface Action{
		public Object action();
	};
}
