page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_user_role where #use("like")#
cols
===
	user_id,role_id
condition
===
	1 = 1 
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(roleId)){
	 and role_id=#roleId#
	@}

like
===
	1=1
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(roleId)){
	 and role_id=#roleId#
	@}
