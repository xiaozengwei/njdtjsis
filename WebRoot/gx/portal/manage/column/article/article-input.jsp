<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	long random = new Date().getTime();
%>
<div class="bjui-pageContent">
	<input name="maxUploadIndex" id="maxUploadIndex" value="${fn:length(atachementList) }" type="hidden"/>
	<table width="100%">
		<tr>
			<td>
				<form method="post" id="form-article-input"
					action="<%=basePath%>portal/manager/column/article/save.do"
					data-toggle="validate" data-reloadNavtab="false">
					<input name="attachmentIds" type="hidden" id="attachmentIds" value="${attachementIds }"/>
					<input name="picFileName" type="hidden" id="picFileName" value="${model.picFileName }"/>
					
					<input name="columnId" type="hidden"  value="${columnId }"/>
					<input name="rowId" type="hidden" value="${model.rowId }" />
					<table width="100%">
						<tbody>
							<tr>
								<td><label for="j_custom_total" class="control-label x85">标题：</label>
									<textarea name="articleTitle" id="j_custom_name"
										data-rule="required;length[~150]" cols="65" rows="1"
										data-toggle="autoheight">${model.articleTitle }</textarea></td>
							</tr>
							<tr>
								<td><label for="j_custom_total" class="control-label x85">排序：</label>

									<input type="text" name="orderNum" data-rule="number"
									value="${model.orderNum }">
								</td>
							</tr>
							<tr>
								<td style="padding-left: 30px;">
									<input type="checkbox" id="isNewsPic" name="isNewsPic" value="1" data-toggle="icheck" data-label="是否为图片新闻" ${model.isNewsPic eq '1' ? 'checked="checked"':'' }>
								</td>
							</tr>
							<tr>
								<td id="columnArticleTitlePicForm">
										<table width="90%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="15%"><label for="j_custom_total" class="control-label x85">标题图片：</label></td>
												<td width="45%"><input id="upload-file-list_<%=random%>-news" size="20" name="picFileRealName"
													readonly="readonly" value="${model.picFileRealName }"/>
													<button id="pickfiles_<%=random%>-news" class="btn-default "
														data-icon="hand-pointer-o">浏览</button>
												</td>
												<td width="40%"> 
													<button id="uploadfiles_<%=random%>-news" class="btn-blue"
														data-icon="upload">上传</button></td>
											</tr>
														
										</table>
									</td>
							</tr>
							<tr>
								<td><label for="j_custom_content" class="control-label x85"
									style="margin-top: 0px;">内容编辑：</label>
								</td>
							</tr>
							<tr>
								<td align="center">
									<div
										style="vertical-align: middle;width: 920px;overflow: hidden;">
										<textarea name="articleContent" id="column-article-input">${model.articleContent }
                            			</textarea>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</form></td>
		</tr>
		
		<tr>
			<td>
				<div style="width:90%;margin:0px auto">
					<fieldset>
						<legend>附件</legend>
						<form action="" id="columnArticleAttachForm">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><table>
											<tr>
												<td><input id="upload-file-list_<%=random%>" size="30"
													readonly="readonly" />
													<button id="pickfiles_<%=random%>" class="btn-default "
														data-icon="hand-pointer-o">浏览</button>
												</td>
												<td>
													<button id="uploadfiles_<%=random%>" class="btn-blue"
														data-icon="upload">上传</button></td>
											</tr>
										</table></td>
								</tr>
							</table>
							<table class="upload_file_list_location table table-bordered table-hover table-striped table-top">
								<tbody>
									<tr>
										<td align="center" width="10%">序号</td>
										<td align="center" width="50">文件名称</td>
										<td align="center" width="15%">上传时间</td>
										<td align="center" width="15%">上传人</td>
										<td align="center" width="10%">操作</td>
									</tr>
									<c:forEach items="${atachementList}" varStatus="status"  var="noticeAttachment">
									<tr class='attachment'>
										<td align="center">${status.count }</td>
										<td><a
											href="<%=basePath %>fileupload/notice-file-download.do?fileId=${noticeAttachment.gxOaNoticeAttachmentId }"><i class='fa fa-download fa-1x'></i>${noticeAttachment.attachFileName }</a>
										</td>
										<td align="center"><fmt:formatDate value="${noticeAttachment.createTime }" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
										<td align="center">${noticeAttachment.creatorName }</td>
										<td align="center"><button type="button" class="btn_notice_file_delete  btn-red btn"
												file-id="${noticeAttachment.gxOaNoticeAttachmentId }">删除</button>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
					</fieldset>
				</div></td>
		</tr>
		
		

	</table>

</div>

<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-close" data-icon="close">取消</button>
		</li>
		<li><button type="button" class="btn-default" data-icon="save"
				id="btn-column-article-save">保存</button></li>
	</ul>
</div>
<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->

<script type="text/javascript">
$(function() {
	//保存
	$("#btn-column-article-save",$.CurrentDialog).on("click",function(){
		var $chk_isNewPic = $("#isNewsPic:checked",$.CurrentDialog);
		   if($chk_isNewPic.length >0){
			   var $picFileName = $("#picFileName", $.CurrentDialog);
			   if($picFileName.val().length < 1){
				   $chk_isNewPic.alertmsg("warn", "请上传标题图片");
				   return false;
			   }
		   }
		
		$("#form-article-input",$.CurrentDialog).submit();
	});
	var uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'pickfiles_<%=random%>', // you can pass in id...
		//container: document.getElementById('container'), // ... or DOM Element itself
		url : '<%=basePath%>fileupload/notice-attach-upload.do',
		flash_swf_url : '../js/Moxie.swf',
		silverlight_xap_url : '../js/Moxie.xap',
		multi_selection:false,
		filters : {
			max_file_size : '50mb'
		},

		init: {
			PostInit: function() {
				document.getElementById('uploadfiles_<%=random%>').onclick = function() {
					uploader.start();
					return false;
				};
			},
			FilesAdded:function(up,files){
				plupload.each(files, function(file) {
					document.getElementById('upload-file-list_<%=random%>').value = file.name ;
				});
			},
			FileUploaded:function(up,file,response){
				var json = response.response;
				notice_upload_callback(JSON.parse(json));
			},
			Error: function(up, err) {
				$.CurrentDialog.alertmsg("warn", err.message);
			}
		}
	});

	uploader.init();
    var tableFormContainer = $("#columnArticleAttachForm", $.CurrentDialog);
	function resetFilesIndex(){
		var attachment_tr = tableFormContainer.find(".attachment");
		attachment_tr.each(function(i,element){
			var attach_td = $(this).find("td:first");
			attach_td.text(i+1);
		});
	}
   
    tableFormContainer.on("click", "button.btn_notice_file_delete",
    function() {
        var file_id = $(this).attr("file-id");
        var _url = '../fileupload/notice-file-delete.do';
        var _data = {
            fileId: file_id
        };
        var msg_type = 'ok';
        var tr_this = $(this);
        var dialogNoticeAttachment = $("#attachmentIds", $.CurrentDialog);
        var _attachementId = dialogNoticeAttachment.val() || "";
        $.ajax({
            url: _url,
            type: 'post',
            data: _data,
            success: function(json) {
                if (json.statusCode == BJUI.statusCode.ok) {
                	var strs = _attachementId.split(',');
                	var index_str = getIndexOfStrArr(strs,file_id);
                	
                	var lastAttachmentIds = removeAndJoinString(strs,index_str);
                	 dialogNoticeAttachment.val(lastAttachmentIds);
                    tr_this.parents("tr:first").remove();
                    resetFilesIndex();
					var maxUploadIndex = $("#maxUploadIndex",$.CurrentDialog);
					var uploadIndex = maxUploadIndex.val()||"0";
					uploadIndex = parseInt(uploadIndex) -1;
					maxUploadIndex.val(uploadIndex > 0 ? uploadIndex : 0);
                    var list_location_container = $("table.upload_file_list_location", tableFormContainer);
                    if ($("tr", list_location_container).length == 1) {
                        list_location_container.remove();
                    }
                } else {
                    msg_type = 'error';
                }
                tr_this.alertmsg(msg_type, json.message);
            }
        });
    });
    
    
    
    
    
    var uploader_news = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'pickfiles_<%=random%>-news', // you can pass in id...
		//container: document.getElementById('container'), // ... or DOM Element itself
		url : '<%=basePath%>fileupload/news-image/upload.do',
		flash_swf_url : '../js/Moxie.swf',
		silverlight_xap_url : '../js/Moxie.xap',
		multi_selection:false,
		filters : {
			max_file_size : '50mb',
			mime_types: [
			 			{title : "Image files", extensions : "jpg,gif,png,jpeg"}
			]
		},

		init: {
			PostInit: function() {
				document.getElementById('uploadfiles_<%=random%>-news').onclick = function() {
					uploader_news.start();
					return false;
				};
			},
			FilesAdded:function(up,files){
				plupload.each(files, function(file) {
					document.getElementById('upload-file-list_<%=random%>-news').value = file.name ;
				});
			},
			FileUploaded:function(up,file,response){
				var json = response.response;
				notice_upload_news_callback(JSON.parse(json));
			},
			Error: function(up, err) {
				$.CurrentDialog.alertmsg("error", err.message);
			}
		}
	});

    uploader_news.init();
   

   
});

/**
	 * 上传文件回调函数
	 */
function notice_upload_callback(json) {
    var tableFormContainer = $("#columnArticleAttachForm", $.CurrentDialog);
    var maxUploadIndex = $("#maxUploadIndex",$.CurrentDialog);
    var msg_type = 'ok';
    if (json.statusCode == BJUI.statusCode.ok) { //上传成功状态
        var attachmentInstance = json.attachmentInstance;
        var attachementId = attachmentInstance.gxOaNoticeAttachmentId;
        var dialogNoticeAttachment = $("#attachmentIds", $.CurrentDialog);
        var _attachementId = dialogNoticeAttachment.val() || "";
        _attachementId = _attachementId.length > 0 ? _attachementId + ",": "";
        dialogNoticeAttachment.val(_attachementId + attachementId);
        var d = new Date();
		d.setTime( attachmentInstance.createTime);
        var uploadTime =d.format("yyyy-MM-dd hh:mm") ;
        var upload_file_list_html = "";
        var uploadIndex = maxUploadIndex.val()||"0";
		uploadIndex = parseInt(uploadIndex) +1;
		maxUploadIndex.val(uploadIndex);
        var upload_file_html = "<tr class='attachment'><td align='center'>"+uploadIndex+"</td><td><a href='../fileupload/notice-file-download.do?fileId=" + attachementId + "' title='点击下载附件'><i class='fa fa-download fa-1x'></i>" + attachmentInstance.attachFileName + "</a></td><td align='center'>" + uploadTime + "</td><td align='center'>" + attachmentInstance.creatorName + "</td><td align='center'><button type='button' class='btn_notice_file_delete  btn-red btn' file-id='" + attachementId + "'>删除</button></td></tr>";

        var list_location_container = $("table.upload_file_list_location", tableFormContainer);
        if (list_location_container.length < 1) { //若附件个数为0，则新建表头
            upload_file_list_html = "<table class='upload_file_list_location table table-bordered table-hover table-striped table-top'><tr><td align='center' width='10%' >序号</td><td align='center' width='50%'>文件名称</td><td align='center' width='15%'>上传时间</td><td align='center' width='15%'>上传人</td><td align='center' width='10%'>操作</td></tr>";
            upload_file_list_html = upload_file_list_html + upload_file_html + "</table>";
            tableFormContainer.append(upload_file_list_html);
        } else { //之前有表头，则仅添加该行数据
            list_location_container.append(upload_file_html);
        }

    } else { //如果状态码为300或其他，均为错误的状态
        msg_type = 'error';
    }
    var fileupload_input = $("#upload-file-list_<%=random%>",tableFormContainer);
		fileupload_input.val("");
		fileupload_input.alertmsg(msg_type, json.message);
	}
function notice_upload_news_callback(json) {
    var msg_type = 'ok';
    if (json.statusCode == BJUI.statusCode.ok) { //上传成功状态
        var fileName = json.fileName;
        var fileOriginalName = json.fileOriginalName;
        
        var $picFileRealName = $("#upload-file-list_<%=random%>-news", $.CurrentDialog);
        var $picFileName = $("#picFileName", $.CurrentDialog);
        
        $picFileRealName.val(fileOriginalName);
        $picFileName.val(fileName);
        var $chk_isNewPic = $("#isNewsPic",$.CurrentDialog);
        $chk_isNewPic.iCheck('check');;

    } else { //如果状态码为300或其他，均为错误的状态
        msg_type = 'error';
    }
    var picNewsFormContainer = $("#columnArticleTitlePicForm", $.CurrentDialog);
    var fileupload_input = $("#upload-file-list_<%=random%>-news",picNewsFormContainer);
		//fileupload_input.val("");
	fileupload_input.alertmsg(msg_type, json.message);
}

//ueditor -config
	var editorOption = {
		toolbars: [[
   	             'fullscreen',  '|', 'undo', 'redo', '|',
   	             'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
   	             'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
   	             'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
   	             'directionalityltr', 'directionalityrtl', 'indent', '|',
   	             'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
   	             'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
   	             'simpleupload', 'insertimage', 'emotion', 'scrawl',  'insertframe',   'pagebreak', 'template', 'background', '|',
   	             'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
   	             'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
   	              'searchreplace', 'drafts'
   	         ]],
         elementPathEnabled: false,
        charset:"utf-8"
        ,initialFrameWidth:920 //初始化编辑器宽度,默认1000
		 ,initialFrameHeight:500 //初始化编辑器高度,默认320
       
    };
	var ue = new baidu.editor.ui.Editor(editorOption);
	ue.render("column-article-input");
	ue.ready(function() {
		ue.focus(true);
	});
</script>
