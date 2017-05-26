package com.fjz.gen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;

import com.fjz.gen.base.DbTable;
import com.fjz.gen.base.DbTableFactory;
import com.fjz.gen.base.MyConnection;
import com.fjz.util.MavenFiles;
import com.fjz.util.Names;
import com.fjz.util.StrFn;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
//@SuppressWarnings({"unchecked","serial"})
public class Gen {
	static String templateDir=Gen.class.getResource("/").getFile()+File.separator+"template";
	String genRootDir;
	FileResourceLoader resourceLoader;
	Configuration cfg;
	GroupTemplate gt;
	String basePackageName;
	static{
		PropKit.use(Gen.class.getResource("gen.properties").getFile());
	}
	public Gen(){
		this(templateDir,"com.fjz.mvc",MavenFiles.getMavenSrcPath());
	}
	public Gen(String templateDir,String basePackageName,String genRootDir){
		Gen.templateDir=templateDir;
		this.basePackageName=basePackageName;
		this.genRootDir=genRootDir;
		resourceLoader = new FileResourceLoader(templateDir,"utf-8");
		try {
			Properties p=new Properties();
			p.load(Gen.class.getResourceAsStream("beetl.properties"));
			cfg = new Configuration(p);//Configuration.defaultConfiguration();
		} catch (IOException e) {e.printStackTrace();}
		gt = new GroupTemplate(resourceLoader, cfg);
		gt.registerFunction("string", new StrFn());
	}
	public String[] getTemplateRootFiles(){
		return new File(templateDir).list();
	}
	public String[] getTemplateRootFilesSimpleName(){
		File[] files= new File(templateDir).listFiles();
		String[] s=new String[files.length];
		for (int i = 0; i < s.length; i++) {
			s[i]=files[i].getName();
		}
		return s;
	}
	public String getJavaMvcDir(DbTable table){
		return genRootDir+"main/java/"+basePackageName.replaceAll("\\.", "/")+"/"+table.getDir();
	}
	public String getJavaMvcDir(String packageName){
		return genRootDir+"main/java/"+basePackageName.replaceAll("\\.", "/")+"/"+packageName;
	}
	public String getJavaDir(){
		return genRootDir+"main/java/com/fjz/";
	}
	public String getWebHtmlDir(DbTable table){
		return genRootDir+"main/webapp/WEB-INF/beetl/"+table.getDir();
	}
	public String getResourcesSql(){
		return genRootDir+"main/resources/sql";
	}
	public void gen(String content,String genDir,String genFileName,boolean isFileExistsCreate){
		File dir=new File(genDir);
		if(!dir.exists())
			dir.mkdirs();
		String fileStr=genDir+"/"+genFileName;
		if(isFileExistsCreate==false){
			File file=new File(fileStr);
			if(file.exists())
				return;
		}
		write(content, fileStr);
	}
	/**
	 * 
	 * @param table				表
	 * @param templatePath		模板所在目录
	 * @param templateFileName	模板名
	 * @param fileSuffix		生成文件后缀
	 * @param genDir			 生成文件目录
	 * @param isFileExistsCreate 文件存在是否创建（true创建，false不创建）
	 */
	public void gen(DbTable table,String templatePath,String templateFileName,String fileSuffix,String genDir,boolean isFileExistsCreate){
		String str = genStr(table,templatePath,templateFileName);
		String file=templateFileName.replace("Model", "").replace("sql", "");
		if(fileSuffix.equals(".html")){
			file=table.getModelNameToHtmlName()+"-"+file+fileSuffix;
		}else if(".sql".equals(fileSuffix)){
			file=StrKit.firstCharToLowerCase(table.modelName)+file+fileSuffix;
		}else{
			file=table.modelName+file+fileSuffix;
		}
		gen(str,genDir,file,isFileExistsCreate);
	}
	private static void write(String str, String file) {
		System.out.println("gen:===========>>>>>>>"+file);
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(str); 
		}catch (IOException e) {e.printStackTrace();}
	}
	public void genPrint(DbTable table,String templatePath,String templateFileName){
		System.out.println(genStr(table,templatePath, templateFileName));
	}
	public String genStr(DbTable table,String templatePath,String templateFileName){
		String packageName=basePackageName+"."+Names.camelToSplitLowerWord(table.modelName, '.');
		Template template = gt.getTemplate(templatePath+templateFileName+".html");
		template.binding("table", table);
		template.binding("package", packageName);
		String str = template.render();
		return str;
	}
	public static void main(String[] args) throws SQLException, IOException {
		List<DbTable> tables=DbTableFactory.getDbTables(MyConnection.geConnection(),"gen_filter","gen_column");
		Gen g=new Gen();
//		String[] fileNames=g.getTemplateRootFilesSimpleName();
		for (DbTable table : tables) {
//			//gen mvc
			g.gen(table,"/","BaseModel",".java",g.getJavaMvcDir(table),true);
			g.gen(table,"/","Controller",".java",g.getJavaMvcDir(table),true);
			g.gen(table,"/","Model",".java",g.getJavaMvcDir(table),true);
			g.gen(table,"/","Service",".java",g.getJavaMvcDir(table),true);
			g.gen(table,"/","Validator",".java",g.getJavaMvcDir(table),true);
//			//gen web view
			g.gen(table,"/beetlweb/","list",".html",g.getWebHtmlDir(table),false);
//			//gen sql
//			g.gen(table, "/db/","sql",".sql",g.getResourcesSql(),true);
		}
//		tables=DbTableFactory.getDbTables(MySqlConnection.getConnection());
//		g.gen(tables,"/","DBRemark",".java",g.getJavaDir()+"constant");
//		g.gen(tables,"/","_Mapping",".java",g.getJavaMvcDir("base"));
	}
	public void gen(List<DbTable> tables,String templatePath,String templateFileName,String fileSuffix,String genDir) throws SQLException{
		Template template = gt.getTemplate(templatePath+templateFileName+".html");
		template.binding("tables", tables);
		template.binding("basePackage", this.basePackageName);
		gen(template.render(),genDir,templateFileName+fileSuffix,true);
	}
	//生成model
	//身材sql.sql
	//生成service
	//生成Controller
	//生成web beetl
}
