package com.fjz.util;

import java.io.File;

public class FileModel {
	public String dir;			//文件所在目录
	public String fileName;		//文件名
	public File file;			//文件
	public String suffix;		//后缀
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public File getFile() {
		return file;
	}
	
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public FileModel setFile(File file) {
		this.file = file;
		this.fileName=file.getName();
		this.dir=file.getParent();
		this.suffix=fileName.substring(fileName.indexOf("."));
		return this;
	}
	/**
	 * 文件名是否帶有el形式的
	 * @return
	 */
	public boolean isFileNameEl(){
		return Regexs.regExpVali(fileName, "\\$\\{.+\\}.*");
	}
}
