package com.fjz.util;


/**
 * 返回的信息
 * @author fjz
 */
public class BaseMsg<T> {
//	private boolean success;
	private int state=-1;//默认状态是失败，-1为失败，1为成功
	private String msg;
	private T data;
	@SuppressWarnings("rawtypes")
	public static BaseMsg me(){
		return new BaseMsg();
	}
	public static <T>BaseMsg<T> success(T data,String msg){
		return new BaseMsg<T>().setState(1).setData(data).setMsg(msg);
	}
	public static BaseMsg<Object> success(String msg){
		return successMsg.setMsg(msg);
	}
	public static BaseMsg<Object> successMsg=new BaseMsg<Object>().setState(1);
	
	public static <T>BaseMsg<T> err(T data,String msg){
		return new BaseMsg<T>().setState(-1).setData(data).setMsg(msg);
	}
	public static BaseMsg<Object> err(String msg){
		return new BaseMsg<Object>().setState(-1).setMsg(msg);
	}
	public BaseMsg<Object> err(){
		return new BaseMsg<Object>().setState(-1);
	}
	public int getState() {
		return state;
	}
	public BaseMsg<T> setState(int state) {
//		this.success=state==1?true:state==-1;
		this.state = state;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public BaseMsg<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public T getData() {
		return data;
	}
	public BaseMsg<T> setData(T data) {
		this.data = data;
		return this;
	}
//	public boolean isSuccess() {
//		return success;
//	}
//	public BaseMsg<T> setSuccess(boolean success) {
//		this.state=success?1:-1;
//		this.success = success;
//		return this;
//	}
}
