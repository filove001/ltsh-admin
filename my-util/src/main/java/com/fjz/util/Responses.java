package com.fjz.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

public class Responses {
	/** 
	 * @Author: Charles
	 * @Description: 输出字符串到response
	 * @param response
	 * @param s void: 
	 */
	public static void writeStringToResponse(HttpServletResponse response, String s) {
		write(response,s,"UTF-8","text/html;charaset=utf-8");
	}
	public static void write(HttpServletResponse response, String s) {
		write(response,s,"UTF-8","text/html;charaset=utf-8");
	}
	public static void write(HttpServletResponse response, String s,String encode,String contentType) {
		Writer out = null;
		try {
			response.setCharacterEncoding(encode);
			response.setContentType(contentType);
			out = response.getWriter();
			if(s!=null){
				out.write(s);
				out.flush();  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
