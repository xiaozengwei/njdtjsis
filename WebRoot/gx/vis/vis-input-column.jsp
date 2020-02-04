<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>vis/column-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${gxViewColumn.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>栏目添加</h3></td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">栏目名称：</label>
                    <input type="text" name="columnName"  value="${gxViewColumn.columnName}" data-rule="required" size="20">
                </td>
            </tr>

            <tr>
                <td>
                    <label class="control-label x90">父栏目：</label>
                    <input type="hidden" name="parentId"  value="${gxViewColumn.parentId}" >
                    <input type="text" name="parentName"  readonly="readonly" value="${gxViewColumn.parentName}" data-toggle="lookup" data-url="<%=basePath %>vis/lookup-vis-column-list.do"  size="20" data-title="请选择父栏目" >

                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90">栏目类型：</label>
                    <input type="text" name="columnType"  value="${gxViewColumn.columnType}"  size="20">

                </td>

            </tr>
            <tr>
                <td>
                    <label class="control-label x90">排序：</label>
                    <input type="text" name="orderNum"  value="${gxViewColumn.orderNum }" data-rule="required;number" size="20">
                </td>

            </tr>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90">是否显示：</label>--%>
                    <%--<select name="isShow" id="j_dialog_roletype" data-toggle="selectpicker" size="30">--%>
                        <%--<option value="0" ${model.isShow eq '0' ? 'selected="selected"':'' }>显示</option>--%>
                        <%--<option value="1" ${model.isShow eq '1' ? 'selected="selected"':'' }>隐藏</option>--%>
                    <%--</select>--%>
                <%--</td>--%>

            <%--</tr>--%>

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