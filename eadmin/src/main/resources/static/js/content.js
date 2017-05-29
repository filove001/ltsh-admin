$(function(){
    $('#search-form input').each(function(index,element){
        $(element).enterClick(function(){search(1);});
	});
	search(1);
});
var pageSize=20;
function search(pageNumber){
	var param=$('#search-form').serialize();
//	console.log($('#search-form').serializeArray());
	param+="&pageNumber="+pageNumber;
	param+="&pageSize="+pageSize;
	$.ajax({
		url: 'list',
		data: param,
		type: "post",
		dataType: "json",
		success: tableUpdate,
		error: function (XMLHttpRequest, textStatus, errorThrown) {}
	});
}
function tableUpdate(data){
	var html="";
	var ths=$('th[entity-name]');//获取table th 的位置的字段名
	var pageNumber=data.pageNumber;
	console.log(data);
	$('#tb-td').empty();
	if(data.list==null){
		parent.layer.msg('查询数据为空！');
		return;
	}
	data.list.forEach(function(value, index, array) {
		html+="<tr>";
//		<input type='checkbox' name='' lay-skin='primary'>
		html+="<td>"+((pageNumber-1)*pageSize+index+1)+"</td>";//序号
		for(var id in value){
			ths.each(function(index,element){
				if(id==$(element).attr('entity-name')){//保证是在列表字段匹配添加
					html+="<td>"+value[id]+"";
					return false;
				}
			});
		}
		html+='<td><a class="layui-btn layui-btn-mini" href="edit.html?id='+value['id']+'"><i class="fa fa-th-list"></i>修改</a><button onclick="del(\''+value['id']+'\')" class="layui-btn layui-btn-mini"><i class="fa fa-th-list"></i>删除</button></td>';
		html+="</tr>";
	});
	$('#tb-td').append(html);
	page(pageNumber,data.totalPage);
	layui.form().render('checkbox'); //动态插入需要刷新checkbox选择框渲染  
}
/**删除*/
function del(id){
	parent.layer.confirm('确定要删除相关的数据吗？', {
		  btn: ['确定', '取消']
	}, function(index, layero){
		$.ajax({
			url: 'delete',
			data: 'ids='+id,
			type: "post",
			dataType: "json",
			success: function(data){
				if(data.state==1){
					search(1);
				}else{
					parent.layer.msg('删除失败！');
				}
				parent.layer.close(index);
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {}
		});
	}, function(index){
		parent.layer.close(index);
	});
}
function page(pageNumber,totalPage){
	layui.laypage({
			cont: 'grid-page'
			,pages: totalPage
			,curr:pageNumber
			,skip: true,
			jump: function(obj, first){
				//obj是一个object类型。包括了分页的所有配置信息。
				//first一个Boolean类，检测页面是否初始加载。非常有用，可避免无限刷新。
				if(!first){//不加载的时候才执行search
					 //得到了当前页，用于向服务端请求对应数据
				    var curr = obj.curr;
				    search(curr);
				}
			 }
		});
}