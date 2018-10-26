package com.ltsh.admin.mvc.book;
import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
/**
 *  book 书本详情 
 * @author fjz
 */
public class Book{
	public static final String tableName="book";
	public static final String tableRemarks="书本详情";
	private java.lang.Integer id;//id 
	private java.lang.String source;//来源 
	private java.lang.String name;//书本名字 
	private java.lang.String intro;//详情 
	private java.lang.String writer;//作者 
	private java.lang.Integer writerClick;//作者点击 
	private java.lang.String status;//状态 完本连载停更 
	private java.lang.String lable;//标签 
	private java.lang.Integer wordCount;//字数 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date beginDate;//开始更新日期 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date lastUpdate;//最近更新 
	private java.lang.Integer love;//喜欢人数 
	private java.lang.Integer shelf;//书架添加数 
	private java.lang.Integer show;//是否显示 
	private java.lang.Integer sort;//排序 
	private java.lang.Integer click;//点击 
	private java.lang.Integer searchKey;//搜索 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：id **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setSource(java.lang.String source){
		this.source=source;
	}
	/** source VARCHAR(1000)：来源 **/
	public java.lang.String getSource() {
		return source;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR(100)：书本名字 **/
	public java.lang.String getName() {
		return name;
	}
	public void setIntro(java.lang.String intro){
		this.intro=intro;
	}
	/** intro VARCHAR(1000)：详情 **/
	public java.lang.String getIntro() {
		return intro;
	}
	public void setWriter(java.lang.String writer){
		this.writer=writer;
	}
	/** writer VARCHAR(50)：作者 **/
	public java.lang.String getWriter() {
		return writer;
	}
	public void setWriterClick(java.lang.Integer writerClick){
		this.writerClick=writerClick;
	}
	/** writer_click INT(10)：作者点击 **/
	public java.lang.Integer getWriterClick() {
		return writerClick;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	/** status CHAR(2)：状态 完本连载停更 **/
	public java.lang.String getStatus() {
		return status;
	}
	public void setLable(java.lang.String lable){
		this.lable=lable;
	}
	/** lable VARCHAR(50)：标签 **/
	public java.lang.String getLable() {
		return lable;
	}
	public void setWordCount(java.lang.Integer wordCount){
		this.wordCount=wordCount;
	}
	/** word_count INT(10)：字数 **/
	public java.lang.Integer getWordCount() {
		return wordCount;
	}
	public void setBeginDate(java.util.Date beginDate){
		this.beginDate=beginDate;
	}
	/** begin_date DATETIME(19)：开始更新日期 **/
	public java.util.Date getBeginDate() {
		return beginDate;
	}
	public void setLastUpdate(java.util.Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}
	/** last_update DATETIME(19)：最近更新 **/
	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLove(java.lang.Integer love){
		this.love=love;
	}
	/** love INT(10)：喜欢人数 **/
	public java.lang.Integer getLove() {
		return love;
	}
	public void setShelf(java.lang.Integer shelf){
		this.shelf=shelf;
	}
	/** shelf INT(10)：书架添加数 **/
	public java.lang.Integer getShelf() {
		return shelf;
	}
	public void setShow(java.lang.Integer show){
		this.show=show;
	}
	/** show INT(10)：是否显示 **/
	public java.lang.Integer getShow() {
		return show;
	}
	public void setSort(java.lang.Integer sort){
		this.sort=sort;
	}
	/** sort INT(10)：排序 **/
	public java.lang.Integer getSort() {
		return sort;
	}
	public void setClick(java.lang.Integer click){
		this.click=click;
	}
	/** click INT(10)：点击 **/
	public java.lang.Integer getClick() {
		return click;
	}
	public void setSearchKey(java.lang.Integer searchKey){
		this.searchKey=searchKey;
	}
	/** search_key INT(10)：搜索 **/
	public java.lang.Integer getSearchKey() {
		return searchKey;
	}

}
