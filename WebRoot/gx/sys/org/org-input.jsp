<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sysorg/org-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
	 <input type="hidden" name="rowId"  value="${model.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>组织添加</h3></td>
                </tr>
                
                <tr>
                	<td>
                        <label class="control-label x90">组织名称：</label>
                        <input type="text" name="orgName"  value="${model.orgName}" data-rule="required" size="20">
                    </td>
                </tr>
               
                <tr>
                	<td>
                        <label class="control-label x90">父组织：</label>
                        <input type="hidden" name="parentOrgId"  value="${model.parentOrgId}" >
                        <input type="text" name="parentOrgName"  value="${model.parentOrgName}" data-toggle="lookup" data-url="<%=basePath %>sysorg/lookup-org-list.do" data-rule="required" size="20" data-title="请选择父组织">
                        
                    </td>
                   
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">组织类型：</label>
                        <input type="text" name="orgType"  value="${model.orgType}" data-rule="required" size="20">
                        
                    </td>
                   
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">排序：</label>
                        <input type="text" name="dataOrder" id="j_dialog_dataorder" value="${model.dataOrder }" data-rule="required;number" size="20">
                	</td>
                	
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">是否显示：</label>
                         <select name="isShow" id="j_dialog_roletype" data-toggle="selectpicker" size="30">
                            <option value="0" ${model.isShow eq '0' ? 'selected="selected"':'' }>显示</option>
                            <option value="1" ${model.isShow eq '1' ? 'selected="selected"':'' }>隐藏</option>
                        </select>
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