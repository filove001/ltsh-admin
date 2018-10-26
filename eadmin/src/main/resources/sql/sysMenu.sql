page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_menu where #use("like")#
cols
===
	id,parent_id,parent_ids,level,type,name,sort,href,target,icon,permission,status,create_by,create_date,update_by,update_date,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(parentIds)){
	 and parent_ids=#parentIds#
	@}
	@if(!isEmpty(level)){
	 and level=#level#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(href)){
	 and href=#href#
	@}
	@if(!isEmpty(target)){
	 and target=#target#
	@}
	@if(!isEmpty(icon)){
	 and icon=#icon#
	@}
	@if(!isEmpty(permission)){
	 and permission=#permission#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
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
	 and id=#id#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(parentIds)){
	 and parent_ids like #'%'+parentIds+'%'#
	@}
	@if(!isEmpty(level)){
	 and level=#level#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(name)){
	 and name like #'%'+name+'%'#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(href)){
	 and href like #'%'+href+'%'#
	@}
	@if(!isEmpty(target)){
	 and target like #'%'+target+'%'#
	@}
	@if(!isEmpty(icon)){
	 and icon like #'%'+icon+'%'#
	@}
	@if(!isEmpty(permission)){
	 and permission like #'%'+permission+'%'#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
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
