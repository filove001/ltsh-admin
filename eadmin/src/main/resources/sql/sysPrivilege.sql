page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_privilege where #use("like")#
cols
===
	id,master,master_value,access,access_value,operation
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(master)){
	 and master=#master#
	@}
	@if(!isEmpty(masterValue)){
	 and master_value=#masterValue#
	@}
	@if(!isEmpty(access)){
	 and access=#access#
	@}
	@if(!isEmpty(accessValue)){
	 and access_value=#accessValue#
	@}
	@if(!isEmpty(operation)){
	 and operation=#operation#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(master)){
	 and master like #'%'+master+'%'#
	@}
	@if(!isEmpty(masterValue)){
	 and master_value like #'%'+masterValue+'%'#
	@}
	@if(!isEmpty(access)){
	 and access like #'%'+access+'%'#
	@}
	@if(!isEmpty(accessValue)){
	 and access_value like #'%'+accessValue+'%'#
	@}
	@if(!isEmpty(operation)){
	 and operation like #'%'+operation+'%'#
	@}
