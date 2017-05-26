package com.fjz.gen.base;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.fjz.gen.Gen;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class MyConnection {
	public static String driverClass=null;
	static{
		PropKit.use(new File(Gen.class.getResource("gen.properties").getFile()));
	}
	public static Connection geConnection() throws SQLException {
        Connection con = null;
        Properties props =new Properties();
        Prop p = PropKit.getProp();
        driverClass=p.get("driverClass");
        try {
            Class.forName(driverClass);//"com.mysql.jdbc.Driver");
            props.setProperty("user", p.get("user"));
            props.setProperty("password", p.get("password"));
            props.setProperty("remarks", "true"); //设置可以获取remarks信息 
            if(driverClass.indexOf("mysql")!=-1){
            	props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            }
            con = DriverManager.getConnection(p.get("jdbcUrl"), props);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return con;
	}
}
