package com.fjz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具，find加上安全保护
 */
public class Regexs {
	public static boolean find(String regex,String content){
		if(regex==null||content==null){ return false;}
		Matcher m = Pattern.compile(regex).matcher(content);
		return m.find();
	}
	public static String findGroupByOne(String regex,String content){
		List<String> list = findGroup(regex, content);
		if(Empty.is(list))
			throw new RuntimeException("findGroupByOne没有搜索到对应名字");
		return list.get(0);
	}
	public static List<String> findGroup(String regex,String content){
		if(regex==null||content==null){ return Lists.emptyStringList;}
		Matcher m = Pattern.compile(regex).matcher(content);
		List<String> list=new ArrayList<String>();
		while(m.find()){
			list.add(m.group());
		}
		return list;
	}
	public static String findGroupIndexByOne(String regex,String content){
		List<String> list = findGroup(regex, content,1);
		if(Empty.is(list))
			throw new RuntimeException("findGroupByOne没有搜索到对应名字");
		return list.get(0);
	}
	public static List<String> findGroup(String regex,String content,int groupIndex){
		if(regex==null||content==null){ return Lists.emptyStringList;}
		List<String> list=new ArrayList<String>();
		Matcher m = Pattern.compile(regex).matcher(content);
		while(m.find()){
			list.add(m.group(groupIndex));
		}
		return list;
	}

	public static List<String> findGroupAll(String regex,String content){
		if(regex==null||content==null){ return Lists.emptyStringList;}
		Pattern wp = Pattern.compile(regex,Pattern.CASE_INSENSITIVE | Pattern.DOTALL); 
		Matcher m = wp.matcher(content);
		List<String> list=new ArrayList<String>();
		while(m.find()){
			list.add(m.group());
		}
		return list;
	}
	//对应href
	public static final String HREF = "href\\s*=\\s*\"?(.*?)(\"|>|\\s+)";
	//对应src
	public static final String SRC = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";
	// 获取img标签正则
	public static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
	// 获取src路径的正则
//	private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";
	/**
	 * 常用正则表达式：匹配非负整数（正整数 + 0）
	 */
	public final static String regExp_integer_1 = "^\\d+$";
	
	/**
	 * 常用正则表达式：匹配正整数
	 */
	public final static String regExp_integer_2 = "^[0-9]*[1-9][0-9]*$";
	
	/**
	 * 常用正则表达式：匹配非正整数（负整数  + 0）
	 */
	public final static String regExp_integer_3 = "^((-\\d+) ?(0+))$";
	
	/**
	 * 常用正则表达式：匹配负整数
	 */
	public final static String regExp_integer_4 = "^-[0-9]*[1-9][0-9]*$";
	
	/**
	 * 常用正则表达式：匹配整数
	 */
	public final static String regExp_integer_5 = "^-?\\d+$";

	/**
	 * 常用正则表达式：匹配非负浮点数（正浮点数 + 0）
	 */
	public final static String regExp_float_1 = "^\\d+(\\.\\d+)?$";
	
	/**
	 * 常用正则表达式：匹配正浮点数
	 */
	public final static String regExp_float_2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*))$"; 
	
	/**
	 * 常用正则表达式：匹配非正浮点数（负浮点数 + 0）
	 */
	public final static String regExp_float_3 = "^((-\\d+(\\.\\d+)?) ?(0+(\\.0+)?))$";
	
	/**
	 * 常用正则表达式：匹配负浮点数
	 */
	public final static String regExp_float_4 = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*)))$";
	
	/**
	 * 常用正则表达式：匹配浮点数
	 */
	public final static String regExp_float_5 = "^(-?\\d+)(\\.\\d+)?$";

	/**
	 * 常用正则表达式：匹配由26个英文字母组成的字符串
	 */
	public final static String regExp_A_Za_z = "^[A-Za-z]+$";
	
	/**
	 * 常用正则表达式：匹配由26个英文字母的大写组成的字符串
	 */
	public final static String regExp_A_Z = "^[A-Z]+$";
	
	/**
	 * 常用正则表达式：匹配由26个英文字母的小写组成的字符串
	 */
	public final static String regExp_a_z = "^[a-z]+$";
	
	/**
	 * 常用正则表达式：匹配由数字和26个英文字母组成的字符串
	 */
	public final static String regExp_A_Za_z0_9= "^[A-Za-z0-9]+$";
	
	/**
	 * 常用正则表达式：匹配由数字、26个英文字母或者下划线组成的字符串
	 */
	public final static String regExp_A_Za_z0_9_ = "^\\w+$";

	/**
	 * 常用正则表达式：匹配email地址
	 */
	public final static String regExp_email = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";

	/**
	 * 常用正则表达式：匹配url
	 */
	public final static String regExp_url_1 = "^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$";
	
	/**
	 * 常用正则表达式：匹配url
	 */
	public final static String regExp_url_2 = "[a-zA-z]+://[^\\s]*";

	/**
	 * 常用正则表达式：匹配中文字符
	 */
	public final static String regExp_chinese_1 = "[\\u4e00-\\u9fa5]";
	
	/**
	 * 常用正则表达式：匹配双字节字符(包括汉字在内)
	 */
	public final static String regExp_chinese_2 = "[^\\x00-\\xff]"; 

	/**
	 * 常用正则表达式：匹配空行
	 */
	public final static String regExp_line = "\\n[\\s ? ]*\\r";

	/**
	 * 常用正则表达式：匹配HTML标记
	 */
	public final static String regExp_html_1 = "/ <(.*)>.* <\\/\\1> ? <(.*) \\/>/";
	
	/**
	 * 常用正则表达式：匹配首尾空格
	 */
	public final static String regExp_startEndEmpty = "(^\\s*) ?(\\s*$)";

	/**
	 * 常用正则表达式：匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
	 */
	public final static String regExp_accountNumber = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$"; 

	/**
	 * 常用正则表达式：匹配国内电话号码，匹配形式如 0511-4405222 或 021-87888822
	 */
	public final static String regExp_telephone = "\\d{3}-\\d{8} ?\\d{4}-\\d{7}";

	/**
	 * 常用正则表达式：腾讯QQ号, 腾讯QQ号从10000开始
	 */
	public final static String regExp_qq = "[1-9][0-9]{4,}";

	/**
	 * 常用正则表达式：匹配中国邮政编码
	 */
	public final static String regExp_postbody = "[1-9]\\d{5}(?!\\d)";

	/**
	 * 常用正则表达式：匹配身份证, 中国的身份证为15位或18位
	 */
	public final static String regExp_idCard = "\\d{14}\\w|\\d{17}\\w";

	/**
	 * 常用正则表达式：IP
	 */
	public final static String regExp_ip = "\\d+\\.\\d+\\.\\d+\\.\\d+";
	
	/**
	 * 字符编码
	 */
	public final static String encoding = "UTF-8";
	
	/**
	 * 验证字符串是否匹配指定正则表达式
	 * @param content
	 * @param regExp
	 * @return
	 */
	public static boolean regExpVali(String content, String regExp){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(content);
		return matcher.matches();
	}
	public static void main(String[] args) {
		System.out.println(regExpVali("440802198708092516",Regexs.regExp_idCard));
	}
	/** Prevent instantiation */
	private Regexs() {
	}
}
