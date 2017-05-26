package com.fjz.gen;

import java.io.File;
import java.sql.SQLException;

public class GenChange {
	public static void main(String[] args) throws SQLException {
		GenInit gen=new GenInit();
		gen.templateRoot=new File(GenInit.class.getResource("/").getFile()
				+ "templateChange").getAbsolutePath();
		gen.outRoot="E:\\genChange";
		gen.gen("SYS_ROLE_TENANT"
				,"SYS_TENANT"
				,"SYS_ROLE"
				,"SYS_MENU"
				,"SYS_ROLE_MENU"
				);
	}
}
