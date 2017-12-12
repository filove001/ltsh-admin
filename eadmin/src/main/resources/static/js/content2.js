$(function(){
    $('#search-form input').each(function(index,element){
        $(element).enterClick(function(){search();});
    });
    //监听工具条
    layui.table.on('tool(grid)', function(obj){
        if(obj.event === 'del'){
            del(obj.data.id);
        } else if(obj.event === 'edit'){
            window.location.href ="edit.html?id="+obj.data.id;
        }
    });
    log("layui table数据  有bug，多刷新一次");
    search();
});
var tableRequest={
    pageName: 'pageNumber' //页码的参数名称，默认：page
    ,limitName: 'pageSize' //每页数据量的参数名，默认：limit
}
var tableResponse={
    statusName: 'code' //数据状态的字段名称，默认：code
    ,statusCode: 0 //成功的状态码，默认：0
//                    ,msgName: 'hint' //状态信息的字段名称，默认：msg
    ,countName: 'totalRow' //数据总数的字段名称，默认：count
    ,dataName: 'list' //数据列表的字段名称，默认：data
}
/**列表高度**/
function getGridHeight(){
    return $('#search-form').height()+$('.layui-footer', parent.document).height()+10;
}
var pageSize=20;
function search(){
    tableIns.reload({
        where: $('#search-form').toJSON() //设定异步数据接口的额外参数，任意设
        ,page: {
            curr: 1 //重新从第 1 页开始
        }
    });
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
					search();
				}else{
                    parent.layer.alert(data.msg,{title:'删除失败！'});
				}
				parent.layer.close(index);
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {}
		});
	}, function(index){
		parent.layer.close(index);
	});
}