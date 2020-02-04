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
            url : '<%=basePath%>sysuser/fileupload.do',
            //swf文件，当需要使用swf方式进行上传时需要配置该参数
            flash_swf_url : '../js/Moxie.swf',
            //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            silverlight_xap_url : '../js/Moxie.xap',
            //是否可以在文件浏览对话框中选择多个文件
            multi_selection:true,
            filters : {
                mime_types : [ //只允许上传图片
                    { title : "Image files", extensions : "jpg,gif,png,jpge,bmp" }
//                    { title : "video files", extensions : "mp4" }
                ],
                max_file_size : '50mb', //最大只能上传50mb的文件
                prevent_duplicates : false //不允许选取重复文件
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
//                    console.log(JSON.parse(response.response).AttachEntity)
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
    <form action="<%=basePath%>sysuser/user-save-tz.do" method="post" data-toggle="validate" data-reloadNavtab="false">

        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>特种人员添加</h3></td>
            </tr>

            <tr>
                <td>
                    <input type="hidden" name="rowId"  value="${model.rowId}" >
                    <label class="control-label x90" >人员：</label>
                    <input type="text" name="userName"  readonly="readonly" value="${model.userName}" data-toggle="lookup" data-url="<%=basePath %>sysuser/lookup-user-list.do"  size="25" data-title="请选择人员名称:" >
                </td>
            </tr>

            <tr>
                <td>
                    <input type="hidden" name="sxpzBdId"  value="${sxpzRecord.sxpzBdId}" >
                    <label class="control-label x90" >标段名称：</label>
                    <input type="text" name="sxpzName"  readonly="readonly" value="${sxpzRecord.sxpzName}"  size="25"  >
                </td>
            </tr>
            <tr>
                <td>
                    <label  class="control-label x90" >文件名称：</label>
                    <input id="upload-file-list" readonly="readonly"/>
                    <button id="pickfiles" class="btn-default " data-icon="hand-pointer-o">浏览</button>
                    <button id="uploadfiles" class="btn-blue" data-icon="upload" >上传</button>
                    <button type="button" class="btn-red" data-url="<%=basePath%>hiddenDanger/delete.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids"  data-callback="callback">删除选中文件</button>
                    <button type="button" class="btn-blue" data-url="<%=basePath%>vis/fileDownload.do" data-toggle="doexportchecked" data-confirm-msg="确定要下载吗？" data-icon="download" data-idname="delids" data-group="ids">下载选中文件</button>
                </td>
            </tr>
            </tr>
            </tbody>
        </table>
        <table id="tabelRe" class="table table-bordered table-hover table-striped table-top" >
            <tbody id="tbBody">
            <tr>
                <td width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></td>
                <td align="center" width="30%">文件名称</td>
                <td align="center" width="35%">上传时间</td>
                <td align="center" width="15%">上传人</td>
                <td align="center" width="10%">文件类型</td>
            </tr>
            <c:forEach items="${fileRecordList}" var="fileRecord" varStatus="status">
                <tr id="${fileRecord.rowId}">
                    <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${fileRecord.rowId}"></td>
                    <td align="center">${fileRecord.fileName }</td>
                    <td align="center"> ${fileRecord.uploadTime}</td>
                    <td align="center">${fileRecord.uploadUserName}</td>
                    <td align="center">${fileRecord.fileType}</td>
                </tr>
            </c:forEach>
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