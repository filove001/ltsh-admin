package com.ltsh.admin.mvc.book;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
import com.ltsh.admin.mvc.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 书本详情 service
 */
@Service
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService{
	@Autowired
	private BookDao bookDao;
}
