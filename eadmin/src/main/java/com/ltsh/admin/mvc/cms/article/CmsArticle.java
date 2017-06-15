package com.ltsh.admin.mvc.cms.article;
import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
/**
 *  cms_article 文章 
 * @author fjz
 */
public class CmsArticle{
	public static final String tableName="cms_article";
	public static final String tableRemarks="文章";
	private java.lang.Integer id;//id 
	private java.lang.Integer categoryId;//目录id 
	private java.lang.String title;//文章名称 
	private java.lang.String content;//文件内容 
	private java.lang.Integer countView;//浏览数 
	private java.lang.Integer countComment;//评论数 
	private java.lang.String status;//状态//radio/-1隐藏,1,显示 
	private java.lang.Integer isComment;//是否评论：-1否 1 是 
	private java.lang.Integer isRecommend;//是否推荐：-1否 1 是 
	private java.lang.Integer sort;//排序 
	private java.lang.String href;//跳转地址 
	private java.lang.String imageUrl;//图片路径 
	private java.lang.String fileUrl;//文件路径 
	private java.lang.String fileName;//文件名 
	private java.lang.Integer approveStatus;//审核状态 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date startTime;//更新时间 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date endTime;//结束时间 
	private java.lang.String updateBy;//更新者 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date updateTime;//更新时间 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createTime;//创建时间 
	private java.lang.Integer createBy;//创建者 
	private java.lang.String remarks;//备注信息 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：id **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setCategoryId(java.lang.Integer categoryId){
		this.categoryId=categoryId;
	}
	/** category_id INT(10)：目录id **/
	public java.lang.Integer getCategoryId() {
		return categoryId;
	}
	public void setTitle(java.lang.String title){
		this.title=title;
	}
	/** title VARCHAR(200)：文章名称 **/
	public java.lang.String getTitle() {
		return title;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	/** content LONGTEXT(2147483647)：文件内容 **/
	public java.lang.String getContent() {
		return content;
	}
	public void setCountView(java.lang.Integer countView){
		this.countView=countView;
	}
	/** count_view INT(10)：浏览数 **/
	public java.lang.Integer getCountView() {
		return countView;
	}
	public void setCountComment(java.lang.Integer countComment){
		this.countComment=countComment;
	}
	/** count_comment INT(10)：评论数 **/
	public java.lang.Integer getCountComment() {
		return countComment;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	/** status VARCHAR(20)：状态//radio/-1隐藏,1,显示 **/
	public java.lang.String getStatus() {
		return status;
	}
	public void setIsComment(java.lang.Integer isComment){
		this.isComment=isComment;
	}
	/** is_comment INT(10)：是否评论：-1否 1 是 **/
	public java.lang.Integer getIsComment() {
		return isComment;
	}
	public void setIsRecommend(java.lang.Integer isRecommend){
		this.isRecommend=isRecommend;
	}
	/** is_recommend INT(10)：是否推荐：-1否 1 是 **/
	public java.lang.Integer getIsRecommend() {
		return isRecommend;
	}
	public void setSort(java.lang.Integer sort){
		this.sort=sort;
	}
	/** sort INT(10)：排序 **/
	public java.lang.Integer getSort() {
		return sort;
	}
	public void setHref(java.lang.String href){
		this.href=href;
	}
	/** href VARCHAR(256)：跳转地址 **/
	public java.lang.String getHref() {
		return href;
	}
	public void setImageUrl(java.lang.String imageUrl){
		this.imageUrl=imageUrl;
	}
	/** image_url VARCHAR(256)：图片路径 **/
	public java.lang.String getImageUrl() {
		return imageUrl;
	}
	public void setFileUrl(java.lang.String fileUrl){
		this.fileUrl=fileUrl;
	}
	/** file_url VARCHAR(256)：文件路径 **/
	public java.lang.String getFileUrl() {
		return fileUrl;
	}
	public void setFileName(java.lang.String fileName){
		this.fileName=fileName;
	}
	/** file_name VARCHAR(256)：文件名 **/
	public java.lang.String getFileName() {
		return fileName;
	}
	public void setApproveStatus(java.lang.Integer approveStatus){
		this.approveStatus=approveStatus;
	}
	/** approve_status INT(10)：审核状态 **/
	public java.lang.Integer getApproveStatus() {
		return approveStatus;
	}
	public void setStartTime(java.util.Date startTime){
		this.startTime=startTime;
	}
	/** start_time DATETIME(19)：更新时间 **/
	public java.util.Date getStartTime() {
		return startTime;
	}
	public void setEndTime(java.util.Date endTime){
		this.endTime=endTime;
	}
	/** end_time DATETIME(19)：结束时间 **/
	public java.util.Date getEndTime() {
		return endTime;
	}
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy=updateBy;
	}
	/** update_by VARCHAR(64)：更新者 **/
	public java.lang.String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	/** update_time DATETIME(19)：更新时间 **/
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	/** create_time DATETIME(19)：创建时间 **/
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateBy(java.lang.Integer createBy){
		this.createBy=createBy;
	}
	/** create_by INT(10)：创建者 **/
	public java.lang.Integer getCreateBy() {
		return createBy;
	}
	public void setRemarks(java.lang.String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注信息 **/
	public java.lang.String getRemarks() {
		return remarks;
	}

}
