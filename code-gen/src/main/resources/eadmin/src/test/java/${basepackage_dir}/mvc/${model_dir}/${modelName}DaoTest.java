package ${basepackage}.mvc.${modelpackage};
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${table.modelName}DaoTest{
	@Autowired
	private ${table.modelName}Dao dao;
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
