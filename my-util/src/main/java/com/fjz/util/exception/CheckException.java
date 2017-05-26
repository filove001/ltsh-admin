package com.fjz.util.exception;
/**
 * 检查异常
 * 用Assert抛出的异常
 * @author Administrator
 *
 */
public class CheckException extends RuntimeException{
	private static final long serialVersionUID = -6365630128856068164L;
    public CheckException() {
        super();
    }
    public CheckException(String s) {
        super(s);
    }
    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }
    public CheckException(Throwable cause) {
        super(cause);
    }
}
