page
===
select @pageTag(){
*
@} 
	from book where #use("like")#
condition
===
	1 = 1 
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(source)){
	 and source=#source#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(intro)){
	 and intro=#intro#
	@}
	@if(!isEmpty(writer)){
	 and writer=#writer#
	@}
	@if(!isEmpty(writerClick)){
	 and writer_click=#writerClick#
	@}
	@if(!isEmpty(status)){
	 and status=#status#
	@}
	@if(!isEmpty(lable)){
	 and lable=#lable#
	@}
	@if(!isEmpty(wordCount)){
	 and word_count=#wordCount#
	@}
	@if(!isEmpty(beginDate)){
	 and begin_date=#beginDate#
	@}
	@if(!isEmpty(lastUpdate)){
	 and last_update=#lastUpdate#
	@}
	@if(!isEmpty(love)){
	 and love=#love#
	@}
	@if(!isEmpty(shelf)){
	 and shelf=#shelf#
	@}
	@if(!isEmpty(show)){
	 and show=#show#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(click)){
	 and click=#click#
	@}
	@if(!isEmpty(searchKey)){
	 and search_key=#searchKey#
	@}

like
===
	1=1
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(source)){
	 and source like #'%'+source+'%'#
	@}
	@if(!isEmpty(name)){
	 and name like #'%'+name+'%'#
	@}
	@if(!isEmpty(intro)){
	 and intro like #'%'+intro+'%'#
	@}
	@if(!isEmpty(writer)){
	 and writer like #'%'+writer+'%'#
	@}
	@if(!isEmpty(writerClick)){
	 and writer_click=#writerClick#
	@}
	@if(!isEmpty(status)){
	 and status like #'%'+status+'%'#
	@}
	@if(!isEmpty(lable)){
	 and lable like #'%'+lable+'%'#
	@}
	@if(!isEmpty(wordCount)){
	 and word_count=#wordCount#
	@}
	@if(!isEmpty(beginDate)){
	 and begin_date=#beginDate#
	@}
	@if(!isEmpty(lastUpdate)){
	 and last_update=#lastUpdate#
	@}
	@if(!isEmpty(love)){
	 and love=#love#
	@}
	@if(!isEmpty(shelf)){
	 and shelf=#shelf#
	@}
	@if(!isEmpty(show)){
	 and show=#show#
	@}
	@if(!isEmpty(sort)){
	 and sort=#sort#
	@}
	@if(!isEmpty(click)){
	 and click=#click#
	@}
	@if(!isEmpty(searchKey)){
	 and search_key=#searchKey#
	@}
