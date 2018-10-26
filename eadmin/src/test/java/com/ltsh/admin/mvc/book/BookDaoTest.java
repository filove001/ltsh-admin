package com.ltsh.admin.mvc.book;
import com.ltsh.admin.BaseDaoTest;
import org.junit.Test;

public class BookDaoTest extends BaseDaoTest{
	private BookDao dao=sqlManager.getMapper(BookDao.class);
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		Book entity=create(" Book",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public Book create(String name,int i){
		Book entity=new Book();
		entity.setId(1);
		entity.setSource(name+i);
		entity.setName(name+i);
		entity.setIntro(name+i);
		entity.setWriter(name+i);
		entity.setWriterClick(1);
		entity.setStatus("连载");
		entity.setLable(name+i);
		entity.setWordCount(1);
		entity.setBeginDate(new java.util.Date());
		entity.setLastUpdate(new java.util.Date());
		entity.setLove(1);
		entity.setShelf(1);
		entity.setShow(1);
		entity.setSort(1);
		entity.setClick(1);
		entity.setSearchKey(1);
		return entity;
		}
}
