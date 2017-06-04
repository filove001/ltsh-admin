$(function(){
	 //监听提交
	  layui.form().on('submit(info)', function(data){
		var obj=data.field;
		var url=(obj.id==null||obj.id=='')?"save":"update";
		deleteEmptyString(obj,true);//删除空白的属性
		$.ajax({
			url: url,
			data: obj,
			type: "post",
			dataType: "json",
			success: function(msg){
				if(msg.state==1){
					layer.msg('操作成功！', {time: 2000},function(){
						window.history.go(-1);
					});
                    subCallback(msg);
				}else{
                    layer.alert(data.msg,{title:'操作失败！'});
				}
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {}
		});
//	    layer.alert(JSON.stringify(data.field), {
//	      title: '最终的提交信息'
//	    })
	    return false;
	  });
});
function subCallback(msg){

}
