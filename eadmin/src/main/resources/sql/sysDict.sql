page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_dict where #use("like")#
cols
===
	id,value,label,type,description,sort,parent_id,create_by,create_date,update_by,update_date,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(value)){
	 and value=#value#
	@}
	@if(!isEmpty(label)){
	 and label=#label#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(description)){
	 and description=#description#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by=#updateBy#
	@}
	@if(!isEmpty(updateDate)){
	 and update_date=#updateDate#
	@}
	@if(!isEmpty(remarks)){
	 and remarks=#remarks#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id like #'%'+id+'%'#
	@}
	@if(!isEmpty(value)){
	 and value like #'%'+value+'%'#
	@}
	@if(!isEmpty(label)){
	 and label like #'%'+label+'%'#
	@}
	@if(!isEmpty(type)){
	 and type like #'%'+type+'%'#
	@}
	@if(!isEmpty(description)){
	 and description like #'%'+description+'%'#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id like #'%'+parentId+'%'#
	@}
	@if(!isEmpty(createBy)){
	 and create_by like #'%'+createBy+'%'#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by like #'%'+updateBy+'%'#
	@}
	@if(!isEmpty(updateDate)){
	 and update_date=#updateDate#
	@}
	@if(!isEmpty(remarks)){
	 and remarks like #'%'+remarks+'%'#
	@}
