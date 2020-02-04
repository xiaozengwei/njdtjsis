<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport"  content="width=device-width,minimum-scale=1.0, maximum-scale=2.0; charset=UTF-8">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>南京地铁</title>
</head>
<!-- head 中 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">

<!-- body 最后 -->
<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>

<!-- 如果使用了某些拓展插件还需要额外的JS -->
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/swiper.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/city-picker.min.js"></script>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>">
<body>
<div class="weui-navbar">
    <div class="weui-navbar__item weui_bar__item_on">
        <a href="<%=basePath%>text/construction.do">地铁建设</a>
    </div>
    <div class="weui-navbar__item">
        <a href="<%=basePath%>text/generalize.do">地铁概括</a>
    </div>

</div>


<div class="weui-footer weui-footer_fixed-bottom" >
    <p class="weui-footer__links">
        <a href="javascript:void(0);" class="weui-footer__link">底部链接</a>
        <a href="javascript:void(0);" class="weui-footer__link">底部链接</a>
    </p>
    <p class="weui-footer__text">Copyright © 2008-2019 南京地铁</p>
</div>
</body>
</html>
