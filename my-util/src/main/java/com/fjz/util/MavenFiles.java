package com.fjz.util;


public class MavenFiles {
	/**
	 * maven的源码所在的文件的路径
	 * @param cs
	 * @return
	 */
	public static String getMavenJavaSrcFile(Class<?> cs){
		String path=getMavenClassPath(cs);
		path=path.replace("target/classes/", "src/main/java/");
		path+=cs.getSimpleName()+".java";
		return path;
	}
	/**
	 * maven的源码所在的文件的所在路径
	 * @param cs
	 * @return
	 */
	public static String getMavenJavaSrcPath(Class<?> cs){
		String path=getMavenClassPath(cs);
		path=path.replace("target/classes/", "src/main/java/");
		return path;
	}
	public static String getMavenSrcPath(){
		String path=MavenFiles.class.getResource("/").getFile();
		path=path.replace("target/classes/", "src/");
		return path;
	}
	public static String getMavenJavaSrcPath(){
		String path=getMavenClassPath();
		path=path.replace("target/classes/", "src/main/java/");
		return path;
	}
	public static String getMavenWebSrcPath(){
		String path=getMavenClassPath();
		path=path.replace("target/classes/", "src/main/webapp/");
		return path;
	}
	public static String getMavenClassPath(){
		String path=MavenFiles.class.getResource("/").getFile();
		return path;
	}
	public static String getMavenClassPath(Class<?> cs){
		String path=cs.getResource("").getFile();
		return path;
	}
	public static void main(String[] args) {
		System.out.println(getMavenWebSrcPath());
	}
}
