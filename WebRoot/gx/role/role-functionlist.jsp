<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.gx.soft.sys.persistence.domain.GxSysFunction,java.util.List,java.util.Map"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	List<GxSysFunction> functionList = (List<GxSysFunction>)request.getAttribute("functionList"); 
	Map<String,String> functionIdMap = (Map<String,String>)request.getAttribute("functionIdMap");
 %>
<base href="<%=basePath %>">
 <script type="text/javascript">
		function modifyPermissions(){
			var zTree = $.fn.zTree.getZTreeObj("ztree1")
			var nameStr = "";
			var idStr = "";
			var nodes = zTree.getCheckedNodes(true);
			$.each(nodes,function(i,value){
				var id = value.id;
				idStr += i ==0 ? id : "," + id;
			});
			$("#perId",$.CurrentDialog).val(idStr);
			$("#role-functionForm",$.CurrentDialog).submit();
		}
		function returnJSON() {
		    return [<%for(int i = 0 ;i < functionList.size();i ++){%>
			{id:'<%=functionList.get(i).getRowId()%>', pId:'<%=functionList.get(i).getParentFunctionId().equals("root")? "0" : functionList.get(i).getParentFunctionId()%>', name:'<%=functionList.get(i).getFunctionName()%>', checked:<%=functionIdMap.get(functionList.get(i).getRowId()) != null ? true : false%> }
			<%if(i < functionList.size()-1){%>,
			<%}%>
			<%}%>];
		}
	</script>

<form method="post" action="<%=basePath%>role/role-permissionUpdate.do" id="role-functionForm" data-toggle="ajaxform"
	data-reloadNavtab="true">
	<input name="perId" type="hidden" id="perId" /> 
	<input name="roleId" type="hidden" value="${roleId }" />
</form>
<div class="bjui-pageContent">
	<%--<ul id="permission_tree" class="ztree"></ul>
	 --%>
	 <ul id="ztree1" class="ztree" data-toggle="ztree" 
                    data-options="{nodes:'returnJSON',
                        expandAll: true,checkEnable:true }"></ul>
    
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
        <li><button type="button" class="btn-default" onclick="modifyPermissions();">保存</button></li>
    </ul>
</div>