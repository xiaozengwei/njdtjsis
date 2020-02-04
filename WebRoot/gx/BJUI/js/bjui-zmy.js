/**
 * 方法说明：获取某字符串在数组中的位置 
 * 参数说明：strs:String[]数组，target要查询的字符串
 * 结果说明：-1未找到，其他值表示位置[0,length-1]
 */
function getIndexOfStrArr(strs,target){
	var result = -1;
	var strLength = strs.length;
	for(var i = 0 ;i < strLength;i++){
		if(strs[i]== target){
			result = i;
			break;
		}
	}
	
	return result;
}
/**
 * 删除指定的索引，并重新将数组组装成以逗号分隔符的字符串
 */
function removeAndJoinString(strs,char_index){
	strs.splice(char_index,1);
	var res = strs.join(',');
	return res;
}
/**
 * 格式化数字123->00123
 * @param number
 * @param form
 * @returns {String}
 */
function  formatNum (number, form) {
	var result = "";
     number = '' + number;
     var n_length = number.length;
     result = form.substring(0,form.length - n_length);
     result += number;
    return result;
}
//日期格式化
Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
	if(new RegExp("("+ k +")").test(format)) { 
	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	} 
	} 
	return format; 
} 


//获取

function getSignatureNote(userid, username, isGetImage) {
    var a_html = "<label class=\"control-label x100\">" + username + "</label>";
    if (isGetImage) {//是否获取图片签名
    	var rootPath = getRootPath();
        var _url = rootPath+"signature/note.do";
        $.ajax({
            url: _url,
            type: 'get',
            data: {userId:userid},
            async: false,
            error: function(xhr) {
            },
            success: function(isExist) {
            	if(isExist){
            		a_html = "<img src='"+rootPath+"gx/images/signature/" + userid + ".jpg'/> ";
            	}
            }
        });
    }
    return a_html;

}
function printPage(url){
	window.document.location.href=url;
}


/**
 * 打印函数
 * @param oper
 */
function printTure(oper) {

    if (oper < 10) {
        bdhtml = window.document.body.innerHTML; //获取当前页的html代码 
        sprnstr = "<!--startprint-" + oper + "-->"; //设置打印开始区域 
        eprnstr = "<!--endprint-" + oper + "-->"; //设置打印结束区域 
        prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 19); //从开始代码向后取html 
        prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr)); //从结束代码向前取html 
        window.document.body.innerHTML = prnhtml;
       
        
        window.print(); 
       // window.document.body.innerHTML = bdhtml;
        window.location.reload();

    } else {
        window.print(); 
    }

    //self.print();
}

Array.prototype.contains=function(e){
	for(i=0;i<this.length&&this[i]!=e;i++);
	return!(i==this.length);//contains:trueorfalse
};

/* 
*  方法:Array.remove(dx) 通过遍历,重构数组 
*  功能:删除数组元素. 
*  参数:dx删除元素的下标. 
*/ 
Array.prototype.remove=function(dx) 
{ 
    if(isNaN(dx)||dx>this.length){return false;} 
    for(var i=0,n=0;i<this.length;i++) 
    { 
        if(this[i]!=this[dx]) 
        { 
            this[n++]=this[i] 
        } 
    } 
    this.length-=1 
} 
/**
 * 下载文件
 */
function download_file(url)
{

if(typeof(download_file.iframe)== "undefined")
{
var iframe = document.createElement("iframe");
download_file.iframe = iframe;
document.body.appendChild(download_file.iframe); 
}
// alert(download_file.iframe);
download_file.iframe.src = url;

download_file.iframe.style.display = "none";



}

function getRootPath() {

	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp

	var curWwwPath = window.document.location.href;

	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp

	var pathName = window.document.location.pathname;

	var pos = curWwwPath.indexOf(pathName);

	// 获取主机地址，如： http://localhost:8083

	var localhostPaht = curWwwPath.substring(0, pos);

	// 获取带"/"的项目名，如：/uimcardprj

	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);

	return localhostPaht + projectName + "/";
	// 正式环境
	// return localhostPaht+"/";

}