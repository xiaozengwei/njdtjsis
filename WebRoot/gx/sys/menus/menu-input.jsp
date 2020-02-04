<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<script type="text/javascript">
//选择事件
function S_NodeCheck(e, treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId),
        nodes = zTree.getCheckedNodes(true)
    var ids = '', names = ''
    
    for (var i = 0; i < nodes.length; i++) {
        ids   += ','+ nodes[i].id
        names += ','+ nodes[i].name
    }
    if (ids.length > 0) {
        ids = ids.substr(1), names = names.substr(1)
    }
    $("#parentmenuid").val(nodes[nodes.length-1].id);
    
    var $from = $('#'+ treeId).data('fromObj')
    
    if ($from && $from.length) $from.val(names)
}
//单击事件
function S_NodeClick(event, treeId, treeNode) {
    $("#parentmenuid").val(treeNode.id);
}

</script>
<div class="bjui-pageContent">
               
 <form action="<%=basePath%>menu/menu-save.do" id="menu_input_form" class="pageForm" data-toggle="validate" data-reloadNavtab="true">
        <input name="rowId" type="hidden" value="${model.rowId }"/>
        <table class="table table-condensed table-hover">
            <tbody style="text-align:center;">
             <tr>
                  <td>
                    <h3>菜单添加</h3>
                  </td>
             </tr>
             <tr style="margin:10px">
                 <td>
                 <label class="control-label">父 级 菜 单</label>
				  <input type="text" name="menus" id="j_ztree_menus2" data-toggle="selectztree" style="width:250px" value="${parentFunc.functionName}" data-tree="#menu_tree" data-rule="required" readonly>
				  <ul id="menu_tree" class="ztree hide" data-toggle="ztree" data-expand-all="false" data-check-enable="true" data-chk-style="radio" data-radio-type="all" data-on-check="S_NodeCheck" data-on-click="S_NodeClick" style="height:200px">
				      <c:forEach items="${ztree}" var="ztree">
				        <li data-id=${ztree.id } data-pid=${ztree.pId } data-tabid="table">${ztree.name}</li> ";
				      </c:forEach>
				  </ul>
                     <input type="hidden" name="parentFunctionId" id="parentmenuid" value="${model.parentFunctionId }">
                 </td>
             </tr>
             <tr>
                  <td>
                    <label class="control-label">菜 单 名 称</label>
                    <input type="text" name="functionName" style="width:250px" value="${model.functionName}" data-rule="required">
                  </td>
             </tr>
             <tr>
                  <td>
                    <label class="control-label">英 文 名 称</label>
                    <input type="text" name="functionEnName" style="width:250px" value="${model.functionEnName}">
                  </td>
             </tr>
             <tr>
                  <td>
                    <label class="control-label">数 据 排 序</label>
                    <select name="dataOrder" data-toggle="selectpicker" value="${model.dataOrder}" >
                      <option vaule="1" style="width:250px" <c:if test="${'1' eq model.dataOrder}">selected</c:if>>1</option>
                      <option vaule="2" <c:if test="${'2' eq model.dataOrder}">selected</c:if>>2</option>
                      <option vaule="3" <c:if test="${'3' eq model.dataOrder}">selected</c:if>>3</option>
                      <option vaule="4" <c:if test="${'4' eq model.dataOrder}">selected</c:if>>4</option>
                      <option vaule="5" <c:if test="${'5' eq model.dataOrder}">selected</c:if>>5</option>
                      <option vaule="6" <c:if test="${'6' eq model.dataOrder}">selected</c:if>>6</option>
                      <option vaule="7" <c:if test="${'7' eq model.dataOrder}">selected</c:if>>7</option>
                      
                    </select>
                    
                  </td>
             </tr>
             <tr>
                  <td>
                    <label class="control-label" >菜 单 级 别</label>
                    <select name="functionType" value="${model.functionType}"  data-toggle="selectpicker">
                        <option value="1" style="width:250px" <c:if test="${'1' eq model.functionType}">selected</c:if>>1</option>
                        <option value="2" <c:if test="${'2' eq model.functionType}">selected</c:if>>2</option>
                        <option value="3" <c:if test="${'3' eq model.functionType}">selected</c:if>>3</option>
                    </select>
                    
                  </td>
             </tr>
            </tbody>
        </table>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="submit" class="btn-default" >保存</button></li>
        <li><button type="button" class="btn-close" >关闭</button></li>
        
    </ul>
</div>