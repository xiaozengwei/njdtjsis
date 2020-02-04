<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script>
    function callback(json) {
        console.log(json.row_ides)
        var rowId=json.row_ides;
        for(var i=0;i<rowId.length;i++){
            console.log("#"+rowId[i])
            $("#"+rowId[i]).remove();
        }
    }
    $(function () {
        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            //触发文件选择对话框的按钮，为那个元素id
            browse_button : 'pickfiles',
            //服务器端的上传页面地址
            url : '<%=basePath%>weeklyreport/fileupload.do',
            //swf文件，当需要使用swf方式进行上传时需要配置该参数
            flash_swf_url : '../js/Moxie.swf',
            //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            silverlight_xap_url : '../js/Moxie.xap',
            //是否可以在文件浏览对话框中选择多个文件
            multi_selection:false,
            filters : {
                mime_types : [ //只允许上传图片
                    { title : "Image files", extensions : "jpg,gif,png" },
                    { title : "video files", extensions : "mp4" }
                ],
                max_file_size : '50mb', //最大只能上传50mb的文件
                prevent_duplicates : true //不允许选取重复文件
            },
            init: {
                PostInit: function() {
                    document.getElementById('uploadfiles').onclick = function() {
                        uploader.start();
                        return false;
                    };
                },
                FilesAdded:function(up,files){
                    plupload.each(files, function(file) {
                        document.getElementById('upload-file-list').value = file.name ;
                    });
                },
                FileUploaded:function(up,file,response){
                    console.log(JSON.parse(response.response).AttachEntity)
                    var user=JSON.parse(response.response).user
                    var AttachEntity=JSON.parse(response.response).AttachEntity
                    var tbBody=document.getElementById("tbBody")
                    var tr=document.createElement("tr")
                    tr.setAttribute("id", AttachEntity.rowId)
                    var text=null
                    for(var i=0;i<5;i++) {
                        var td = document.createElement("td")
                        td.setAttribute("align","center")
                        if(i==0){
                            td.innerHTML='<input type="checkbox" class="icheckbox_minimal-purple"  style="bottom: 0px;" data-toggle="icheck" name="ids" value='+AttachEntity.rowId+'/>'
                        }
                        else if(i==1) {
                            text = document.createTextNode(file.name);
                        }else if(i==2){
                            text = document.createTextNode(file.lastModifiedDate);
                        }else if(i==3){
                            text = document.createTextNode(user.userName);
                        }else {
                            text = document.createTextNode(file.type);
                        }
                        if(i!=0){
                            td.appendChild(text)
                        }
                        tr.appendChild(td)
                    }
                    tbBody.appendChild(tr);
//                    $("#uploadfiles").bjuiajax('refreshlayout', { target:$("#tabelRe")});
//                    $("#uploadfiles").dialog('refresh')

                },
                Error: function(up, err) {
                    $.CurrentDialog.alertmsg("error", err.message);
                }
            }
        });

        uploader.init();

    })
</script>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>weeklyreport/weeklyreport-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId"  value="${weeklyReport.rowId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">时间周期：</label>
                    <input type="number" name="ext1"  value="${weeklyReport.ext1}" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">开始时间：</label>
                    <input id="startTime" type="text" name="ext2"  value="${weeklyReport.ext2}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly" data-rule="required" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">结束时间：</label>
                    <input id="endTime" type="text" name="ext3"  value="${weeklyReport.ext3}" data-toggle="datepicker" data-pattern="yyyy-MM-dd HH:mm:ss" readonly="readonly" data-rule="required">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">周报：</label>
                    <script id="container" name="thisWeekWork" type="text/plain">
                        ${weeklyReport.thisWeekWork }
                    </script>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">其他事项：</label>
                    <textarea name="briefIntro"  data-toggle="autoheight" data-rule="required">
                        ${weeklyReport.otherWork}
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${weeklyReport.bdId}" >
                    <label class="control-label x90" style="width: 105px;">标段：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${weeklyReport.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td id="columnArticleTitlePicForm">
                    <table width="90%" border="0" cellspacing="0" cellpadding="0">
                        <tr>

                            <td>
                            </td>
                        </tr>
                    </table>
                    <table id="tabelRe" class="table table-bordered table-hover table-striped table-top" >
                        <tbody id="tbBody">
                        <tr>
                            <td width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></td>
                            <td align="center" width="30%">文件名称</td>
                            <td align="center" width="35%">上传时间</td>
                            <td align="center" width="15%">上传人</td>
                            <td align="center" width="10%">操作</td>
                        </tr>
                        <c:forEach items="${fileRecordList}" var="fileRecord" varStatus="status">
                            <tr id="${fileRecord.rowId}">
                                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${fileRecord.rowId}"></td>
                                <td align="center">${fileRecord.fileName }</td>
                                <td align="center">${fileRecord.uploadTime}</td>
                                <td align="center">${fileRecord.uploadUserId}</td>
                                <td align="center">
                                    <button type="button" class="btn-blue" data-url="<%=basePath%>vis/fileDownload.do?delids=${fileRecord.rowId}" data-toggle="doexport" data-confirm-msg="确定要下载吗？" data-icon="download" >下载文件</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </td>
            </tr>


            </tbody>
        </table>
    </form>

</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">关闭</button></li>
    </ul>
</div>
<script type="text/javascript">
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
    ue.render("container");
    ue.ready(function() {
        ue.focus(true);
    });

</script>