page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_dict where #use("like")#
cols
===
	id,value,key,type,description,sort,parent_id,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(value)){
	 and value=#value#
	@}
	@if(!isEmpty(key)){
	 and key=#key#
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
	@if(!isEmpty(remarks)){
	 and remarks=#remarks#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(value)){
	 and value like #'%'+value+'%'#
	@}
	@if(!isEmpty(key)){
	 and key like #'%'+key+'%'#
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
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(remarks)){
	 and remarks like #'%'+remarks+'%'#
	@}
