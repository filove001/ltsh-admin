package com.fjz.util;


import com.fjz.util.log.Logs;

import java.util.concurrent.Callable;

/**
 * 重复调用
 * @author fengjianzhong
 *
 */
public class RepeatCall {
	public int max=3;//默认三次
	public RepeatCall(int max) {
		this.max = max;
	}
	public RepeatCall(){
	}
	public RepeatCall(int max,Runnable call) {
		this.max = max;
		go(call, max);
	}
	public static int i=0;
	public static void main(String[] args) {
//		new RepeatCall(3, new Runnable() {
//			@Override
//			public void run() {
//				if(i++<=1)
//				throw new RuntimeException("错误 ！");
//				System.out.println("1111111111111");
//			}
//		});
		RepeatCall.go(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				if(i++<=1)
					throw new RuntimeException("错误 ！");
//				System.out.println("1111111111111");
				System.out.println("1111111111111");
				return "12313";
			}
		},3);
	}
	/**重复调用 某个函数多少 次
	 * @param call		要调用的方法
	 * @param max		调用最大次数
	 * @param number 	调用第几次
	 */
	public static void go(Runnable call,int max,int number){
		try{
			call.run();
		}catch(Exception e){
			Logs.info(e.getMessage()+"  错误次数:"+number);
			if(++number>max){
				Logs.error("重复次数超过 ！");
				Logs.error(e);
				throw e;
			}
			go(call,max,number);
		}
	}
	/**重复调用 某个函数多少 次
	 * @param call		要调用的方法
	 * @param max		调用最大次数
	 * @param number 	调用第几次
	 */
	public static <V>V go(Callable<V> call, int max, int number){
		try{
			return call.call();
		}catch(Exception e){
			Logs.info(e.getMessage()+"  错误次数:"+number);
			if(++number>max){
				Logs.error("重复次数超过 ！");
				Logs.error(e);
				throw new RuntimeException(e);
			}
			return go(call,max,number);
		}
	}
	public static <V>V go(Callable<V> call,int max){
		return go(call,max,1);
	}
	/**
	 * 第一次开始
	 * @param call
	 * @param max
	 */
	public static void go(Runnable call,int max){
		go(call,max,1);
	}

}
