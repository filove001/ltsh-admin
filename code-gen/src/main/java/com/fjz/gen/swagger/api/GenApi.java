package com.fjz.gen.swagger.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.beetl.core.BeetlKit;

import com.fjz.gen.base.DbTable;
import com.fjz.gen.base.DbTableFactory;
import com.fjz.gen.base.MyConnection;
import com.fjz.util.Files;
import com.fjz.util.Maps;
import com.fjz.util.Names;
import com.jfinal.kit.StrKit;

public class GenApi {
	public static void main(String[] args) throws SQLException {
		String str=Files.read(GenApi.class.getResourceAsStream("Bo.html"),"UTF-8");
		String controller=Files.read(GenApi.class.getResourceAsStream("Controller.html"),"UTF-8");
		List<DbTable> tables = DbTableFactory.getDbTables(MyConnection
				.geConnection(),"SYS_TENANT_GROUP");
		for (DbTable dbTable : tables) {
			String nameLowerCase=Names.toCamelName(dbTable.name.replace("SYS_", "").toLowerCase());
			Map<String,Object> map=Maps.newMap("table", dbTable);
			map.put("nameLowerCase",nameLowerCase );
			map.put("className", StrKit.firstCharToUpperCase(nameLowerCase));
			String s=BeetlKit.render(str, map);
			System.out.println(s);
			System.out.println("=================");
			s=BeetlKit.render(controller, map);
			System.out.println(s);
		}
	}
}
