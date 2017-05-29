
/**回车点击事件**/
function  enterClickById(id,fn){
	$(id).bind('keypress',function(event){
	if(event.keyCode == "13"){
	   fn();
	}
	});
}
/**回车点击事件**/
$.fn.enterClick = function (fn) {
    $(this).on('keypress',function(event){
        if(event.keyCode == "13"){
            fn();
        }
    });
}
/**只能输入数字**/
$.fn.onlyNum = function () {
    $(this).keypress(function (event) {
        var eventObj = event || e;
        var keyCode = eventObj.keyCode || eventObj.which;
        if ((keyCode >= 48 && keyCode <= 57))
            return true;
        else
            return false;
    }).focus(function () {
    //禁用输入法
        this.style.imeMode = 'disabled';
    }).bind("paste", function (e) {
    	//获取剪切板的内容
    	var clipboard='';
    	if(window.clipboardData&&indow.clipboardData.getData){//ie
    		clipboard = window.clipboardData.getData("Text");
    	}else{
    		clipboard=e.originalEvent.clipboardData.getData("Text");
    	}
        if (/^\d+$/.test(clipboard))
            return true;
        else
            return false;
    }).on("input propertychange",function(e){
    	if (!/^\d+$/.test(e.target.value))
            $(this).val('');
    });
};

//常量
var constant={
	debug:true,		//是否在调试
	browser:null	//浏览器
}
//Log(this.self.getName,"");
/*function Log(obj){
	if(constant.debug){
        var browser=checkBrowser();
		if (browser.firefox||browser.chrome)
        	return console.log(e);
	}
}*/
function Log(str,obj){
    if(constant.debug){
        var browser=checkBrowser();
        if (browser.firefox||browser.chrome){
        	if(arguments.length==1){
        		return console.log(arguments[0]);
        	}
            return console.log("%s : %o",str,obj);
        }
    }
}
function empty(obj){
	return obj==null||obj=='';
}
function emptyString(s){
	return s==null||s==''||s==undefined;
}
function blank(src){
	var result = src;
	if(src==null||src==''||src=='undefined'||src=='null'){
		result = "";
	}
	return result;
}
var getType = function(object) {
        var _t;
        return ((_t = typeof(object)) == "object" ? object == null && "null" || Object.prototype.toString.call(object).slice(8, -1) : _t).toLowerCase();
 }
function isString(o) {
   return getType(o) == "string";
}
//检测浏览器
function checkBrowser() {
	if(constant.browser)
		return constant.browser;
    var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    var s;
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
        (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
            (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
                (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
    constant.browser=Sys;
    return Sys;
}
function getNewDate(){
	var myDate = new Date();
	return myDate.getFullYear()+"-"+zero(myDate.getMonth()+1)+"-"+zero(myDate.getDate());
}
function zero(num){
	return num<10?'0'+num:num;
}
/**
 * ajax
 */
function ajax(param){
	if(param.type==null){
		param.type='POST';
	}
	var success=param.success;//自己传进来的的success方法
//	if(param.success==null){
//	async:false, false为同步
	param.success=function(data, textStatus){
//		Log("login","成功了！");
		if(data.state==-1){
			alert(data.msg);
			location.reload();
			return false;
		}
		if(success!=null){
			success(data, textStatus);
		}
//		Log("login",data);
		return true;
	};
//	}
	if(param.error==null){
		param.error=function (XMLHttpRequest, textStatus, errorThrown) {
			Log("系统错误",XMLHttpRequest);
			Log("系统错误",errorThrown);
			alert('系统错误请检查！');
		    // 通常 textStatus 和 errorThrown 之中
		    // 只有一个会包含信息
		    //this; // 调用本次AJAX请求时传递的options参数
		};
	}
	if(param.timeout==null){//设置请求超时时间（毫秒）。此设置将覆盖全局设置。
		param.timeout=100000;
	}
	$.ajax(param);
}

//第一次去空字串  和 null值得对象
function deleteEmptyString(test, recurse) {
    for (var i in test) {
        if (test[i] === '' ||test[i] ===null) {
            delete test[i];
        } else if (recurse && typeof test[i] === 'object') {
            deleteEmptyString(test[i], recurse);
        }
    }
}
function isEmpty(obj) {
	   return (Object.keys(obj).length === 0 && obj.constructor === Object);
}
//第二次是去空对象
function deleteEmptyObject(test, recurse) {
    
    for (var i in test) {
        if (isEmpty(test[i]) ) {
            delete test[i];
        } else if (recurse && typeof test[i] === 'object') {
            deleteEmptyObject(test[i], recurse);
        }
    }
       
}