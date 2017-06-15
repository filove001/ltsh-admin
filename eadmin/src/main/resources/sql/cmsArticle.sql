page
===
select @pageTag(){
#use("cols")# 
@} 
	from cms_article where #use("like")#
cols
===
	id,category_id,title,content,count_view,count_comment,status,is_comment,is_recommend,sort,href,image_url,file_url,file_name,approve_status,start_time,end_time,update_by,update_time,create_time,create_by,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(categoryId)){
	 and category_id=#categoryId#
	@}
	@if(!isEmpty(title)){
	 and title=#title#
	@}
	@if(!isEmpty(content)){
	 and content=#content#
	@}
	@if(!isEmpty(countView)){
	 and count_view=#countView#
	@}
	@if(!isEmpty(countComment)){
	 and count_comment=#countComment#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(isComment)){
	 and is_comment=#isComment#
	@}
	@if(!isEmpty(isRecommend)){
	 and is_recommend=#isRecommend#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(href)){
	 and href=#href#
	@}
	@if(!isEmpty(imageUrl)){
	 and image_url=#imageUrl#
	@}
	@if(!isEmpty(fileUrl)){
	 and file_url=#fileUrl#
	@}
	@if(!isEmpty(fileName)){
	 and file_name=#fileName#
	@}
	@if(!isEmpty(approveStatus)){
	 and approve_status=#approveStatus#
	@}
	@if(!isEmpty(startTime)){
	 and start_time=#startTime#
	@}
	@if(!isEmpty(endTime)){
	 and end_time=#endTime#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by=#updateBy#
	@}
	@if(!isEmpty(updateTime)){
	 and update_time=#updateTime#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(remarks)){
	 and remarks=#remarks#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(categoryId)){
	 and category_id=#categoryId#
	@}
	@if(!isEmpty(title)){
	 and title like #'%'+title+'%'#
	@}
	@if(!isEmpty(content)){
	 and content like #'%'+content+'%'#
	@}
	@if(!isEmpty(countView)){
	 and count_view=#countView#
	@}
	@if(!isEmpty(countComment)){
	 and count_comment=#countComment#
	@}
	@if(!isEmpty(status)){
	 and status like #'%'+status+'%'#
	@}
	@if(!isEmpty(isComment)){
	 and is_comment=#isComment#
	@}
	@if(!isEmpty(isRecommend)){
	 and is_recommend=#isRecommend#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(href)){
	 and href like #'%'+href+'%'#
	@}
	@if(!isEmpty(imageUrl)){
	 and image_url like #'%'+imageUrl+'%'#
	@}
	@if(!isEmpty(fileUrl)){
	 and file_url like #'%'+fileUrl+'%'#
	@}
	@if(!isEmpty(fileName)){
	 and file_name like #'%'+fileName+'%'#
	@}
	@if(!isEmpty(approveStatus)){
	 and approve_status=#approveStatus#
	@}
	@if(!isEmpty(startTime)){
	 and start_time=#startTime#
	@}
	@if(!isEmpty(endTime)){
	 and end_time=#endTime#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by like #'%'+updateBy+'%'#
	@}
	@if(!isEmpty(updateTime)){
	 and update_time=#updateTime#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(remarks)){
	 and remarks like #'%'+remarks+'%'#
	@}
