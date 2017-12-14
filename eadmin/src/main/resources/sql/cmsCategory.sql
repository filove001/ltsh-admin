page
===
select @pageTag(){
#use("cols")# 
@} 
	from cms_category where #use("like")#
cols
===
	id,parent_id,name,path,content,sort,status,type,href,material_type,site_id,seo_title,seo_keywords,seo_description,update_time,update_by,create_time,create_by
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(parentId)){
	 and parent_id=#parentId#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(path)){
	 and path=#path#
	@}
	@if(!isEmpty(content)){
	 and content=#content#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(href)){
	 and href=#href#
	@}
	@if(!isEmpty(materialType)){
	 and material_type=#materialType#
	@}
	@if(!isEmpty(siteId)){
	 and site_id=#siteId#
	@}
	@if(!isEmpty(seoTitle)){
	 and seo_title=#seoTitle#
	@}
	@if(!isEmpty(seoKeywords)){
	 and seo_keywords=#seoKeywords#
	@}
	@if(!isEmpty(seoDescription)){
	 and seo_description=#seoDescription#
	@}
	@if(!isEmpty(updateTime)){
	 and update_time=#updateTime#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by=#updateBy#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
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
	@if(!isEmpty(name)){
	 and name like #'%'+name+'%'#
	@}
	@if(!isEmpty(path)){
	 and path like #'%'+path+'%'#
	@}
	@if(!isEmpty(content)){
	 and content like #'%'+content+'%'#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(status)){
	 and status like #'%'+status+'%'#
	@}
	@if(!isEmpty(type)){
	 and type=#type#
	@}
	@if(!isEmpty(href)){
	 and href like #'%'+href+'%'#
	@}
	@if(!isEmpty(materialType)){
	 and material_type=#materialType#
	@}
	@if(!isEmpty(siteId)){
	 and site_id=#siteId#
	@}
	@if(!isEmpty(seoTitle)){
	 and seo_title like #'%'+seoTitle+'%'#
	@}
	@if(!isEmpty(seoKeywords)){
	 and seo_keywords like #'%'+seoKeywords+'%'#
	@}
	@if(!isEmpty(seoDescription)){
	 and seo_description like #'%'+seoDescription+'%'#
	@}
	@if(!isEmpty(updateTime)){
	 and update_time=#updateTime#
	@}
	@if(!isEmpty(updateBy)){
	 and update_by=#updateBy#
	@}
	@if(!isEmpty(createTime)){
	 and create_time=#createTime#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
