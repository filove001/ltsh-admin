page
===
select @pageTag(){
#use("cols")# 
@} 
	from cms_article_data where #use("like")#
cols
===
	id,content,copyfrom,relation
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(content)){
	 and content=#content#
	@}
	@if(!isEmpty(copyfrom)){
	 and copyfrom=#copyfrom#
	@}
	@if(!isEmpty(relation)){
	 and relation=#relation#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(content)){
	 and content like #'%'+content+'%'#
	@}
	@if(!isEmpty(copyfrom)){
	 and copyfrom like #'%'+copyfrom+'%'#
	@}
	@if(!isEmpty(relation)){
	 and relation like #'%'+relation+'%'#
	@}
