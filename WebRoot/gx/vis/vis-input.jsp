<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script>
//    function callback(json) {
//        console.log(json.lastRowId)
//        var tbBody=document.getElementById("tbBody")
//        var list=json.lastRowId
//        for(var i=0;i<list.length;i++){
//            tbBody.removeChild(document.getElementById(list[i]))
//        }
//    }
    $(function () {
        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            //触发文件选择对话框的按钮，为那个元素id
            browse_button : 'pickfiles',
            //服务器端的上传页面地址
            url : '<%=basePath%>vis/fileupload.do?columnId=${columnId}',
            //swf文件，当需要使用swf方式进行上传时需要配置该参数
            flash_swf_url : '../js/Moxie.swf',
            //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            silverlight_xap_url : '../js/Moxie.xap',
            //是否可以在文件浏览对话框中选择多个文件
            multi_selection:false,
            filters : {
                mime_types : [ //只允许上传图片
                    { title : "video files", extensions : "mp4" }
                ],
                max_file_size : '100mb', //最大只能上传50mb的文件
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
                    tr.setAttribute("data-id", AttachEntity.rowId)
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
    <form action="<%=basePath%>vis/vis-save.do?columnId=${columnId}" method="post" data-toggle="validate" data-reloadNavtab="false">
        <%--<input type="hidden" name="rowId"  value="${vViewColumnArticle.rowId}" >--%>
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>添加文章</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">标题：</label>
                    <input type="text" name="articleTitle"  value="${gxViewColumnArticle.articleTitle}" data-rule="required" size="20">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">排序：</label>
                    <input type="number" name="orderNum"  value="${gxViewColumnArticle.orderNum}" data-rule="required" size="20" placeholder="只能输入数字">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="bdId"  value="${gxViewColumnArticle.bdId}" >
                    <label class="control-label x90">标段名称：</label>
                    <input type="text" name="bdName"  readonly="readonly" value="${gxViewColumnArticle.bdName}" data-toggle="lookup" data-url="<%=basePath %>risk/lookup-risk-bdId-list.do"  size="20" data-title="请选择标段名称:" >
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">是否为新闻图片：</label>
                    <input type="checkbox" id="isNewsPic" name="isNewsPic" value="1" data-toggle="icheck" data-label="是否为图片新闻" ${gxViewColumnArticle.isNewsPic eq '1' ? 'checked="checked"':'' }>
                </td>
            </tr>
            <tr>
                <td id="columnArticleTitlePicForm">
                    <table width="90%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="15%"><label  class="control-label x90">文件名称：</label></td>
                            <td>
                                <input id="upload-file-list" size="30" readonly="readonly"/>
                                <button id="pickfiles" class="btn-default " data-icon="hand-pointer-o">浏览</button>
                            </td>
                            <td>
                                <button id="uploadfiles" class="btn-blue" data-icon="upload" >上传</button>
                            </td>
                            <td>
                                <button type="button" class="btn-red" data-url="<%=basePath%>vis/delete.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids" >删除选中文件</button>
                            </td>
                            <td>
                                <button type="button" class="btn-blue" data-url="<%=basePath%>vis/fileDownload.do" data-toggle="doexportchecked" data-confirm-msg="确定要下载吗？" data-icon="download" data-idname="delids" data-group="ids">下载选中文件</button>
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
                        <%--<c:forEach items="${fileRecordList}" var="fileRecord" varStatus="status">--%>
                            <%--<tr data-id="${fileRecord.rowId}">--%>
                                <%--<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${fileRecord.rowId}"></td>--%>
                                <%--<td align="center">${fileRecord.fileName }</td>--%>
                                <%--<td align="center">${fileRecord.uploadTime}</td>--%>
                                <%--<td align="center">${fileRecord.uploadUserName}</td>--%>
                                <%--<td align="center">${fileRecord.fileType}</td>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                        </tbody>

                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <script id="container" name="articleContent" type="text/plain">
                        ${gxViewColumnArticle.articleContent }
                    </script>
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