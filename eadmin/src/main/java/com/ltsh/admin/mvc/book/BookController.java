package com.ltsh.admin.mvc.book;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.BaseService;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 书本详情 Controller
 */
@Controller
@RequestMapping("/book")
public class BookController extends CrudController<Book> {
	public final static String ADD_TITLE = "添加"+Book.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+Book.tableRemarks;
	public final static String viewPath = "book";
	@Autowired
	private BookService bookService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "book/book";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/bookAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,Book book) {
		Book dbEntity=bookService.unique(book.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
//	   	request.setAttribute("idDisplayNone", true);//id
//	   	request.setAttribute("sourceDisplayNone", true);//来源
//	   	request.setAttribute("nameDisplayNone", true);//书本名字
//	   	request.setAttribute("introDisplayNone", true);//详情
//	   	request.setAttribute("writerDisplayNone", true);//作者
//	   	request.setAttribute("writerClickDisplayNone", true);//作者点击
//	   	request.setAttribute("statusDisplayNone", true);//状态 完本连载停更
//	   	request.setAttribute("lableDisplayNone", true);//标签
//	   	request.setAttribute("wordCountDisplayNone", true);//字数
//	   	request.setAttribute("beginDateDisplayNone", true);//开始更新日期
//	   	request.setAttribute("lastUpdateDisplayNone", true);//最近更新
//	   	request.setAttribute("loveDisplayNone", true);//喜欢人数
//	   	request.setAttribute("shelfDisplayNone", true);//书架添加数
//	   	request.setAttribute("showDisplayNone", true);//是否显示
//	   	request.setAttribute("sortDisplayNone", true);//排序
//	   	request.setAttribute("clickDisplayNone", true);//点击
//	   	request.setAttribute("searchKeyDisplayNone", true);//搜索
//	   //控制编辑框是否不可用
//	   	request.setAttribute("idDisabled", true);//id
//	   	request.setAttribute("sourceDisabled", true);//来源
//	   	request.setAttribute("nameDisabled", true);//书本名字
//	   	request.setAttribute("introDisabled", true);//详情
//	   	request.setAttribute("writerDisabled", true);//作者
//	   	request.setAttribute("writerClickDisabled", true);//作者点击
//	   	request.setAttribute("statusDisabled", true);//状态 完本连载停更
//	   	request.setAttribute("lableDisabled", true);//标签
//	   	request.setAttribute("wordCountDisabled", true);//字数
//	   	request.setAttribute("beginDateDisabled", true);//开始更新日期
//	   	request.setAttribute("lastUpdateDisabled", true);//最近更新
//	   	request.setAttribute("loveDisabled", true);//喜欢人数
//	   	request.setAttribute("shelfDisabled", true);//书架添加数
//	   	request.setAttribute("showDisabled", true);//是否显示
//	   	request.setAttribute("sortDisabled", true);//排序
//	   	request.setAttribute("clickDisabled", true);//点击
//	   	request.setAttribute("searchKeyDisabled", true);//搜索
		return viewPath+"/bookAddOrEdit";
	}
}





