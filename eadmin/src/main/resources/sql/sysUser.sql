page
===
select @pageTag(){
#use("cols")# 
@} 
	from sys_user where #use("like")#
cols
===
	id,login_name,password,salt,name,tel,phone,address,email,qq,weixin,weibo,idcard,zip,status,sex,birth,remarks,create_by,create_date,last_login_time,login_count,session_key
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(loginName)){
	 and login_name=#loginName#
	@}
	@if(!isEmpty(password)){
	 and password=#password#
	@}
	@if(!isEmpty(salt)){
	 and salt=#salt#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(tel)){
	 and tel=#tel#
	@}
	@if(!isEmpty(phone)){
	 and phone=#phone#
	@}
	@if(!isEmpty(address)){
	 and address=#address#
	@}
	@if(!isEmpty(email)){
	 and email=#email#
	@}
	@if(!isEmpty(qq)){
	 and qq=#qq#
	@}
	@if(!isEmpty(weixin)){
	 and weixin=#weixin#
	@}
	@if(!isEmpty(weibo)){
	 and weibo=#weibo#
	@}
	@if(!isEmpty(idcard)){
	 and idcard=#idcard#
	@}
	@if(!isEmpty(zip)){
	 and zip=#zip#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(sex)){
	 and sex=#sex#
	@}
	@if(!isEmpty(birth)){
	 and birth=#birth#
	@}
	@if(!isEmpty(remarks)){
	 and remarks=#remarks#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(lastLoginTime)){
	 and last_login_time=#lastLoginTime#
	@}
	@if(!isEmpty(loginCount)){
	 and login_count=#loginCount#
	@}
	@if(!isEmpty(sessionKey)){
	 and session_key=#sessionKey#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(loginName)){
	 and login_name like #'%'+loginName+'%'#
	@}
	@if(!isEmpty(password)){
	 and password like #'%'+password+'%'#
	@}
	@if(!isEmpty(salt)){
	 and salt like #'%'+salt+'%'#
	@}
	@if(!isEmpty(name)){
	 and name like #'%'+name+'%'#
	@}
	@if(!isEmpty(tel)){
	 and tel like #'%'+tel+'%'#
	@}
	@if(!isEmpty(phone)){
	 and phone like #'%'+phone+'%'#
	@}
	@if(!isEmpty(address)){
	 and address like #'%'+address+'%'#
	@}
	@if(!isEmpty(email)){
	 and email like #'%'+email+'%'#
	@}
	@if(!isEmpty(qq)){
	 and qq like #'%'+qq+'%'#
	@}
	@if(!isEmpty(weixin)){
	 and weixin like #'%'+weixin+'%'#
	@}
	@if(!isEmpty(weibo)){
	 and weibo like #'%'+weibo+'%'#
	@}
	@if(!isEmpty(idcard)){
	 and idcard like #'%'+idcard+'%'#
	@}
	@if(!isEmpty(zip)){
	 and zip like #'%'+zip+'%'#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(sex)){
	 and sex=#sex#
	@}
	@if(!isEmpty(birth)){
	 and birth=#birth#
	@}
	@if(!isEmpty(remarks)){
	 and remarks like #'%'+remarks+'%'#
	@}
	@if(!isEmpty(createBy)){
	 and create_by like #'%'+createBy+'%'#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(lastLoginTime)){
	 and last_login_time=#lastLoginTime#
	@}
	@if(!isEmpty(loginCount)){
	 and login_count=#loginCount#
	@}
	@if(!isEmpty(sessionKey)){
	 and session_key like #'%'+sessionKey+'%'#
	@}
