<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>worksite/save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${worksiteIndex.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>工点添加</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">工点名称：</label>
                    <input type="text" name="worksiteName"  value="${worksiteIndex.worksiteName}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${worksiteIndex.bdId}" >
                    <label class="control-label x90">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${worksiteIndex.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">工点简介：</label>
                    <textarea name="ext1"  data-toggle="autoheight" size="20">
                        ${worksiteIndex.ext1}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90">时间：</label>
                    <input readonly="readonly" type="text" name="createTime" value="${worksiteIndex.createTime}" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="submit" class="btn-default">保存</button></li>
    </ul>
</div>

