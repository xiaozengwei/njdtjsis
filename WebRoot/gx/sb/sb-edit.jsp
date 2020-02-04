<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>sb/sb-save.do" method="post" data-toggle="validate" data-reloadNavtab="true">
        <input type="hidden" id="rowId" name="rowId" value="${equipmentInfo.rowId}" >
        <input id="form_attachmentId" name="attachmentId" type="hidden" />
        <table class="table table-condensed table-hover">
            <tbody>
                <tr>
                    <td  align="center"><h3>设备编辑</h3></td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">驾驶员：</label>
                        <input type="text" name="driverName"  value="${equipmentInfo.driverName}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">电话：</label>
                        <input type="text" name="telephone"  value="${equipmentInfo.telephone}" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">设备种类：</label>
                        <select id="sbZl" name="sbZl" data-toggle="selectpicker">
                            <option value="盾构机" ${equipmentInfo.sbZl eq '盾构机' ? 'selected="selected"':'' }>盾构机</option>
                            <option value="桩机" ${equipmentInfo.sbZl eq '桩机' ? 'selected="selected"':'' }>桩机</option>
                            <option value="挖掘机" ${equipmentInfo.sbZl eq '挖掘机' ? 'selected="selected"':'' }>挖掘机</option>
                            <option value="起重设备" ${equipmentInfo.sbZl eq '起重设备' ? 'selected="selected"':'' }>起重设备</option>
                            <option value="钢筋制作" ${equipmentInfo.sbZl eq '钢筋制作' ? 'selected="selected"':'' }>钢筋制作</option>
                            <option value="小型机具" ${equipmentInfo.sbZl eq '小型机具' ? 'selected="selected"':'' }>小型机具</option>
                            <option value="场内运输车辆" ${equipmentInfo.sbZl eq '场内运输车辆' ? 'selected="selected"':'' }>场内运输车辆</option>
                            <option value="供电设备" ${equipmentInfo.sbZl eq '供电设备' ? 'selected="selected"':'' }>供电设备</option>
                            <option value="叉车" ${equipmentInfo.sbZl eq '叉车' ? 'selected="selected"':'' }>叉车</option>
                            <option value="其他" ${equipmentInfo.sbZl eq '其他' ? 'selected="selected"':'' }>其他</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90" style="width: 105px;">设备类别：</label>
                        <select id="equipmentType" name="equipmentType" data-toggle="selectpicker" size="30">
                            <option value="自有设备" ${equipmentInfo.equipmentType eq '自有设备' ? 'selected="selected"':'' }>自有设备</option>
                            <option value="租赁设备" ${equipmentInfo.equipmentType eq '租赁设备' ? 'selected="selected"':'' }>租赁设备</option>
                            <option value="协作队伍设备" ${equipmentInfo.equipmentType eq '协作队伍设备' ? 'selected="selected"':'' }>协作队伍设备</option>
                        </select>
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90" style="width: 105px;">设备名称：</label>
                        <input type="text" name="equipmentName"  value="${equipmentInfo.equipmentName}" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                        <label class="control-label x90" style="width: 105px;">型号：</label>
                        <input type="text" name="equipmentModel"  value="${equipmentInfo.equipmentModel}" size="20">
                    </td>
                </tr>
                <tr>
                	<td id="lsDwId">
                		<label class="control-label x90" style="width: 105px;">隶属单位：</label>
                        <input type="text" name="lsDw" value="${equipmentInfo.lsDw}" size="20">
                        <%--<c:choose>
                            <c:when test="${equipmentType == '自有设备'}">
                                <select id="lsDw" name="lsDw" data-toggle="selectpicker">
                                    <option value="自有">自有</option>
                                </select>
                            </c:when>
                            <c:otherwise>
                                <select id="lsDw" name="lsDw" data-toggle="selectpicker">
                                    <c:forEach items="${dicList}" var="dic">
                                        <option value="${dic.dicName}" ${dic.dicName eq equipmentInfo.lsDw ? 'selected="selected"':'' }>${dic.dicName}</option>
                                    </c:forEach>
                                </select>
                            </c:otherwise>
                        </c:choose>--%>
                	</td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">进场时间：</label>
                        <input type="text" name="enterTime" value="${equipmentInfo.enterTime }" size="20" data-toggle="datepicker" data-pattern="yyyy-MM-dd" readonly="readonly">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">管理编号：</label>
                        <input type="text" name="managerNum" value="${equipmentInfo.managerNum }" data-rule="required" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">自定义信息：</label>
                        <input type="text" name="customMessage" value="${equipmentInfo.customMessage }" size="20">
                    </td>
                </tr>
                <tr>
                	<td>
                		<label class="control-label x90" style="width: 105px;">是否报检：</label>
                        <select name="isTest" data-toggle="selectpicker" size="30">
                            <option value="是" ${equipmentInfo.isTest eq '是' ? 'selected="selected"':'' }>是</option>
                            <option value="否" ${equipmentInfo.isTest eq '否' ? 'selected="selected"':'' }>否</option>
                        </select>
                	</td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">工作状态：</label>
                        <select name="workStatus" data-toggle="selectpicker" size="30">
                            <option value="在用" ${equipmentInfo.workStatus eq '在用' ? 'selected="selected"':'' }>在用</option>
                            <option value="未用" ${equipmentInfo.workStatus eq '未用' ? 'selected="selected"':'' }>未用</option>
                            <option value="退场" ${equipmentInfo.workStatus eq '未用' ? 'selected="selected"':'' }>退场</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td id="czzId" align="center">
                        <c:if test="${equipmentInfo.operationLicense != null && equipmentInfo.operationLicense != ''}">
                            <img src="<%=basePath%>fileRecord/fileDownload.do?fileId=${equipmentInfo.operationLicense}" width='300px'>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label x90" style="width: 105px;">附件上传：</label>
                        <input id="upload-file-list" name="upload-file-list" type="text" style="width:150px" readonly="readonly"/>
                        <button id="pickfiles" type="button" class="btn-blue" data-icon="hand-o-up">浏览</button>
                        <button id="uploadfiles" type="button" class="btn-green" data-icon="upload">上传</button>
                        <input id="operationLicense" name="operationLicense" value="${equipmentInfo.operationLicense}" type="hidden" />
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