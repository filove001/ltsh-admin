package com.fjz.gen.swagger;

import java.sql.SQLException;
import java.util.List;

import org.beetl.core.BeetlKit;

import com.fjz.gen.base.DbTable;
import com.fjz.gen.base.DbTableFactory;
import com.fjz.gen.base.MyConnection;
import com.fjz.util.Files;
import com.fjz.util.Maps;

public class ApiImpl {
	public static void main(String[] args) throws SQLException {
		String str=Files.read(ApiImpl.class.getResourceAsStream("ApiImplicitParam.html"),"UTF-8");
		List<DbTable> tables = DbTableFactory.getDbTables(MyConnection
				.geConnection(),"SYS_PATIENT");
		for (DbTable dbTable : tables) {
			String s=BeetlKit.render(str, Maps.newMap("table", dbTable));
			System.out.println(s);
		}
	}
}
