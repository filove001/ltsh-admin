page
===
select @pageTag(){
#use("cols")# 
@} 
	from ${table.name} where #use("like")#
cols
===
	<% var temp=""; for(colunm in table.columns){ %>${temp}${colunm.name}<% temp=","; } %>
condition
===
	1 = 1 
<%for(colunm in table.columns){ %>
	@if(!isEmpty(${colunm.attrName})){
	 and ${colunm.name}=#${colunm.attrName}#
	@}
<%} %>

like
===
	1=1
<%for(colunm in table.columns){ %>
	@if(!isEmpty(${colunm.attrName})){
<%if(colunm.javaType=="java.lang.String"){ %>
	 and ${colunm.name} like #'%'+${colunm.attrName}+'%'#
<%}else{%>
	 and ${colunm.name}=#${colunm.attrName}#
<%}%>
	@}
<%} %>
