<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long random = new Date().getTime();
%>
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>wl/wl-list.do?materialType=${materialType}" method="post">
		<input type="hidden" name="pageSize" value="${page.pageSize}">
		<input type="hidden" name="pageCurrent" value="${page.pageCurrent}">
		<input type="hidden" name="orderField" value="${param.orderField}">
		<input type="hidden" name="orderDirection" value="${param.orderDirection}">
		<div class="bjui-searchBar" style="line-height:40px">
			<label>物料名称：</label><input type="text" value="${param.filter_LIKES_materialName}" name="filter_LIKES_materialName" class="form-control">&nbsp;
			<label>批号：</label><input type="text" value="${param.filter_LIKES_batchNumber}" name="filter_LIKES_batchNumber" class="form-control">&nbsp;
			<button type="submit" class="btn-default" data-icon="search">查询</button>
			&nbsp;
			<button type="button" class="btn-green" data-url="<%=basePath%>wl/export.do" data-toggle="doexport" data-confirm-msg="确定要导出吗？" data-idname="delids" data-group="ids">导出</button>
			&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			&nbsp;
			<button type="button" class="btn-green" data-url="<%=basePath%>wl/wl-input.do?materialType=${materialType}" data-toggle="dialog" data-target="sb-input" data-id="sb-input-dialog" data-icon="plus" data-width="500" data-height="500">添加物料</button>
			&nbsp;
			<button type="button" class="btn-blue" data-url="<%=basePath%>wl/remove.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中行</button>

		</div>
	</form>
</div>
<div class="bjui-pageContent">
	<table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
		<thead>
			<tr>
				<th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
				<th width="5%" align="center">序号</th>
				<th width="10%" align="center">物料名称</th>
				<th width="10%" align="center" >型号规格</th>
				<th width="20%" align="center">生产厂家</th>
				<th width="10%" align="center" >进场数量</th>
				<th width="10%" align="center" >批号</th>
				<th width="10%" align="center">进场时间</th>
				<th width="15%" align="center">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.result}" var="wl" varStatus="status">
				<tr data-id="${wl.rowId}">
					<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${wl.rowId}"></td>
					<td align="center">${status.count }</td>
					<td align="center">${wl.materialName}</td>
					<td align="center">${wl.materialModel}</td>
					<td align="center">${wl.manufacturer}</td>
					<td align="center">${wl.enterNumber}</td>
					<td align="center">${wl.batchNumber}</td>
					<td align="center">
						<fmt:formatDate value='${wl.enterTime  }' pattern='yyyy-MM-dd' />
					</td>
					<td align="center">
						<a class="btn btn-blue" href="<%=basePath%>wl/wl-input.do?rowId=${wl.rowId}" data-toggle="dialog" data-id="sb-update" data-width="500" data-height="500" data-title="编辑">编辑</a>
						<a class="btn btn-default" href="<%=basePath%>wl/wl-detail.do?rowId=${wl.rowId}" data-toggle="dialog" data-id="sb-detail" data-width="500" data-height="500" data-title="查看详情">查看详情</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="bjui-pageFooter">
	<div class="pages">
		<span>每页&nbsp;</span>
		<div class="selectPagesize">
			<select data-toggle="selectpicker" data-toggle-change="changepagesize">
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="25">25</option>
			</select>
		</div>
		<span>&nbsp;条，共 ${page.totalCount }条</span>
	</div>
	<div class="pagination-box" data-toggle="pagination"
		data-total="${page.totalCount }" data-page-size="${page.pageSize }"
		data-page-current="${page.pageCurrent }"></div>
</div>
<script  type="text/javascript">
    $(function(){
        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            browse_button : 'pickfilespk_<%=random %>', // you can pass in id...
            //container: document.getElementById('container'), // ... or DOM Element itself
            url : '<%=basePath%>wl/import.do',
            flash_swf_url : '../js/Moxie.swf',
            silverlight_xap_url : '../js/Moxie.xap',
            multi_selection:false,
            filters : {
                max_file_size : '50000mb'
            },

            init: {
                PostInit: function() {
                    document.getElementById('uploadfiles_<%=random %>').onclick = function() {
                        uploader.start();
                        return false;
                    };
                },
                FilesAdded:function(up,files){
                    plupload.each(files, function(file) {
                        document.getElementById('upload-file-list_<%=random %>').value = file.name ;
                    });
                },
                FileUploaded:function(up,file,response){
                    var json = response.response;
                    upload_callback(JSON.parse(json));
                },
                Error: function(up, err) {
                    $.CurrentDialog.alertmsg("error", err.message);
                }
            }
        });

        uploader.init();
        /**
         * 上传文件回调函数
         */
        function upload_callback(json) {
            var msg_type = 'ok';
            if (json.statusCode == BJUI.statusCode.ok) {//上传成功状态

            } else {//如果状态码为300或其他，均为错误的状态
                msg_type = 'error';
            }
            $(this).alertmsg(msg_type, json.message);
        }
    })
</script>
