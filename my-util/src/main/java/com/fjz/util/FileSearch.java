package com.fjz.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫描文件
 * @author fengjianzhong
 *
 */
public class FileSearch {
	public static List<FileModel> findModels(String dirPath,String endsWith) {
		List<String> files=findFiles(dirPath, endsWith);
		List<FileModel> models =Lists.newList();
		for (String string : files) {
			models.add(new FileModel().setFile(new File(string)));
		}
		return models;
	}
	/**
	 * 
	 * @param dirPath	搜索的目录
	 * @param endsWith	文件后缀比如[.java]  null为搜索全部
	 * @return
	 */
	public static List<String> findFiles(String dirPath,String endsWith) {
		List<String> files = new ArrayList<String>();
		// 判断目录是否存在
        File baseDir = new File(dirPath);
        Assert.isTrue(baseDir.exists() && baseDir.isDirectory(), "路径不存在或者不是一个目录！");
        String tempName = null;
        File[] filelist = baseDir.listFiles();
        for (File file : filelist) {
        	if (file.isDirectory()) {
        		files.addAll(findFiles(file.getAbsolutePath(),endsWith));
          } else {
        	  tempName = file.getName();
        	  if(endsWith!=null&&!tempName.endsWith(endsWith)){
              	continue;
              }
        	  String ablPath = file.getAbsoluteFile().getAbsolutePath().replace("\\", "/");
        	  files.add(ablPath);
          }
		}
        return files;
	}
}
