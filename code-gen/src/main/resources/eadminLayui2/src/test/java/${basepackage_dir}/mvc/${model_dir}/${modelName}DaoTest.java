package ${basepackage}.mvc.${modelpackage};
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class ${table.modelName}DaoTest extends BaseDaoTest{
	private ${table.modelName}Dao dao=sqlManager.getMapper(${table.modelName}Dao.class);
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		${table.modelName} entity=create(" ${table.modelName}",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public ${table.modelName} create(String name,int i){
		${table.modelName} entity=new ${table.modelName}();
		<%for(colunm in table.columns){%>
			<%if(colunm.javaType=='java.util.Date'){%>
		entity.set${colunm.attrNameUpperCaseFirstOne}(new java.util.Date());
			<%}else if(strutil.startWith(colunm.type,'ENUM')){%>
		entity.set${colunm.attrNameUpperCaseFirstOne}("${colunm.enumValues[0]}");
			<%}else if(colunm.javaType=='java.lang.String'){%>
		entity.set${colunm.attrNameUpperCaseFirstOne}(name+i);
			<%}else if(colunm.javaType=='java.lang.Integer'){%>
		entity.set${colunm.attrNameUpperCaseFirstOne}(1);
			<%}else if(colunm.javaType=='java.lang.Double'){%>
		entity.set${colunm.attrNameUpperCaseFirstOne}(1);
			<%}%>
		<%}%>
		return entity;
		}
}
