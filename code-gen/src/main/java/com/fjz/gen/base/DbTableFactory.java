package com.fjz.gen.base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fjz.util.Empty;
import com.fjz.util.Lists;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.dialect.Dialect;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;

public class DbTableFactory {
	protected Connection conn = null;
	protected DatabaseMetaData dbMeta = null;
	protected Dialect dialect = new OracleDialect();
	protected Set<String> excludedTables = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	public static List<DbTable> getDbTablesByFilterTableNames(Connection conn,String... filterTableNames){
		List<DbTable> list=getDbTables(conn);
		Map<String,String> map=Lists.arrayToMap(filterTableNames);
		if(Empty.not(filterTableNames)){
			List<DbTable> listTbs=new ArrayList<DbTable>();
			for (DbTable dbTable : list) {
				if(!map.containsKey(dbTable.name)){
					listTbs.add(dbTable);
				}
			}
		}
		return list;
	}
	
	public static List<DbTable> getDbTables(Connection conn,String... tableNames){
		List<DbTable> list=getDbTables(conn);
		Map<String,DbTable> map=Lists.listToMap("name", list);
		if(Empty.not(tableNames)){
			list=new ArrayList<DbTable>();
			for (String name : tableNames) {
				if(map.containsKey(name)){
					list.add(map.get(name));
				}
			}
		}
		return list;
	}
	public static List<DbTable> getDbTables(Connection conn){
		return new DbTableFactory().build(conn);
	}
	public List<DbTable> build(Connection conn) {
		System.out.println("Build Table ...");
		if(MyConnection.driverClass.indexOf("mysql")!=-1){
			dialect=new MysqlDialect();
		}
		try {
			this.conn = conn;
			dbMeta = conn.getMetaData();
			List<DbTable> ret = new ArrayList<DbTable>();
			buildTableNames(ret);
			for (DbTable table : ret) {
				buildPrimaryKey(table);
				buildColumn(table);
			}
			return ret;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null)
				try {conn.close();} catch (SQLException e) {throw new RuntimeException(e);}
		}
	}
	/**组装表的字段*/
	private void buildColumn(DbTable table) throws SQLException {
		// 重建整个 TableMeta.columnMetas
		table.columns = new ArrayList<TbColumn>();
		String schemaPattern = dialect instanceof OracleDialect ? dbMeta.getUserName() : null;
		ResultSet rs = dbMeta.getColumns(conn.getCatalog(), schemaPattern, table.name, null);
//		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			TbColumn columnMeta = new TbColumn();
			columnMeta.dbTableName=table.name;
			columnMeta.name = buildName(rs.getString("COLUMN_NAME"));//oracle变小写			// 名称
			columnMeta.attrName = buildAttrName(columnMeta.name);	
			columnMeta.type = rs.getString("TYPE_NAME");			// 类型
			if (columnMeta.type == null)
				columnMeta.type = "";
			
			int columnSize = rs.getInt("COLUMN_SIZE");				// 长度
			columnMeta.length=columnSize;
			
			if (columnSize > 0) {
				columnMeta.type = columnMeta.type + "(" + columnSize;
				int decimalDigits = rs.getInt("DECIMAL_DIGITS");	// 小数位数
				if (decimalDigits > 0) {
					columnMeta.type = columnMeta.type + "," + decimalDigits;
				}
				columnMeta.type = columnMeta.type + ")";
			}
			
			columnMeta.isNullable = rs.getString("IS_NULLABLE");	// 是否允许 NULL 值
			columnMeta.isNullable=columnMeta.isNullable==null?"":"YES".equals(columnMeta.isNullable)?"true":"false";
//			if (columnMeta.isNullable == null)
//				columnMeta.isNullable = "";
			
			columnMeta.isPrimaryKey = "false";
			String[] keys = table.primaryKey.split(",");
			for (String key : keys) {
				if (key.equalsIgnoreCase(columnMeta.name)) {
					columnMeta.isPrimaryKey = "true";
					break;
				}
			}
			columnMeta.defaultValue = rs.getString("COLUMN_DEF");	// 默认值
			if (columnMeta.defaultValue == null) columnMeta.defaultValue = "";
			
			columnMeta.remarks = rs.getString("REMARKS");			// 备注
			
			if (columnMeta.remarks == null) columnMeta.remarks = "";
			int type = rs.getInt("DATA_TYPE");//rsmd.getColumnType(i);//
			columnMeta.javaType=TypeMapping.getColumnClassName(type);//取得Java类型
			if(columnMeta.type.indexOf("NUMBER")!=-1&&columnMeta.type.indexOf(".")==-1){//如过是NUMBER并且没有小数
				if(columnSize<=10){//如果小于10位
					columnMeta.javaType=java.lang.Integer.class.getName();
				}else if(columnSize<=19){//如果小于19位
					columnMeta.javaType=java.lang.Long.class.getName();
				}
			}
			
			
			if (table.colNameMaxLen < columnMeta.name.length())
				table.colNameMaxLen = columnMeta.name.length();
			if (table.colTypeMaxLen < columnMeta.type.length())
				table.colTypeMaxLen = columnMeta.type.length();
			if (table.colDefaultValueMaxLen < columnMeta.defaultValue.length())
				table.colDefaultValueMaxLen = columnMeta.defaultValue.length();
			
//			columnMeta.attrNameUpperCaseFirstOne=StrKit.firstCharToUpperCase(columnMeta.attrName);
			table.columns.add(columnMeta);
		}
		rs.close();
	}
	private String buildName(String name) {
		if (dialect instanceof OracleDialect) {
			name = name.toLowerCase();
		}
		return name;
	}
	private String buildAttrName(String name) {
		if (dialect instanceof OracleDialect) {
			name = name.toLowerCase();
		}
		return StrKit.toCamelCase(name);
	}
	/**组装表的主键字段*/
	private void buildPrimaryKey(DbTable table) throws SQLException {
		String schemaPattern = dialect instanceof OracleDialect ? dbMeta.getUserName() : null;
		ResultSet rs = dbMeta.getPrimaryKeys(conn.getCatalog(), schemaPattern, table.name);
		String primaryKey = "";
		int index = 0;
		while (rs.next()) {
			if (index++ > 0)
				primaryKey += ",";
			primaryKey += rs.getString("COLUMN_NAME");
		}
		table.primaryKey = primaryKey;
		rs.close();
	}
	/**组装表*/
	private void buildTableNames(List<DbTable> ret) throws SQLException {
		ResultSet rs = getTablesResultSet();
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			
			if (excludedTables.contains(tableName)) {
				System.out.println("Skip table :" + tableName);
				continue ;
			}
//			if (isSkipTable(tableName)) {
//				System.out.println("Skip table :" + tableName);
//				continue ;
//			}
			DbTable tableMeta = new DbTable();
			tableMeta.name = tableName;
			tableMeta.remarks = rs.getString("REMARKS");
			//清除 表注释后面的那个表字
			tableMeta.remarks=tableMeta.remarks.endsWith("表")?tableMeta.remarks.substring(0, tableMeta.remarks.length()-1):tableMeta.remarks;
			tableMeta.modelName = buildModelName(tableName);
			tableMeta.baseModelName = buildBaseModelName(tableMeta.modelName);
			ret.add(tableMeta);
		}
		rs.close();
	}
	
	/**
	 * 使用 modelName 构建 baseModelName
	 */
	protected String buildBaseModelName(String modelName) {
		return  modelName+"Base";
	}
	/**
	 * 构造 modelName，mysql 的 tableName 建议使用小写字母，多单词表名使用下划线分隔，不建议使用驼峰命名
	 * oracle 之下的 tableName 建议使用下划线分隔多单词名，无论 mysql还是 oralce，tableName 都不建议使用驼峰命名
	 */
	private String buildModelName(String tableName) {
		// 将 oralce 大写的 tableName 转成小写，再生成 modelName
		if (dialect instanceof OracleDialect) {
			tableName = tableName.toLowerCase();
		}
		return StrKit.firstCharToUpperCase(StrKit.toCamelCase(tableName));
	}
	/**
	 * 不同数据库 dbMeta.getTables(...) 的 schemaPattern 参数意义不同
	 * 1：oracle 数据库这个参数代表 dbMeta.getUserName()
	 * 2：postgresql 数据库中需要在 jdbcUrl中配置 schemaPatter，例如：
	 *   jdbc:postgresql://localhost:15432/djpt?currentSchema=public,sys,app
	 *   最后的参数就是搜索schema的顺序，DruidPlugin 下测试成功
	 * 3：开发者若在其它库中发现工作不正常，可通过继承 MetaBuilder并覆盖此方法来实现功能
	 */
	protected ResultSet getTablesResultSet() throws SQLException {
		String schemaPattern = dialect instanceof OracleDialect ? dbMeta.getUserName() : null;
		return dbMeta.getTables(conn.getCatalog(), schemaPattern, null, new String[]{"TABLE", "VIEW"});
	}
}
