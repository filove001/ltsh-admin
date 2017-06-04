page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_log where #use("like")#
cols
===
	id,type,title,user_name,user_id,create_date,remote_addr,user_agent,request_uri,method,params,perform,long_time,desc
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(title)){
	 and title=#title#
	@}
	@if(!isEmpty(userName)){
	 and user_name=#userName#
	@}
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(remoteAddr)){
	 and remote_addr=#remoteAddr#
	@}
	@if(!isEmpty(userAgent)){
	 and user_agent=#userAgent#
	@}
	@if(!isEmpty(requestUri)){
	 and request_uri=#requestUri#
	@}
	@if(!isEmpty(method)){
	 and method=#method#
	@}
	@if(!isEmpty(params)){
	 and params=#params#
	@}
	@if(!isEmpty(perform)){
	 and perform=#perform#
	@}
	@if(!isEmpty(longTime)){
	 and long_time=#longTime#
	@}
	@if(!isEmpty(desc)){
	 and desc=#desc#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id like #'%'+id+'%'#
	@}
	@if(!isEmpty(type)){
	 and type like #'%'+type+'%'#
	@}
	@if(!isEmpty(title)){
	 and title like #'%'+title+'%'#
	@}
	@if(!isEmpty(userName)){
	 and user_name like #'%'+userName+'%'#
	@}
	@if(!isEmpty(userId)){
	 and user_id like #'%'+userId+'%'#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(remoteAddr)){
	 and remote_addr like #'%'+remoteAddr+'%'#
	@}
	@if(!isEmpty(userAgent)){
	 and user_agent like #'%'+userAgent+'%'#
	@}
	@if(!isEmpty(requestUri)){
	 and request_uri like #'%'+requestUri+'%'#
	@}
	@if(!isEmpty(method)){
	 and method like #'%'+method+'%'#
	@}
	@if(!isEmpty(params)){
	 and params like #'%'+params+'%'#
	@}
	@if(!isEmpty(perform)){
	 and perform like #'%'+perform+'%'#
	@}
	@if(!isEmpty(longTime)){
	 and long_time like #'%'+longTime+'%'#
	@}
	@if(!isEmpty(desc)){
	 and desc like #'%'+desc+'%'#
	@}
