package com.fjz.gen;

import com.fjz.gen.base.DbTable;
import com.fjz.gen.base.DbTableFactory;
import com.fjz.gen.base.MyConnection;
import com.fjz.util.*;
import com.jfinal.kit.PropKit;
import org.beetl.core.BeetlKit;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 初始化
 * 
 * @author fengjianzhong
 *
 */
public class GenInit {
	// private static String jdbcUrl;
	// private static String driverClass;
	// private static String user;
	// private static String password;
	// static{
	// 	PropKit.use(Gen.class.getResource("gen.properties").getFile());
	// }
	public String basepackage;
	// #生成的默认路径java文件根 路径
	public String outRoot;
	// #template模板所在的路径
	public String templateRoot;

	public String baasepackage_dir;
	public String model_dir;
	public GenInit() {
		BeetlKit.gt.registerFunction("string", new StrFn());
		System.out.println(GenInit.class.getResource("gen.properties")
				.getFile());
		PropKit.use(new File(GenInit.class.getResource("gen.properties")
				.getFile()));
		basepackage = PropKit.get("basepackage");
		outRoot = PropKit.get("outRoot");
		templateRoot = PropKit.get("templateRoot");
		Assert.isTrue(Empty.not(basepackage), "basepackage不能为空！");
		Assert.isTrue(Empty.not(outRoot), "outRoot不能为空！");
		if (Empty.is(templateRoot)) {
//			templateRoot = MavenFiles.getMavenSrcPath()+"main/resources/eadmin";
			//windows
			templateRoot = (MavenFiles.getMavenSrcPath()+"main/resources/eadminLayui2").replace("/","\\").substring(1);
//					new File(GenInit.class.getResource("/").getFile()
//					+ "eadmin").getAbsolutePath();
		}
		System.out.println(templateRoot);
		baasepackage_dir = basepackage.replaceAll("\\.", File.separator
				+ File.separator);
	}

	public static void main(String[] args) throws SQLException, IOException {
		GenInit g = new GenInit();
//		g.gen("SYS_APP","SYS_ROLE_APP");
//		g.gen("book","book_book_type","book_type","book_shelf","book_source","search","book_content");
//		g.gen("book");
//		g.gen("sys_user");
//		g.gen("sys_dict");
//		g.gen("cms_article","cms_category","cms_article_data");
		g.gen("cms_category");
		Runtime.getRuntime().exec("cmd.exe /c start "+g.outRoot);

//        g.delete("Service");
//        g.delete("Dao");
//        g.delete("Controller");
////		Runtime.getRuntime().exec("cmd.exe /c start "+g.outRoot+"\\src\\main\\resources\\templates\\sys\\user");
////		Runtime.getRuntime().exec("cmd.exe /c start E:\\java\\spring\\xky\\multi-tenant"+"");
	}
	public void delete(String name){
        List<FileModel> models = FileSearch.findModels(outRoot, null);
        for (FileModel model:models) {
            if(model.fileName.contains(name)){
                System.out.println(model.file+" delete:"+model.file.delete());
            }
        }
//        System.out.println(Jsons.toString(models));
    }
	public void gen(String... tableNames) throws SQLException {
		List<DbTable> tables = DbTableFactory.getDbTables(MyConnection
				.geConnection(),tableNames);
		List<FileModel> list = FileSearch.findModels(templateRoot, null);
		for (FileModel fileModel : list) {
			String writeFile = fileModel.getFile().getAbsolutePath()
					.replace("${basepackage_dir}", baasepackage_dir);
			writeFile = writeFile.replace(templateRoot, outRoot);
			if (fileModel.isFileNameEl()) {
				genByDbTable(tables, fileModel, writeFile);
			} else {
				genByDbTables(tables, fileModel, writeFile);
			}
		}
	}
	public void createDir(String writeFile){
		File file = new File(writeFile);
		File dir = new File(file.getParent());
		if (!dir.exists())
			dir.mkdirs();
	}
	public void genByDbTables(List<DbTable> tables, FileModel fileModel,
			String writeFile) {
		Map<String, Object> paras = Maps.newMap();
		paras.put("tables", tables);
		paras.put("basepackage", basepackage);
		createDir(writeFile);
		System.out.println(writeFile);
		BeetlKit.renderTo(Files.read(fileModel.getFile().getAbsolutePath()),
				Files.getWrite(new File(writeFile)), paras);
	}

	public void genByDbTable(List<DbTable> tables, FileModel fileModel,
			String writeFile) {
		String tempWriteFile;
		for (DbTable dbTable : tables) {
			tempWriteFile = writeFile.replace("${modelName}", dbTable.modelName);
			tempWriteFile = tempWriteFile.replace("${model_dir}", dbTable.getDir());
			tempWriteFile = tempWriteFile.replace("${modelNamefirstLower}", dbTable.getModelNamefirstLower());
			createDir(tempWriteFile);
			Map<String, Object> paras = Maps.newMap();
			paras.put("basepackage", basepackage);
			paras.put("modelpackage", dbTable.getPackage());
			paras.put("table", dbTable);
			System.out.println(tempWriteFile);
			BeetlKit.renderTo(
					Files.read(fileModel.getFile().getAbsolutePath()),
					Files.getWrite(new File(tempWriteFile)), paras);
		}
	}
}
