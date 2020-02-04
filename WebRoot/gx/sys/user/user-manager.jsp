<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.*"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageContent">
	<div style="float:left;">
		<div id="bjui-sidebar"
			style=" width:250px; margin-left:10px; margin-top:10px;">
			<div class="toggleCollapse">
				<h2>
					<i class="fa fa-bars"></i>
				</h2>
				<a href="javascript:;" class="lock"></a>
			</div>
			<div class="panel-group panel-main" data-toggle="accordion"
				id="bjui-accordionmenu" data-heightbox="#bjui-sidebar"
				data-offsety="26"></div>
		</div>
		<div
			style="float:left; width:250px; height:620px; margin-bottom:0px; overflow:auto; margin-top:26px; margin-left:0px; border-right:1px #c3ced5 solid; border-bottom:1px #c3ced5 solid;border-left:1px #c3ced5 solid;position: absolute;">
			<ul id="user-manager-org-tree" class="ztree" data-toggle="ztree" data-options="{nodes:'returnTreeJSON',
                        expandAll: true ,onClick:'showUsers'}">

			</ul>
			
		</div>
	</div>

	<div style="margin-left:255px; height:100%;border:1px #c3ced5 solid;"  id="user-manager-user-list"></div>

</div>
<script type="text/javascript">
$(function(){
	//console.log("####"+$("li.level1",$("#user-manager-org-tree")).length);
	//$("li.level1",$("#user-manager-org-tree")).css("border","1px solid red");
});
function showUsers(event, treeId, treeNode){
	 if (treeNode.isParent) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        zTree.expandNode(treeNode);
        return;
     };
	$.CurrentNavtab.bjuiajax('doLoad', {url:'<%=basePath%>sysuser/user-list.do', target:'#user-manager-user-list',data:'orgId='+treeNode.id});
	event.preventDefault();
}
function returnTreeJSON() {
	var jsont ;
	$.ajax({
		url:'<%=basePath%>sysorg/org-tree.do',
		type:'get',
		async:false,
		cache:false,
		dataType:'json',
		success:function(json){
			jsont = json;
		}
	});
	return jsont;
    
}
		
</script>