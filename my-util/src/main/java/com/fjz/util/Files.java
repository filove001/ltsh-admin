package com.fjz.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class Files {
	public static List<String> readLines(File f) {
		return readLines(f,"UTF-8");
	}
    public static List<String> readLines(File f,String encode) {
        List<String> lines = new ArrayList<String>();
        try(BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(f), encode))){
            while (br.ready())
                lines.add(br.readLine());
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return lines;
    }
	public static String readLine(InputStream is,String encode) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(is, encode))){
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String read(String filePath) {
		return read(filePath,"UTF-8");
	}
	public static String read(String filePath, String encode) {
		String s = null;
		try {
			s = read(new FileInputStream(filePath), encode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	public static String read(InputStream is, String encode) {
		String s = null;
		try {
			s = new String(read(is), encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
	public static byte[] read(InputStream is) {
		ByteArrayOutputStream o = new ByteArrayOutputStream();
		int temp = -1;
		try {
			while ((temp = is.read()) != -1) {
				o.write((byte) temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(is);
		}
		return o.toByteArray();
	}
	public static Writer getWrite(File file){
		BufferedWriter writer=null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}
	public static void write(String file, String s) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File(file)));
			writer.write(s);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭一个可关闭对象，可以接受 null。如果成功关闭，返回 true，发生异常 返回 false
	 * 
	 * @param cb
	 *            可关闭对象
	 * @return 是否成功关闭
	 */
	public static boolean close(Closeable cb) {
		if (null != cb)
			try {
				cb.close();
			} catch (IOException e) {
				return false;
			}
		return true;
	}
	public static void flush(Flushable fa) {
		if (null != fa)
			try {
				fa.flush();
			} catch (IOException e) {
			}
	}
}
