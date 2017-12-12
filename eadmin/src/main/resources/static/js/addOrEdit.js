$(function(){
    addEditInit();//初始化
	 //监听提交
	  layui.form.on('submit(info)', function(data){
		var obj=data.field;
		debugger;
		log("提交",obj);
		var url=(obj.id==null||obj.id=='')?"save":"update";
          // layer.alert(JSON.stringify(data.field), {
          //     title: '最终的提交信息'
          // })
		deleteEmptyString(obj,true);//删除空白的属性
          log("提交",obj);
          beforeSubmit(obj);
		$.ajax({
			url: url,
			data: obj,
			type: "post",
			dataType: "json",
			success: function(msg){
				if(msg.state==1){
                    subCallback(msg);
				}else{
                    layer.alert(msg.msg,{title:'操作失败！'});
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
//提交之前
function beforeSubmit(data){

}
//初始化
function  addEditInit(){
    dateInit();//初始化时间空间在common.js
}
//后续可以替换
function subCallback(msg){
    layer.msg('操作成功！', {time: 2000},function(){
        window.history.go(-1);
    });
}
