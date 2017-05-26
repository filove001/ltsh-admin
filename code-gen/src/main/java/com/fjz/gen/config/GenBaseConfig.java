package com.fjz.gen.config;

import java.io.File;
import java.util.Map;

import com.fjz.util.Maps;
import com.fjz.util.Reflect;
/**
 * 要隐藏的列表字段、搜索框哪些字段不需要、form里面里面不需要添加的字段隐藏就好（比如创建日期）、后端有哪些字段不是必须的判断的（非空）
 * @author fjz
 *
 */
public class GenBaseConfig {
	public static void main(String[] args) {
		System.out.println(gridColumnHide.get("gen_column.id"));
	}
	static{
//		System.out.println();
		gridColumnHide=Maps.newMap();
		searchField=Maps.newMap();
		formField=Maps.newMap();
		validator=Maps.newMap();
		File[] files=new File(GenBaseConfig.class.getResource("model").getFile()).listFiles();
		for (File file : files) {
			Reflect.on("com.fjz.gen.config.model."+file.getName().replace(".class", ""));
		}
	}
	public static Map<String,String> gridColumnHide;
	public static Map<String,String> searchField;
	public static Map<String,String> formField;
	public static Map<String,String> validator;
	
	public static Map<String, String> getGridColumnHide() {
		return gridColumnHide;
	}
	public static void setGridColumnHide(Map<String, String> gridColumnHide) {
		GenBaseConfig.gridColumnHide = gridColumnHide;
	}
	public static Map<String, String> getSearchField() {
		return searchField;
	}
	public static void setSearchField(Map<String, String> searchField) {
		GenBaseConfig.searchField = searchField;
	}
	public static Map<String, String> getFormField() {
		return formField;
	}
	public static void setFormField(Map<String, String> formField) {
		GenBaseConfig.formField = formField;
	}
	public static Map<String, String> getValidator() {
		return validator;
	}
	public static void setValidator(Map<String, String> validator) {
		GenBaseConfig.validator = validator;
	}
	
}
