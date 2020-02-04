<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    // 设置每隔5秒刷新一次
    response.setIntHeader("Refresh", 60);
    // 获取当前时间
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
    else
        am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
//    out.println("当前时间为: " + CT + "\n");
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <%--<script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>--%>
    <script src="<%=request.getContextPath()%>/gx/BJUI/js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main1119.css"/>

    <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=40f96999cac1cd56c8eaf0f6da04b6c6&plugin=AMap.Autocomplete,AMap.PlaceSearch"></script>

<%--<script type="text/javascript" src="https://cache.amap.com/lbs/static/addToolbar.js"></script>--%>

</head>
<body>
<style>
    html,
    body,
    #container {
        width: 100%;
        height: 100%;
    }
</style>
<div id="container"></div>

<script type="text/javascript">
       $(function(){
           $.ajax({
               type : "POST",
               contentType: "application/json;charset=UTF-8",
               url : '<%=basePath%>map/map.do?',
               success : function(result) {
                   var mapRecordList=result.mapRecordList;
                   //地图加载
                   <%--alert(${"mapRecordList"})--%>
                   var map = new AMap.Map("container", {
                       resizeEnable: true,
                       zoom:12 //初始化地图层级
//                    center: [118.833362,  32.146682] //初始化地图中心点
                   });

                   var placeSearch = new AMap.PlaceSearch({
                       map: map
                   });  //构造地点查询类
//
//                   }
                   var markerList =new Array();
                   var clickHandler = function(e) {
//                       console.log(e.target);
                       for(var i=0;i<markerList.length;i++){
                           if(e.target==markerList[i]){
                               var userInfo="姓名："+mapRecordList[i]["userName"]+"&nbsp;&nbsp;&nbsp;"+"手机号："+mapRecordList[i]["personPhone"];
                               <%--$(this).dialog({id:'mydialog', url:'<%=basePath%>map/map-dialog.do?userName='+mapRecordList[i]['userName'] +'&personPhone='+mapRecordList[i]['personPhone'], title:'人员详细信息'});--%>
                               // 信息窗体的内容
                               var content = [
                                   '<div><img src="\"" http:="" webapi.amap.com="" images="" autonavi.png="" \"=""> ',
                                   '<div style="\"padding:0px " 0px="" 4px;\"=""><b>人员详细信息</b>',
                                   '姓名 : '+mapRecordList[i]["userName"] + '&nbsp;&nbsp;&nbsp;&nbsp; '+'电话 : '+mapRecordList[i]["personPhone"],
                                   '</div></div>'
                           ];


                               // 创建 infoWindow 实例
                               var infoWindow = new AMap.InfoWindow({
                                   content: content.join("<br>")//传入 dom 对象，或者 html 字符串
                               });

                               // 打开信息窗体
//                               alert(mapRecordList[i]["addressJd"]+"-----------"+mapRecordList[i]["addressWd"])
                               infoWindow.open(map,[mapRecordList[i]["addressJd"],mapRecordList[i]["addressWd"]]);

                           }
                       }
                   };

                   // 创建一个 Marker 实例：
                   for(var i=0;i<mapRecordList.length;i++){
                       var marker = new AMap.Marker({
                           position: new AMap.LngLat(mapRecordList[i]["addressJd"],mapRecordList[i]["addressWd"]),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                           title: mapRecordList[i]["userName"]+" "+mapRecordList[i]["personPhone"]+" "+mapRecordList[i]["addressWl"],
                           clickable:true,
                           animation:"AMAP_ANIMATION_DROP",
                           visible:true,
                           icon: '<%=request.getContextPath()%>/gx/images/img_worker.png',
                       });
                       marker.on('click', clickHandler);
                       markerList [i]=marker;
                   }



                   // 绑定事件


//                    将创建的点标记添加到已有的地图实例：
                   map.plugin(["AMap.MarkerClusterer"], function () {
                       cluster = new AMap.MarkerClusterer(map, markerList,{zoomOnClick:false});
                   });
                   map.add(markerList);
                   //显示地图层级与中心点信息
                   var bol=0;
                   function logMapinfo(){

                   };
//
//                   //绑定地图移动与缩放事件
//                   map.on('moveend', logMapinfo);
//
                   AMap.event.addListener(map,'zoomend',function(event){
                       var zoom = map.getZoom(); //获取当前地图级别

                       if(zoom>=16){
//                           event.stopPropagation;
                           cluster.removeMarkers(markerList);
                           markerList=[];
                           for(var i=0;i<mapRecordList.length;i++){

                               var marker = new AMap.Marker({
                                   position: new AMap.LngLat(mapRecordList[i]["addressJd"],mapRecordList[i]["addressWd"]),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
                                   title: mapRecordList[i]["userName"]+" "+mapRecordList[i]["personPhone"]+" "+mapRecordList[i]["addressWl"],
                                   clickable:true,
                                   animation:"AMAP_ANIMATION_DROP",
                                   visible:true,
                                   icon: '<%=request.getContextPath()%>/gx/images/img_worker.png',
                               });
                               marker.on('click', clickHandler);
                               markerList [i]=marker;
                           }
                           map.add(markerList);
                           bol=1;

                       }

                       if(zoom<15 && bol==1){
//                            alert("zoom=："+zoom+"---bol："+bol)
//                           event.stopPropagation;
                           bol=0;
                           cluster.removeMarkers(markerList);
                           map.plugin(["AMap.MarkerClusterer"], function () {
                               cluster = new AMap.MarkerClusterer(map, markerList);
                           });

                       }
                   });
                   map.setFitView();

//
               },
               error : function(e){
                   alert("error");
//                   console.log(e.status);
//                   console.log(e.responseText);
               }
           });
       });


</script>
</body>
</html>

