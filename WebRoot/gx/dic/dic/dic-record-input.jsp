<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<div class="bjui-pageContent">
	<form action="<%=basePath%>dic/dic-record-save.do" method="post"
		data-toggle="validate" data-reloadNavtab="true">
		<input name="rowId" type="hidden" value="${model.rowId }" /> <input
			name="tableId" type="hidden"
			value="${indexId eq null ? model.tableId : indexId }" />
		<table class="table table-condensed table-hover">
			<tbody>
				<tr>
					<td colspan="2" align="center"><h3>数据字典添加</h3>
					</td>
				</tr>

				<tr>
					<td><label for="j_dialog_rolename" class="control-label x90">字典名称：</label>
						<input type="text" name="dicName" value="${model.dicName}"
						data-rule="required" size="20"></td>
					<td><label for="j_dialog_roleid" class="control-label x90">字典功能Id：</label>
						<input type="text" name="dicId" value="${model.dicId}"
						data-rule="required" size="20"></td>
				</tr>
				<tr>
					<td><label for="j_dialog_roletype" class="control-label x90">字典类型：</label>
						<input type="text" name="dicType" value="${model.dicType}"
						data-rule="required" size="20"></td>
					<td><label for="j_dialog_dataorder" class="control-label x90">字典状态：</label>
						<input type="text" name="status" value="${model.status }"
						data-rule="" size="20"></td>
				</tr>
				<tr>
					<td><label for="j_dialog_roleintro" class="control-label x90">字典值：</label>
						<input type="text" name="dicValue" value="${model.dicValue }"
						data-rule="required" size="20"></td>
					<td><label for="j_dialog_roleintro" class="control-label x90">排序：</label>
						<input type="text" name="orderNum" value="${model.orderNum }"
						data-rule="number" size="20"></td>
				</tr>
				<tr>
					<td colspan="2"><label for="j_dialog_parentrolename"
						class="control-label x150">是否启用最大值配置：</label> <input
						type="checkbox" value="1" name="maxStatus" ${model.maxStatus
						eq '1' ? 'checked="checked" ': '' }/></td>
				</tr>
				<tr>
					<td colspan="2"><label for="j_dialog_parentrolename"
						class="control-label x90">字典显示内容：</label> <textarea cols="30"
							rows="1" data-toggle="autoheight" name="dicShowVal">${model.dicShowVal }</textarea>
					</td>
				</tr>

			</tbody>
		</table>
	</form>
</div>
<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-close">关闭</button>
		</li>
		<li><button type="submit" class="btn-default">保存</button>
		</li>
	</ul>
</div>