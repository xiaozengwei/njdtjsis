<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<div class="bjui-pageContent">
	<form action="<%=basePath%>sysuser/orgsuser-save-tz.do" method="post" data-toggle="validate" data-reloadNavtab="false">
	<input type="hidden" name="orgId" value="${orgId}"/>
    <div class="bjui-doc">
        <h3 class="page-header">多组织用户选择</h3>
        <ul>
            <li>
                <label>多组织用户：</label>
                <input type="hidden" name="userId"   class="doc_lookup" >
                <input type="text" name="userName"  size="30" class="doc_lookup" data-toggle="lookup" data-url="<%=basePath%>sysuser/userlookup.do" size="20" readonly="readonly" data-width="700" data-height="600" data-title="请选择人员">
            </li>
           
        </ul>
    </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>