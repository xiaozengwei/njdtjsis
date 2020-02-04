<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧工地系统</title>
<script
	src="<%=request.getContextPath()%>/gx/BJUI/js/jquery-1.7.2.min.js"></script>
<script src="<%=request.getContextPath()%>/gx/BJUI/js/jquery.cookie.js"></script>
<script src="<%=request.getContextPath()%>/gx/js/sha256.js"></script>
<link
	href="<%=request.getContextPath()%>/gx/BJUI/themes/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
* {
	font-family: "Verdana", "Tahoma", "Lucida Grande", "Microsoft YaHei",
		"Hiragino Sans GB", sans-serif;
}

body {
	background: url(../gx/images/loginbg_08.jpg) no-repeat center center
		fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

a:link {
	color: #285e8e;
}

.main_box {
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -180px;
	margin-left: -230px;
	padding: 30px;
	width: 460px;
	height: 360px;
	background: #FAFAFA;
	background: rgba(255, 255, 255, 0.7);
	border: 1px #DDD solid;
	border-radius: 5px;
	-webkit-box-shadow: 1px 5px 8px #888888;
	-moz-box-shadow: 1px 5px 8px #888888;
	box-shadow: 1px 5px 8px #888888;
}

.main_box .setting {
	position: absolute;
	top: 5px;
	right: 10px;
	width: 10px;
	height: 10px;
}

.main_box .setting a {
	color: #FF6600;
}

.main_box .setting a:hover {
	color: #555;
}

.login_logo {
	margin-bottom: 20px;
	height: 45px;
	text-align: center;
}

.login_logo img {
	height: 45px;
}

.login_msg {
	text-align: center;
	font-size: 16px;
}

.login_form {
	padding-top: 0px;
	font-size: 16px;
}

.login_box .form-control {
	display: inline-block;
	*display: inline;
	zoom: 1;
	width: auto;
	font-size: 18px;
}

.login_box .form-control.x319 {
	width: 280px;
}

.login_box .form-control.x164 {
	width: 164px;
}

.login_box .form-group {
	margin-bottom: 20px;
}

.login_box .form-group label.t {
	width: 85px;
	text-align: right;
	cursor: pointer;
}

.login_box .form-group.space {
	padding-top: 15px;
	border-top: 1px #FFF dotted;
}

.login_box .form-group img {
	margin-top: 1px;
	height: 32px;
	vertical-align: top;
}


.login_box .m {
	cursor: pointer;
}

.bottom {
	text-align: center;
	font-size: 12px;
}

#login-info {
	color: red;
}
</style>
<script type="text/javascript">

var COOKIE_NAME = 'sys__username';
$(function() {
	//获取cookie信息
	function getRememberInfo() {
	    // alert("---获取cookie信息---");
	    try {
	        var userName = "";
	        var userPassword = "";
	        userName = getCookieValue("oa_user_name");
	        userPassword = getCookieValue("oa_user_password");
	        $("#oa_user_name").val( userName);
	        $("#oa_user_password").val(userPassword);
	        if(userName.length > 0 && userPassword.length>0){
	        	$("#rmbPassword").attr("checked","checked");
	        	
	        }
	    } catch(err) {
	        alert("NO RMB PASSWORD!");
	    }
	}
	getRememberInfo();
		
	function loginfun(){
		var login_form = $("#login_form");
		var login_info = $("#login-info");
		login_info.text("");
			
			var jusername  = $("#oa_user_name").val()||"";
	       	var jPwd = $("#oa_user_password").val() ||"";
	       	if(jusername.length < 1 || jPwd.length<1){
	       		login_info.text("请输入用户名或密码");
	       	}else{
	       		$.ajax({
		        	url:'<%=basePath%>login/form-validate.do',
					data : {
					username : jusername,
					pwd : jPwd

				},
				type : 'get',
				cache : false,
				dataType : 'json',
				success : function(json) {
					var code = json.statusCode;
					if (code == "200") {
						if(document.getElementById("rmbPassword").checked){
							//alert("begin to rmb password!!!");
							setCookie("oa_user_name",jusername,24,"/");
							setCookie("oa_user_password",jPwd,24,"/");
							//alert("OK!COOKIE");
						}else{
							deleteCookie("oa_user_name","/");
							deleteCookie("oa_user_password","/");
						}
						$("#login_ok").attr("disabled", true).val('登录中..');
						var password = HMAC_SHA256_MAC(jusername, jPwd);
						
						login_form.submit();
					} else {
						login_info.text("用户名或密码错误");
					}
				}
			});
		}
	}
	$("#login_ok").click(function(){
		loginfun();
	});
	$("input").on("keydown", function(e) {
		if (e.keyCode == 13) {
			loginfun();
		}
	});
		/*$("#rmbPassword").bind("checked",function(){
			setCookie("oa_user_name",userName,24,"/");
			setCookie("oa_user_password",userPassword,24,"/");
		});
		GetLastUser();*/
});

function genTimestamp() {
	var time = new Date();
	return time.getTime();
}
function changeCode() {
	//$("#captcha_img").attr("src", "/captcha.jpeg?t="+genTimestamp());
}


//新建cookie。
//hours为空字符串时,cookie的生存期至浏览器会话结束。hours为数字0时,建立的是一个失效的cookie,这个cookie会覆盖已经建立过的同名、同path的cookie（如果这个cookie存在）。
function setCookie(name, value, hours, path) {
    var name = escape(name);
    var value = escape(value);
    var expires = new Date();
    expires.setTime(expires.getTime() + hours * 3600000);
    path = path == "" ? "": ";path=" + path;
    _expires = (typeof hours) == "string" ? "": ";expires=" + expires.toUTCString();
    document.cookie = name + "=" + value + _expires + path;
}
//获取cookie值
function getCookieValue(name) {
    var name = escape(name);
    //读cookie属性，这将返回文档的所有cookie
    var allcookies = document.cookie;
    //查找名为name的cookie的开始位置
    name += "=";
    var pos = allcookies.indexOf(name);
    //如果找到了具有该名字的cookie，那么提取并使用它的值
    if (pos != -1) { //如果pos值为-1则说明搜索"version="失败
        var start = pos + name.length; //cookie值开始的位置
        var end = allcookies.indexOf(";", start); //从cookie值开始的位置起搜索第一个";"的位置,即cookie值结尾的位置
        if (end == -1) end = allcookies.length; //如果end值为-1说明cookie列表里只有一个cookie
        var value = allcookies.substring(start, end); //提取cookie的值
        return unescape(value); //对它解码
    } else return ""; //搜索失败，返回空字符串
}
//删除cookie
function deleteCookie(name, path) {
    var name = escape(name);
    var expires = new Date(0);
    path = path == "" ? "": ";path=" + path;
    document.cookie = name + "=" + ";expires=" + expires.toUTCString() + path;
}
</script>
</head>
<body>

	<div class="main_box">

		<div class="login_box">
			<div class="login_logo">
				<img src="<%=basePath%>gx/images/logo01.png">
			</div>
			<!--
		<c:if test="${!empty message}">
			<div class="login_msg">
	      		<font color="red">${message }</font>
	    	</div>
	    </c:if>
        -->
			<div class="login_form">

				<input type="hidden" value="${randomKey }" id="j_randomKey" />
				<form action="<%=basePath%>login/init-login.do" id="login_form"
					method="post">
					<input type="hidden" name="jfinal_token" value="${jfinal_token }" />
					<div>
						<label id="login-info"></label>
					</div>
					<div class="form-group">
						<label for="j_username" class="t">用户名：</label> <input
							id="oa_user_name" value="" name="userId" type="text"
							class="form-control x319 in" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密 码：</label> <input
							id="oa_user_password" name="password" type="password"
							autocomplete="off" class="form-control x319 in">
					</div>
					<div class="form-group" style="margin-left: 50px;height:25px; line-height:25px; margin-bottom: 5px;vertical-align:middle;">
							<input type="checkbox" name="rmbPassword" id="rmbPassword"/>
							<label for="j_password" class="t">记住密码</label>
						
					</div>


					<div class="form-group space">

						<input type="button" id="login_ok" value="&nbsp;登&nbsp;录&nbsp;"
							class="btn btn-primary btn-lg" style="margin-left:75px" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="btn btn-default btn-lg"
							value="&nbsp;重&nbsp;置&nbsp;" />
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">
			Copyright &copy; 2019 <a href="#"></a>
		</div>
	</div>
</body>
</html>
