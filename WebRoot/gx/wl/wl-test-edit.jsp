<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>wl/wl-test-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" name="rowId" id="rowId" value="${model.rowId}" >
        <input id="form_attachmentId" name="attachmentId" type="hidden" />
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>物料检测添加</h3></td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">报告编号：</label>
                        <input type="text" name="reportNo"  value="${model.reportNo}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">报告日期：</label>
                        <input type="text" name="reportDate" value="${model.reportDate }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly="readonly">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">品种：</label>
                        <input type="text" name="materielType"  value="${model.materielType}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">等级：</label>
                        <input type="text" name="materielLevel"  value="${model.materielLevel}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">规格型号：</label>
                        <input type="text" name="materielModel"  value="${model.materielModel}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">生产厂家：</label>
                        <input type="text" name="manufacturer"  value="${model.manufacturer}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">进场数量：</label>
                        <input type="text" name="enterNumber" value="${model.enterNumber }" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">进场批号：</label>
                        <input type="text" name="enterPh"  value="${model.enterPh}" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">进场时间：</label>
                        <input type="text" name="enterDate" value="${model.enterDate }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly="readonly">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">主要使用部位：</label>
                        <input type="text" name="useSite"  value="${model.useSite}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">取样地点：</label>
                        <input type="text" name="samplePlace"  value="${model.samplePlace}" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90">取样日期：</label>
                        <input type="text" name="sampleDate" value="${model.sampleDate }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly="readonly">
                    </td>
                </tr>

                <tr>
                    <td>
                        <label class="control-label x90">取样人：</label>
                        <input type="text" name="sampleUser" value="${model.sampleUser }" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90">见证人：</label>
                        <input type="text" name="witness" value="${model.witness }" size="20">
                	</td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">备注：</label>
                        <input type="text" name="remark" value="${model.remark }" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90">附件上传：</label>
                        <input id="upload-file-list" name="upload-file-list" type="text" style="width:150px" readonly="readonly"/>
                        <button id="pickfiles" type="button" class="btn-blue" data-icon="hand-o-up">浏览</button>
                        <button id="uploadfiles" type="button" class="btn-green" data-icon="upload">上传</button>
                    </td>
                </tr>
                <tr>
                    <table class="table table-bordered table-hover table-striped table-top" id="attachmentTab">
                        <tr>
                            <th align="center" width="50%">附件名称</th>
                            <th align="center" width="30%">上传时间</th>
                            <th align="center" width="20%">操作</th>
                        </tr>
                        <c:forEach items="${fileList}" var="file">
                            <tr>
                                <td align="center"><a href="<%=path %>/fileRecord/fileDownload.do?fileId=${file.rowId}">${file.fileName}</a></td>
                                <td align="center"><fmt:formatDate value="${file.uploadTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                                <td align="center"><input type='button' class='btn btn-red btn_file_delete' data='${file.rowId}' value='删除' /></td>
                            </tr>
                        </c:forEach>
                    </table>
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

<script  type="text/javascript">
    $(function(){
        var relationId = $("#rowId").val();
        console.log("relationId="+relationId);
        //日期格式化
        Date.prototype.format = function(format){
            var o = {
                "M+" : this.getMonth()+1, //month
                "d+" : this.getDate(), //day
                "H+" : this.getHours(), //hour
                "m+" : this.getMinutes(), //minute
                "s+" : this.getSeconds(), //second
                "q+" : Math.floor((this.getMonth()+3)/3), //quarter
                "S" : this.getMilliseconds() //millisecond
            }

            if(/(y+)/.test(format)) {
                format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            }

            for(var k in o) {
                if(new RegExp("("+ k +")").test(format)) {
                    format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
                }
            }
            return format;
        }

        var uploader = new plupload.Uploader({
            runtimes : 'html5,flash,silverlight,html4',
            browse_button : 'pickfiles', // you can pass in id...
            //container: document.getElementById('container'), // ... or DOM Element itself
            url : '<%=path%>/fileRecord/fileUpload.do?relationId='+relationId,
            flash_swf_url : '<%=path%>/gx/js/Moxie.swf',
            silverlight_xap_url : '<%=path%>/gx/js/Moxie.xap',
            multi_selection:false,
            filters : {
                mime_types : [ //只允许上传图片
                    { title : "Image files", extensions : "jpg,gif,png" }
                ],
                max_file_size : '50mb', //最大只能上传50mb的文件
                prevent_duplicates : true //不允许选取重复文件
            },
            init : {
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
                    var json = response.response;
                    upload_callback(JSON.parse(json));
                },
                Error: function(up, err) {
                    console.log("code："+err.code);
                    console.log("file："+err.file);
                    console.log("message："+err.message);
                    alert(err.message);
                }
            }
        });

        uploader.init();

        /**
         * 上传文件回调函数
         */
        function upload_callback(json) {
            var msg_type = 'ok';
            var message = '';
            if (json.statusCode = '200') {//上传成功状态
                var fileRecord = json.fileRecord;
                message = json.message;
                var attachmentId = fileRecord.rowId;
                var d = new Date();
                d.setTime( fileRecord.uploadTime);
                var uploadTime =d.format("yyyy-MM-dd HH:mm");
                var upload_file_html = "<tr><td align='center' class='blue'><a href='<%=path %>/fileRecord/fileDownload.do?fileId="+attachmentId+"'>"
                    + fileRecord.fileName
                    + "</a></td><td align='center'>"
                    + uploadTime
                    + "</td><td align='center'><input type='button' class='btn btn-red btn_file_delete' data='"+attachmentId+"' value='删除' /></td></tr>";
                var attachmentTab = $("#attachmentTab");
                attachmentTab.append(upload_file_html);
            } else {//如果状态码为300或其他，均为错误的状态
                msg_type = 'error';
            }
            var fileupload_input = $("#upload-file-list");
            fileupload_input.val("");
            attachmentTab.alertmsg(msg_type, message);
        }

        //删除附件
        $("#attachmentTab").on("click",".btn_file_delete",function(){
            var tr_this =  $(this);
            var rowId = tr_this.attr("data");
            var msg_type = 'ok';
            var message = '';
            $.ajax({
                url : '<%=path %>/fileRecord/fileDelete.do',
                type : 'post',
                data : {'fileId':rowId},
                success : function(json) {
                    if (json.statusCode == '200') {
                        message = json.message;
                        //删除此行
                        tr_this.parents("tr:first").remove();
                    }else{
                        msg_type = 'error';
                    }
                }
            });
            tr_this.alertmsg(msg_type, message);
        });
    })
</script>