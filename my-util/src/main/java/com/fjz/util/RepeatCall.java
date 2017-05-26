package com.fjz.util;

import org.junit.Test;

/**
 * 重复调用
 * @author fengjianzhong
 *
 */
public class RepeatCall {
	/**重复调用 某个函数多少 次
	 * @param call		要调用的方法
	 * @param max		调用最大次数
	 * @param number 	调用第几次
	 */
	public static void go(Call call,int max,int number){
		try{
			call.go();
		}catch(Exception e){
			if(++number>=max){
				e.printStackTrace();
				throw new RuntimeException("重复次数超过 ！");
			}
			go(call,max,number);
		}
	}
	public static void go(Call call,int max){
		go(call,max,0);
	}
	/**重复调用 某个函数多少 次,默认三次
	 * @param call
	 */
	public static void go(Call call){
		go(call,max,0);
	}
	public static final int max=3;//默认三次
	public interface Call{
		void go();
	};
	
//	@Test
//	public void testGoCallInt() {
//		RepeatCall.go(new Call() {
//			public void go() {
//				int num=1/0;
//				System.out.println("1111");
//			}
//		}, 3);
//	}
}
