package com.fjz.gen.insert.rolemenu;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.OracleStyle;
import org.beetl.sql.ext.DebugInterceptor;

import com.fjz.gen.base.DbTable;
import com.fjz.gen.base.DbTableFactory;
import com.fjz.gen.base.MyConnection;
import com.fjz.gen.insert.rolemenu.model.SysMenu;
import com.fjz.gen.insert.rolemenu.model.SysMenuAutoIds;
import com.fjz.gen.insert.rolemenu.model.SysRole;
import com.fjz.gen.insert.rolemenu.model.SysRoleMenu;
import com.fjz.gen.insert.rolemenu.model.SysRoleTenant;
import com.fjz.gen.insert.rolemenu.model.SysTenant;
import com.fjz.gen.insert.rolemenu.model.SysTenantAutoIds;
import com.fjz.gen.insert.rolemenu.model.SysUser;
import com.fjz.util.Maps;

/**
 * 插入权限和菜单数据
 * @author fengjianzhong
 *
 */
public class InsertRoleMenu {
	public static void main(String[] args) throws SQLException {
		List<DbTable> tables = DbTableFactory.getDbTables(MyConnection
				.geConnection());
		SQLManager sqlManager=init();
		for (DbTable table : tables) {
			if(table.name.split("_").length==3){
				continue;
			}
			inisertMenu(table,sqlManager);
		}
		insertSysRole(sqlManager);
		insertRoleMenu(sqlManager);
		insertUser(sqlManager);
		insertTenant(sqlManager);
	}
	private static void  insertUser(SQLManager sqlManager){
		SysUser sysUser=new SysUser();
		sysUser.setId(1L);
		sysUser.setUsername("13660242040");
		sysUser.setName("admin");
		sysUser.setPhone("13660242040");
		sysUser.setEmail("fengjianzhong@126.com");
		sysUser.setIdentityCard("13660242040");
		sysUser.setStatus("1");
		sysUser.setCreateBy("1234");
		sysUser.setCreateTime(new Date());
		sysUser.setPassword("0b9e9e8afbba093e9dc79b0a7290365f42e3afd0478fd99aeab62387");
		sqlManager.insert(sysUser);
	}
	private static void insertTenant(SQLManager sqlManager){
		SysTenant  e=new SysTenant();
		e.setAppType("随访");
		e.setCreateTime(new Date());
		e.setName("系统管理员");
		e.setPid(0L+"");
		e.setSysUserId(1L);
		e.setTypeShort("admin");
		e.setId(SysTenantAutoIds.getId(e));
		sqlManager.insert(e);
		SysRoleTenant t=new SysRoleTenant();
		t.setSysRoleId(1L);
		t.setSysTenantId(e.getId());
		sqlManager.insert(t);
	}
	private static void insertRoleMenu(SQLManager sqlManager){
		List<SysMenu> list=sqlManager.all(SysMenu.class);
		for (SysMenu sysMenu : list) {
			SysRoleMenu e=new SysRoleMenu();
			e.setSysRoleId(1L);
			e.setSysMenuId(sysMenu.getId());
			sqlManager.insert(e);
		}
	}
	private static void insertSysRole(SQLManager sqlManager){
		SysRole sysRole=new SysRole();
		sysRole.setId(1L);
		sysRole.setCreateTime(new Date());
		sysRole.setName("系统管理员");
		sysRole.setType("sys");
		sqlManager.insert(sysRole);
	}
	private static SysMenu getButton(SysMenu pMenu,String chinaBtnName,String button,DbTable table){
		SysMenu sysMenu=new SysMenu();
		sysMenu.setName(chinaBtnName);
		sysMenu.setCreateTime(new Date());
		sysMenu.setHref("/"+table.getDir()+"/"+button);
		sysMenu.setType("button");
		sysMenu.setIcon("glyphicon glyphicon-link");
		sysMenu.setPermission(table.modelName+":"+button);
		sysMenu.setPid(pMenu.getId());
		sysMenu.setId(SysMenuAutoIds.getId());
		return sysMenu;
	}
	private static void  inisertMenu(DbTable table,SQLManager sqlManager){
		SysMenu sysMenu=new SysMenu();
		sysMenu.setName(table.remarks);
		sysMenu.setCreateTime(new Date());
		sysMenu.setHref("/"+table.getDir()+"/index");
		sysMenu.setType("menu");
		sysMenu.setIcon("glyphicon glyphicon-link");
		sysMenu.setPid(0L);
		sysMenu.setId(SysMenuAutoIds.getId());
		sqlManager.insert(sysMenu);
		Map<String,Object> map=Maps.newMap(new String[]{"insert","update","delete"}, new Object[]{"增加","修改","删除"});
		for (Entry<String,Object> e: map.entrySet()) {
			sqlManager.insert(getButton(sysMenu,e.getValue().toString(),e.getKey(),table));
		}
//		String[] buttons={"insert","update","delete"};
//		for (String btn : buttons) {
//			
//		}
	}
	private static SQLManager init(){
		ConnectionSource source = ConnectionSourceHelper.getSimple("oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@192.168.1.123:1521:orcl","multitenant", "123");
				DBStyle mysql = new OracleStyle();
				// sql语句放在classpagth的/sql 目录下
				SQLLoader loader = new ClasspathLoader("/sql");
				// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，
//				下划线风格的
				UnderlinedNameConversion nc = new UnderlinedNameConversion();
				// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
				SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new
				DebugInterceptor()});
				return sqlManager;
	}
}
