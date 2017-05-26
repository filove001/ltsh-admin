package com.fjz.util;
/**
 * 默认值
 * @author fengjianzhong
 *
 */
public class Default {
	/**
	 * 如果为null则返回默认值
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static <T> T ifNull(final T object, final T defaultValue) {
        return object != null ? object : defaultValue;
    }
	/**
	 * 如果为Empty则返回默认值
	 * @param object
	 * @param defaultValue
	 * @return
	 */
	public static <T> T ifEmpty(final T object, final T defaultValue) {
        return Empty.not(object) ? object : defaultValue;
    }
}
