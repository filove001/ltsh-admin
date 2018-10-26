package com.fjz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Strs {
	public static boolean startsWith(final CharSequence str,
			final CharSequence prefix) {
		if (str == null || prefix == null) {
			return str == null && prefix == null;
		}
		if (prefix.length() > str.length()) {
			return false;
		}
		return str.subSequence(0, prefix.length()).equals(prefix);
	}
	public static void txt2Arr(String file){
		List<String> list=Files.readLines(new File(file));
		String temp="";
		for (String string : list) {
			System.out.print(temp+"\""+string+"\"");
			temp=",";
		}
	}
	public static void txt2Map(String file){
		List<String> list=Files.readLines(new File(file));
		for (String string : list) {
//			m.put("", "");
			System.out.println("m.put(\""+string+"\",\"\");");
		}
	}
	/**
	 * 首字母变小写
	 */
	public static String firstCharToLowerCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char[] arr = str.toCharArray();
			arr[0] += ('a' - 'A');
			return new String(arr);
		}
		return str;
	}
	
	/**
	 * 首字母变大写
	 */
	public static String firstCharToUpperCase(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char[] arr = str.toCharArray();
			arr[0] -= ('a' - 'A');
			return new String(arr);
		}
		return str;
	}

	/**
	 * 获取左右两端中间的值，不包括左右两端
	 * @param text 内容
	 * @param left	内容里面左端
	 * @param right 内容里面右端端  右端从左端开始
	 * @return
	 */
	public static String subString(String text,String left,String right){
		StringBuilder sb = new StringBuilder(text.substring(text.indexOf(left)+left.length()));
		return sb.substring(0,sb.indexOf(right));
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//		txt2Map("C:\\Users\\fengjianzhong\\Desktop\\field1.txt");
		System.out.println(Strs.subString("医院名称：深圳市康宁医院测试医院名称：深圳市康宁医院测试", "医院名称：深圳市", "："));
	}
}
