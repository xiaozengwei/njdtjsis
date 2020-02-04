<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<style>
    .li-selected {
        background-color: #3399ff;
    }
</style>
<script type="text/javascript">
    function do_open_layout(event, treeId, treeNode) {
        if (treeNode.isParent) {
            var zTree = $.fn.zTree.getZTreeObj(treeId);

            zTree.expandNode(treeNode);
            event.preventDefault();
            return;
        }
        //$(event.target).bjuiajax('doLoad', {url:treeNode.url, target:treeNode.divid,loadingmask:false});

        var org_selected_layout = $.CurrentDialog.find("#layout-org-selected1");
        var layout_orgs = $.CurrentDialog.find("#layout-tree-org1");
        var input_org_id = $.CurrentDialog.find("#orgId");
        var org_id = treeNode.id;
        var org_name = treeNode.name;
        var table_shows_container = org_selected_layout.find("table");
        if (table_shows_container.find("td#" + org_id).length < 1) {
            var td_html = "<tr><td align='center' id='"+org_id+"' name='"+org_name+"'>"
                + org_name + "</td></tr>";
            table_shows_container.html(td_html);
            input_org_id.val(org_id);
        }

        event.preventDefault();

    }
</script>
<div class="bjui-pageContent" style="" id="user-select-page">
    <form action="<%=basePath%>sysuser/user-org-update1.do?userId=${userId}"
          method="post" data-toggle="validate" data-reloadNavtab="false"
          id="user-change-org-form1">
        <input type="hidden" name="orgId" value="" id="orgId" />
        <div style="width:99%;height: 99%;">
            <div style=" float:left;width:290px;height:99%;">
                <fieldset style="height:100%;">
                    <legend>组织机构</legend>
                    <div id="orgtree1" style="height:94%;width:290px;overflow: auto; ">
                        <ul id="layout-tree-org1" class="ztree" data-toggle="ztree"
                            data-expand-all="true" data-on-click="do_open_layout">
                            <c:forEach items="${orgList}" var="org" varStatus="status">
                                <li data-id="${org.rowId}" data-pid="${org.parentOrgId}"
                                    data-org='{"id":"${org.rowId}", "name":"${org.orgName}"}'>${org.orgName}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </fieldset>
            </div>
            <div style="float:left;margin-left:10px; height:99%; width:290px;">
                <div style="height:100%;">
                    <fieldset style="height:100%;">
                        <legend>已选单位</legend>
                        <div id="layout-org-selected1" style="height:94%; overflow: auto;">
                            <table data-width="100%" class="table table-bordered">

                            </table>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button>
        </li>
        <li><button class="btn-blue" id="btn-org-select" type="button"
                    style="margin-right:8px" data-url="" data-icon="check">保存</button></li>
    </ul>
</div>

<script>
    $(function() {

        var input_org_id = $.CurrentDialog.find("#orgId");

        //确定按钮
        $("#btn-org-select", $.CurrentDialog).on("click", function() {
            var btn_current = $(this);
            var org_id = input_org_id.val() || "";
            if (org_id.length < 1) {
                btn_current.alertmsg('info', '请选择单位');
                return false;
            }
            $.CurrentDialog.find("#user-change-org-form1").submit();

        });
    });
</script>