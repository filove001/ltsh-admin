page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_dict where #use("like")#
cols
===
	id,dict_value,dict_key,type,description,sort,parent_id,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(dictValue)){
	 and dict_value=#dictValue#
	@}
	@if(!isEmpty(dictKey)){
	 and dict_key=#dictKey#
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
	@if(!isEmpty(dictValue)){
	 and dict_value like #'%'+dictValue+'%'#
	@}
	@if(!isEmpty(dictKey)){
	 and dict_key like #'%'+dictKey+'%'#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
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
