<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%String url = "/home/comback.do";%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>EZOPEN播放协议</title>

    <style>
        body {
            margin: 0;
            background:url(<%=request.getContextPath()%>/gx/images/colorBg.jpg) repeat;
        }

        #url {
            width: 100%;
        }

        .btn-container {
            width: 600px;
            margin: 10px auto;
            text-align:center;
        }

        #myPlayer {
            max-width: 600px;
            width: 100%;
        }
        .button{ background:#4abff5; width:150px; height:45px; line-height:45px; color:#fff; border:0px; font-size:16px;}
        .button02{ background:#ff9600; width:150px; height:45px; line-height:45px; color:#fff; border:0px; font-size:16px; margin-left:20px;}
        .button03{ background:#398439; width:150px; height:45px; line-height:45px; color:#fff; border:0px; font-size:16px; margin-left:20px;}


    </style>
    <script src="<%=request.getContextPath()%>/gx/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/gx/js/ezuikit.js"></script>

<body>
<div class="btn-container">
    <button id="init" class="button">初始化播放</button>
    <button id="stop" class="button02">结束</button>
    <button id="comeback" class="button03">关闭</button>
    <video id="myPlayer" style="margin-top:10px;border:8px #d3d3d3 solid" autoplay src="" controls playsInline webkit-playsinline>
    </video>
</div>

<script>
    $(function () {
        var url = window.location.href;
         url=url.split("=")[1]+"="+url.split("=")[2];
        $('#myPlayer').attr("src", url);
        var player = new EZUIKit.EZUIPlayer('myPlayer');
        $('#init').click(function () {
            var url = window.location.href;
            url=url.split("=")[1]
            $('#myPlayer').attr("src", url);
            var player = new EZUIKit.EZUIPlayer('myPlayer');
        });
        $("#stop").click(function () {
            player.stop();
        })
        $("#comeback").click(function () {
            window.close();
        })
    })



</script>

</body>

</html>