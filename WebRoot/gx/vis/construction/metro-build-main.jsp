<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport"  content="width=device-width,minimum-scale=1.0, maximum-scale=2.0; charset=UTF-8">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head id="Head1" runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>南京地铁</title>
    <!-- head 中 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>
<body>


<c:forEach items="${articleList1}" var="zhnews" begin="0" end="8">
    <div class="weui-cells">
        <a class="weui-cell weui-cell_access" href="<%=request.getContextPath()%>/text/show.do?rowId=${zhnews.articleId}&columnId=${zhnews.columnId}&tag=build" class="font12" target="_blank">
            <div class="weui-cell__bd">
                <p>
                    <c:if test='${fn:length(zhnews.articleTitle)>18}'> ${fn:substring(zhnews.articleTitle,0,18)}... </c:if>
                    <c:if test='${fn:length(zhnews.articleTitle)<=18}'>${zhnews.articleTitle}</c:if>
                    (<fmt:formatDate value="${zhnews.publishTime}" pattern="MM-dd"/>)
                    <img src="<%=request.getContextPath()%>/dtweb/images/new.gif" ${zhnews.articleStatus eq "1"? '':'style="display:none"'}/>
                </p>
            </div>
            <div class="weui-cell__ft">
            </div>
        </a>

    </div>
</c:forEach>


<!-- body 最后 -->
<%--<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>--%>
<%--<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>--%>

<%--<!-- 如果使用了某些拓展插件还需要额外的JS -->--%>
<%--<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/swiper.min.js"></script>--%>
<%--<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/city-picker.min.js"></script>--%>
</body>
</html>
