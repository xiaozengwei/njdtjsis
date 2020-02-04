<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String base = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ;
%>
<style>
.div-user-operation{
	text-align:center; width:100%; line-height:50px;
}
.div-user-operation > button {
	margin-left: 10px;
}
</style>
<input value="<%=base%>" id="global-base-path" type="hidden"/>
<div style="width:100%;">
	<fieldset>
		<legend>用户操作</legend>
		<div class="div-user-operation" style="">
			<button type="button" class="btn-save btn-blue" data-icon="save" id="btn-global-form">提交</button>
			<button type="button" class=" btn-grey" data-icon="save" id="btn-global-grey"  disabled="disabled" style="display: none;">提交中</button>
			<button type="button" class="btn-close" data-icon="close" id="btn-global-close">取消</button>
			<button type="button" class="btn-blue" data-icon="" style="display: none;" id="btn-global-send-read"  data-url="<%=basePath%>publish/user-select-page.do?opt=sendread" data-title="请选择増阅人员"  data-width="900"  data-height="500">増阅</button>
			<button type="button" class="btn-blue" data-icon="arrow-right" style="display: none;" id="btn-global-sw2fw" data-warn="确定收转发吗？">收转发</button>
		</div>
	</fieldset>
</div>


