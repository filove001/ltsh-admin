page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_role where #use("like")#
cols
===
	id,name,code,status,create_by,create_date,update_by,update_date,remarks
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(code)){
	 and code=#code#
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
	@if(!isEmpty(name)){
	 and name like #'%'+name+'%'#
	@}
	@if(!isEmpty(code)){
	 and code like #'%'+code+'%'#
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
