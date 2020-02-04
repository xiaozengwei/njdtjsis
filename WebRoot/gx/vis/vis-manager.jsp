<%@ page language="java" pageEncoding="UTF-8"
         import="java.util.*"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="bjui-pageContent">
    <div style="float:left;">
        <div id="bjui-sidebar" style=" width:250px; margin-left:10px; margin-top:10px;">
            <div class="toggleCollapse">
                <h2> <i class="fa fa-bars" style="margin-top: 6px;">
                    栏目列表
                </i></h2>
                <a href="javascript:;" class="lock"></a>
            </div>
            <div class="panel-group panel-main" data-toggle="accordion"  id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
            </div>
        </div>
        <div style="float:left; width:250px; height:620px; margin-bottom:0px; overflow:auto; margin-top:26px; margin-left:0px; border-right:1px #c3ced5 solid; border-bottom:1px #c3ced5 solid;border-left:1px #c3ced5 solid;position: absolute;">
            <ul id="view-manager-atricle-tree" class="ztree" data-toggle="ztree" data-options="{nodes:'returnTreeJSON', expandAll: false ,onClick:'showVis'}">
            </ul>

        </div>
    </div>
    <div style="margin-left:255px; height:100%;border:1px #c3ced5 solid;"  id="article-manager-view-list"  ></div>
    <%--<c:if test="${columnTreeId !=null}">--%>
        <%--<div style="margin-left:255px; height:100%;border:1px #c3ced5 solid;"  id="user-manager-user-list" data-toggle="autoajaxload"  data-url="<%=basePath%>vis/vis-ref.do?columnTreeId=${columnTreeId}" >--%>
            <%--<h1>${columnTreeId}</h1>--%>
        <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${columnTreeId ==null}">--%>
        <%--<div style="margin-left:255px; height:100%;border:1px #c3ced5 solid;"  id="user-manager-user-list" data-toggle="autoajaxload"  >--%>
                <%--<h1>${columnTreeId}</h1>--%>
        <%--</div>--%>
    <%--</c:if>--%>

</div>
<script type="text/javascript">


    function showVis(event, treeId, treeNode){
         if (treeNode.isParent) {
            var zTree = $.fn.zTree.getZTreeObj(treeId);
            zTree.expandNode(treeNode);
             return;
         };
        //取得当前navtab的内容容器
        $.CurrentNavtab.bjuiajax('doLoad', {url:'<%=basePath%>vis/vis-list.do', target:'#article-manager-view-list',data:'columnId='+treeNode.id});
        event.preventDefault();

    }

    function returnTreeJSON() {
        var jsont=null;
        $.ajax({
            url:'<%=basePath%>vis/vis-tree.do',
            type:'get',
            async:false,
            cache:false,
            dataType:'json',
            success:function(json){
                jsont = json;
                console.log(jsont.length)
            }
        });
        console.log(jsont);

        return jsont;
    }


</script>