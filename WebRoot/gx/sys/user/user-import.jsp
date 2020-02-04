<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script>
    $(function () {
            var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            //触发文件选择对话框的按钮，为那个元素id
            browse_button : 'pickfiles',
            //服务器端的上传页面地址
            url : '<%=basePath%>sysuser/import.do?i=${i}',
            //swf文件，当需要使用swf方式进行上传时需要配置该参数
            flash_swf_url : '../js/Moxie.swf',
            //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
            silverlight_xap_url : '../js/Moxie.xap',
            //是否可以在文件浏览对话框中选择多个文件
            multi_selection:true,
            filters : {
                mime_types : [ //只允许上传图片
                    { title : "Image files", extensions : "jpg,gif,png,doc,docx,pdf,xlsx,xls" }
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
                        document.getElementById('submit').disabled = true;
                    });
                },
                FileUploaded:function(up,file,response){
//                    var user=JSON.parse(response.response).user
                    var fileUrl=JSON.parse(response.response).fileUrl
                    var flog=JSON.parse(response.response).flog
                    console.log(flog)
                    document.getElementById('submit').disabled=flog
                    document.getElementById('fileUrl').value=fileUrl
                    document.getElementById('type').value=JSON.parse(response.response).type
                    var list=JSON.parse(response.response).list
                    var tbBody=document.getElementById("tbBody")
                    var tr=document.createElement("tr")
//                    tr.setAttribute("id", list[1].userCardId)
                    var text=null
                    console.log(list)
                    console.log(list.length)
                    for(var j=0;j<list.length+1;j++){
                        var tr=document.createElement("tr")
                        for(var i=0;i<5;i++) {
                            var td = document.createElement("td")
                            td.setAttribute("align","center")
                            if(i==0){if(j==0){
                                text = document.createTextNode("姓名");
                            }else {
                                text = document.createTextNode(list[j - 1].userName);
                            }
                            }else if(i==1) {
                                if(j==0){
                                    text = document.createTextNode("登录名");
                                }else {
                                    text = document.createTextNode(list[j-1].userId);
                                }
                            }else if(i==2){
                                if(j==0){
                                    text = document.createTextNode("性别");
                                }else {
                                    text = document.createTextNode(list[j-1].userSex);
                                }
                            }else if(i==3){
                                if(j==0){
                                    text = document.createTextNode("身份证");
                                }else {
                                    text = document.createTextNode(list[j-1].userCardId);
                                }
                            }else if(i==4){
                                if(j==0){
                                    text = document.createTextNode("用户类型");
                                }else {
                                    text = document.createTextNode(list[j-1].userType);
                                }
                            }
                            td.appendChild(text)
                            tr.appendChild(td)
                        }
                        tbBody.appendChild(tr)
                    }

//                  $("#uploadfiles").bjuiajax('refreshlayout', { target:$("#tabelRe")});
//                  $("#uploadfiles").dialog('refresh')
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
    <form action="<%=basePath%>sysuser/import-save.do" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="fileUrl" id="fileUrl">
        <input type="hidden" name="orgId"  value="${orgId}">
        <input type="hidden" name="type" id="type">
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td id="columnArticleTitlePicForm">
                    <table width="70%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="15%"><label  class="control-label x90" style="width: 105px;">文件名称：</label></td>
                            <td>
                                <input id="upload-file-list" size="30" readonly="readonly"/>
                            </td>
                            <td>
                                <button id="pickfiles" class="btn-default " data-icon="hand-pointer-o">浏览</button>
                            </td>
                            <td>
                                <button id="uploadfiles" class="btn-blue" data-icon="upload" >上传</button>
                            </td>
                        </tr>
                    </table>
                    <table id="tabelRe" class="table table-bordered table-hover table-striped table-top" >
                        <tbody id="tbBody">
                        <tr>
                            <%--<td align="center" width="30%">文件名称</td>--%>
                            <%--<td align="center" width="35%">上传时间</td>--%>
                        </tr>
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
        <li><button type="submit" id="submit" class="btn-default" disabled="true">保存</button></li>
    </ul>
</div>