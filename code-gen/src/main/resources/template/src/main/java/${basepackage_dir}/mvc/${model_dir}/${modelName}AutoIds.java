package ${basepackage}.mvc.${modelpackage};

import java.util.concurrent.atomic.AtomicLong;

import com.xky.multi.tenant.util.SpringContextHolder;

/**
 * 自增长
 * @author fengjianzhong
 *
 */
public class ${table.modelName}AutoIds {
	
	private static ${table.modelName}Dao ${table.modelNamefirstLower}Dao=SpringContextHolder.getBean("${table.modelNamefirstLower}Dao");
	private static AtomicLong id;
	static{
		Long max=${table.modelNamefirstLower}Dao.getMaxId();
		if(max==null){
			max=0L;
		}
		id=new AtomicLong(max+1);
	}
//	 定义原子变量
	 public  static Long getId(){
		 return id.getAndIncrement();
	 }
}
