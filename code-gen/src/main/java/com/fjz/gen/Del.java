package com.fjz.gen;

import com.fjz.util.MavenFiles;

/**
 * 删除生成的模块的文件
 * @author fjz
 *
 */
public class Del {
	
	public static void del(String path){
		
	}
	public static void main(String[] args) {
		String srcPath=MavenFiles.getMavenSrcPath();
		//删除mvc下得文件
		del(MavenFiles.getMavenJavaSrcPath()+"com/fjz/mvc/");
		
		//删除web下得文件
		
		//删除resources/sql 下得文件
		
		
	}
}
