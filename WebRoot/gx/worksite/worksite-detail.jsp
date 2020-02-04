<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script>


    <%--function addLine() {--%>
<%--//            alert($('#tbody').children('tr')[0].children('td')[2].text());--%>
            <%--$("#tbody").append("<tr>" +--%>
                <%--"<td><input type='checkbox' name='ids' data-toggle='icheck' value=''></td>"+--%>
            <%--"<td align='center'>"+($('#tbody').children('tr').length+1)+"</td> " +--%>
            <%--"<td><input type='text' data-toggle='datepicker' data-pattern='yyyy-MM-dd' readonly='readonly' data-rule='required'size='10%'></td> " +--%>
            <%--"<td>"+$($($('#tbody').children('tr')[0]).children('td')[3]).text()+"</td> " +--%>
            <%--"<td>"+$($($('#tbody').children('tr')[0]).children('td')[4]).text()+"</td> " +--%>
            <%--"<td><button id="+"pickfiles"+($('#tbody').children('tr').length+1)+" class='btn-default' data-icon='hand-pointer-o'>浏览</button>&nbsp; " +--%>
                <%--"<label >文件名称：</label>&nbsp; " +--%>
                <%--"<input  id="+"upload-file-list"+($('#tbody').children('tr').length+1)+" size='15' readonly='readonly'/> " +--%>
                <%--"<button id="+"uploadfiles"+($('#tbody').children('tr').length+1)+" class='btn-blue'  data-icon='upload' >上传</button>&nbsp;</td> " +--%>
            <%--"</tr>")--%>

            <%--var pickfile='pickfiles'+$('#tbody').children('tr').length;--%>
            <%--var uploadfile="uploadfiles"+$('#tbody').children('tr').length;--%>
<%--//            alert(uploadfile);--%>
            <%--var uploadfilelist="upload-file-list"+$('#tbody').children('tr').length;--%>
            <%--var uploader1 = new plupload.Uploader({--%>
                <%--runtimes: 'html5,flash,silverlight,html4',--%>
                <%--//触发文件选择对话框的按钮，为那个元素id--%>
                <%--browse_button: pickfile,--%>
                <%--//服务器端的上传页面地址--%>
                <%--url: '<%=basePath%>hiddenDanger/fileupload.do',--%>
                <%--//swf文件，当需要使用swf方式进行上传时需要配置该参数--%>
                <%--flash_swf_url: '../js/Moxie.swf',--%>
                <%--//silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数--%>
                <%--silverlight_xap_url: '../js/Moxie.xap',--%>
                <%--//是否可以在文件浏览对话框中选择多个文件--%>
                <%--multi_selection: true,--%>
                <%--filters: {--%>
                    <%--mime_types: [ //只允许上传图片--%>
                        <%--{title: "Image files", extensions: "jpg,gif,png,pdf,docx,wps,doc"}--%>
<%--//                    { title : "video files", extensions : "mp4" }--%>
                    <%--],--%>
                    <%--max_file_size: '50mb', //最大只能上传50mb的文件--%>
                    <%--prevent_duplicates: false //不允许选取重复文件--%>
                <%--},--%>
                <%--init: {--%>
                    <%--PostInit: function () {--%>
                        <%--document.getElementById(uploadfile).onclick = function () {--%>
                            <%--uploader1.start();--%>
                            <%--return false;--%>
                        <%--};--%>
                    <%--},--%>
                    <%--FilesAdded: function (up, files) {--%>
                        <%--plupload.each(files, function (file) {--%>
                            <%--document.getElementById(uploadfilelist).value = file.name;--%>
                        <%--});--%>
                    <%--},--%>
                    <%--FileUploaded: function (up, file, response) {--%>
                        <%--$(".uploadfiles").dialog('refresh')--%>
                    <%--},--%>
                    <%--Error: function (up, err) {--%>
                        <%--$.CurrentDialog.alertmsg("error", err.message);--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>
            <%--uploader1.init();--%>
        <%--}--%>
    $(function () {
//        alert(document.getElementsByTagName('button')[0].innerText)
//        console.log(document.getElementsByTagName('button')[7].innerText);
        var list=document.getElementsByTagName('button');
        var myArray=new Array()
        for(var i=0;i<list.length;i++){
            if(document.getElementsByTagName('button')[i].innerText=="浏览"){
                var uploader = new plupload.Uploader({
                    runtimes : 'html5,flash,silverlight,html4',
                    //触发文件选择对话框的按钮，为那个元素id
                    browse_button :document.getElementsByTagName('button')[i],
                    //服务器端的上传页面地址
                    url : '<%=basePath%>worksite/fileupload.do?worksiteId=${worksiteId}',
                    //swf文件，当需要使用swf方式进行上传时需要配置该参数
                    flash_swf_url : '../js/Moxie.swf',
                    //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
                    silverlight_xap_url : '../js/Moxie.xap',
                    //是否可以在文件浏览对话框中选择多个文件
                    multi_selection:true,
                    filters : {
                        mime_types : [ //只允许上传图片
                            { title : "Image files", extensions : "jpg,gif,png,pdf,doc,docx,wps" },
//                            { title : "video files", extensions : "mp4" }
                        ],
                        max_file_size : '50mb', //最大只能上传50mb的文件
                        prevent_duplicates : false //不允许选取重复文件
                    },
                    init: {
                        PostInit: function(uploader) {
                            for(var n=0;n<myArray.length;n++){
                                if(myArray[n]==uploader){
                                    document.getElementsByClassName('uploadfiles')[n].onclick = function() {
                                        uploader.start();
                                        return false;
                                    };
                                }
                            }

                        },
                        FilesAdded:function(up,files){
                            plupload.each(files, function(file) {
                                for(var n=0;n<myArray.length;n++){
                                    if(myArray[n]==up){
                                        document.getElementsByClassName('upload-file-list')[n].value = file.name ;
                                    }
                                }

                            });
                        },
                        FileUploaded:function(up,file,response){
                            $(".uploadfiles").dialog('refresh')

                        },
                        Error: function(up, err) {
                            $.CurrentDialog.alertmsg("error", err.message);
                        }
                    }
                });
                uploader.init();
                myArray.push(uploader);
//                count=count+1;
            }
        }


    })
</script>
<div class="bjui-pageHeader">
    <%--<button   class="btn-blue" onclick="addLine()" >添加</button>--%>
    <%--<button type="button" class="btn-default">保存</button>--%>
    <%--<button type="button" class="btn-red" data-url="<%=basePath%>worksite/remove" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids">删除选中工点</button>--%>
<%--<form id="pagerForm" data-toggle="ajaxsearch" action="<%=basePath%>worksite/worksite-detail.do" method="post">--%>
        <%--<input type="hidden" name="pageSize" value="${page.pageSize}">--%>
        <%--<input type="hidden" name="pageCurrent" value="${page.pageCurrent}">--%>
        <%--<input type="hidden" name="orderField" value="${param.orderField}">--%>
        <%--<input type="hidden" name="orderDirection" value="${param.orderDirection}">--%>
        <%--<div class="bjui-searchBar" style="line-height:40px">--%>
        <%--</div>--%>
    <%--</form>--%>
</div>
<div class="bjui-pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true" id="myTable">
        <thead>
        <tr>
            <th width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
            <th width="5%" align="center" title="序号">序号</th>
            <th width="10%" align="center" title="时间">时间</th>
            <th width="15%" align="center" title="工点名称">工点名称</th>
            <th width="15%" align="center" title="工点简介">工点简介</th>
            <th width="40%" align="center" title="操作">操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <c:forEach items="${page.result}" var="worksite" varStatus="status">
            <tr data-id="${worksite.rowId}">
                <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${worksite.rowId}"></td>
                <td align="center">${status.count }</td>
                <td align="center"><fmt:formatDate value="${time}" pattern="yyyy-MM-dd" /></td>
                <td align="center">${worksite.worksitName}</td>
                <td align="center">${worksite.bdIntro}</td>
                <td align="center">
                    <button class="btn-default" data-icon="hand-pointer-o">浏览</button>&nbsp;
                    <label >文件名称：</label>&nbsp;
                    <input  class="upload-file-list" size="15" readonly="readonly"/>
                    <button  class="uploadfiles btn-blue"  data-icon="upload" >上传</button>&nbsp;
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>

    <table id="tabelRe" class="table table-bordered table-hover table-striped table-top" >
        <tbody id="tbBody">
        <tr>
            <%--<td width="5%" align="center"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></td>--%>
            <td align="center" width="10%">文件名称</td>
            <td align="center" width="10%">上传时间</td>
            <%--<td align="center" width="15%">上传人</td>--%>
            <%--<td align="center" width="10%">文件类型</td>--%>
            <%--<td align="center" width="10%">文件类型</td>--%>
            <td align="center" width="35%">操作</td>
        </tr>
        <c:forEach items="${fileRecordList}" var="fileRecord" varStatus="status">
            <tr data-id="${fileRecord.rowId}">
                <%--<td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${fileRecord.rowId}"></td>--%>
                <td align="center">${fileRecord.fileName }</td>
                <td align="center">
                    <fmt:formatDate value="${fileRecord.uploadTime}" pattern="yyyy-MM-dd" />
                </td>
                <td align="center">
                    <button type="button" class="btn-red" data-url="<%=basePath%>vis/delete.do?delids=${fileRecord.rowId}" data-toggle="doajax" data-confirm-msg="确定要删除吗？" data-icon="remove"  >删除文件</button>&nbsp;
                    <button type="button" class="btn-blue" data-url="<%=basePath%>vis/fileDownload.do?delids=${fileRecord.rowId}" data-toggle="doexport" data-confirm-msg="确定要下载吗？" data-icon="download">下载文件</button>
                </td>
                <%--<td align="center">${fileRecord.uploadUserName}</td>--%>
                <%--<td align="center">${fileRecord.fileType}</td>--%>
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