<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	long currentTime  = System.currentTimeMillis();
 %>
<div class="bjui-pageContent" id="templet-page-container">
	<input type="hidden" id="isLoad" value="0" />
	<input type="hidden" name="redirectUrl" id="redirectUrl" value="${redirectUrl}" />
	<input type="hidden" name="templetType" id="global-templetType" value="${templetType}" />
    <%--具体的表单--%>
	<div id="form"  data-toggle="autoajaxload"  data-url="<%=path%>${formUrl}" ></div>
    <%--附件--%>
	<div id="file"  data-toggle="autoajaxload"  data-url="<%=path%>${fileUrl}" ></div>
    <%--文件关联--%>
	<div id="file-relation"  data-toggle="autoajaxload"  data-url="<%=path%>${fileRelationUrl}" ></div>

	<div id="advice"  data-toggle="autoajaxload"  data-url="<%=path%>${adviceUrl}" ></div>
	<div id="send-read"  data-toggle="autoajaxload"  data-url="<%=path%>${sendReadUrl}" ></div>
    <%--处理过程--%>
	<div id="process"  data-toggle="autoajaxload"  data-url="<%=path%>${processUrl}" ></div>
    <%--用户操作--%>
	<div id="opeartor"  data-toggle="autoajaxload"  data-url="<%=path%>${opeartorUrl}" ></div>
</div>
<script type="text/javascript" src="<%=basePath%>gx/js/templet-page.js?v=<%=currentTime %>"></script>
