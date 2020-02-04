<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script>
    function show( url) {
        console.log(url);
        window.open("<%=request.getContextPath()%>/gx/vis/main/vis-show.jsp?url="+url)
    }
</script>

<base href="<%=basePath %>">
<div class="bjui-pageContent">
    <form action="<%=basePath%>vis/vis-save.do?columnId=${columnId}" method="post" data-toggle="validate" data-reloadNavtab="false">
        <input type="hidden" name="rowId"  value="${columnId}" >
        <table class="table table-condensed table-hover">
            <tbody>
            <tr>
                <td  align="center"><h3>添加文章</h3></td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">标题：</label>
                    <input type="text" name="articleTitle"  value="${gxViewColumnArticle.articleTitle}" data-rule="required" size="20" readonly="readonly">
                </td>
            </tr>
            <tr>
                <td>
                    <label class="control-label x90" style="width: 105px;">排序：</label>
                    <input type="number" name="orderNum"  value="${gxViewColumnArticle.orderNum}" data-rule="required" size="20" placeholder="只能输入数字" readonly="readonly">
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
                    <input disabled="disabled" type="checkbox" id="isNewsPic" name="isNewsPic" value="1" data-toggle="icheck" data-label="是否为图片新闻" ${gxViewColumnArticle.isNewsPic eq '1' ? 'checked="checked"':'' } >
                </td>
            </tr>
            <tr>
                <td>
                    <script id="container" name="articleContent" type="text/plain" value=" ${gxViewColumnArticle.articleContent }">
                        ${gxViewColumnArticle.articleContent }
                    </script>
                </td>
            </tr>


            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label class="control-label x90" style="width: 105px;">前往手机端：</label>--%>
                    <%--<img src="<%=basePath%>text/QR-code-show.do">--%>
                <%--</td>--%>
            <%--</tr>--%>
            </tbody>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<label  class="control-label x90" style="width: 105px;">文件名称：</label>--%>
                    <%--<input id="upload-file-list" readonly="readonly"/>--%>
                    <%--<button id="pickfiles" class="btn-default " data-icon="hand-pointer-o">浏览</button>--%>
                    <%--<button id="uploadfiles" class="btn-blue" data-icon="upload" >上传</button>--%>
                    <%--<button type="button" class="btn-red" data-url="<%=basePath%>vis/delete.do" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-icon="remove" data-idname="delids" data-group="ids"  data-callback="callback">删除选中文件</button>--%>
                    <%--<button type="button" class="btn-blue" data-url="<%=basePath%>vis/fileDownload.do" data-toggle="doexportchecked" data-confirm-msg="确定要下载吗？" data-icon="download" data-idname="delids" data-group="ids">下载选中文件</button>--%>
                <%--</td>--%>
            <%--</tr>--%>

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
                <tr data-id="${fileRecord.rowId}">
                    <td align="center"><input type="checkbox" name="ids" data-toggle="icheck" value="${fileRecord.rowId}"></td>
                    <td align="center" onclick="show('<%=basePath%>/vis/fileDownload.do?delids=${fileRecord.rowId}')" >${fileRecord.fileName }</td>
                    <td align="center">${fileRecord.uploadTime}</td>
                    <td align="center">${fileRecord.uploadUserId}</td>
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
        ue.setDisabled();
    });

</script>