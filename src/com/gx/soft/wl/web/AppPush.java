package com.gx.soft.wl.web;
import com.alibaba.fastjson.JSONObject;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.notify.Notify;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.dto.GtReq;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import org.apache.commons.collections.map.HashedMap;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;


public class AppPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "iDaNtYVN0l9AO7Tg8rUxb8";
    private static String appKey = "yqgHTDjLhi5kkvWOX6Wto1";
    private static String masterSecret = "9EkONQI2X46oKLmtuyAcf6";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";
    private static String host = "http://sdk.open.api.igexin.com/apiex.htm";
//    static String CID = "dc91f527e32a59450ff376957d1bedb5";




    public  TransmissionTemplate linkTemplateDemo(String tzBt,String tzContent) {
        TransmissionTemplate t = new TransmissionTemplate();
        t.setAppId(appId);
        t.setAppkey(appKey);
        JSONObject o=new JSONObject();
        o.put("path","materialManage");
        JSONObject object = new JSONObject();
        object.put("payload",o);
        object.put("title",tzBt);
        object.put("content",tzContent);
        t.setTransmissionContent(String.valueOf(object));
//        t.setTransmissionContent("{title:\"标题\",content:\"内容\",payload:\"自定义数据\"}");
//        t.setTransmissionContent("{title:"+tzBt+",content:"+tzContent+",payload:"+object+"}");

        t.setTransmissionType(2);
        return t;
    }

    public  TransmissionTemplate getTemplate(APNPayload.DictionaryAlertMsg diction) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionContent("透传内容");
        template.setTransmissionType(2);
        APNPayload payload = new APNPayload();
        JSONObject object = new JSONObject();
        object.put("path","materialManage");
        payload.addCustomMsg("payload",object);
        payload.setBadge(0);
        payload.setContentAvailable(1);
        payload.setSound("default");
//        payload.setCategory("$由客户端定义");
        //简单模式APNPayload.SimpleMsg
//        payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //字典模式使用下者
        payload.setAlertMsg(diction);
        template.setAPNInfo(payload);
        return template;
    }
    APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(String tzBt, String tzContent){
        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        alertMsg.setBody(tzContent);
        alertMsg.setActionLocKey("ActionLockey");
        alertMsg.setLocKey("LocKey");
        alertMsg.addLocArg("loc-args");
        alertMsg.setLaunchImage("launch-image");
        // IOS8.2以上版本支持
        alertMsg.setTitle(tzBt);
        alertMsg.setTitleLocKey("TitleLocKey");
        alertMsg.addTitleLocArg("TitleLocArg");
        return alertMsg;
    }
    public static void main(String[] args) throws IOException {
////        ios
//        IGtPush push = new IGtPush(url, appKey, masterSecret);
//
//        List<String> appIds = new ArrayList<String>();
//        appIds.add(appId);
//        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
//        SingleMessage message2 = new SingleMessage();
//        TransmissionTemplate transmissionTemplate = getTemplate(AppPush.getDictionaryAlertMsg("不合格检测","^^^^^^^^^"));
//        message2.setData(transmissionTemplate);
////        message2.setAppIdList(appIds);
//        message2.setOffline(true);
//        message2.setOfflineExpireTime(1000 * 600);
//        Target target2 = new Target();
//        target2.setAppId(appId);
//        target2.setClientId("dc91f527e32a59450ff376957d1bedb5");
//        //    notificationTemplateDemo(appId, appKey);
//
//        IPushResult ret = push.pushMessageToSingle(message2,target2);
//        System.out.println(ret.getResponse().toString());
////______________________________________________________________________________________________________
////       安卓
//        LinkTemplate template1 = linkTemplateDemo("不合格检测台账","ABCDEFG");
//        SingleMessage message = new SingleMessage();
//        message.setOffline(true);
//        // 离线有效时间，单位为毫秒，可选
//        message.setOfflineExpireTime(24 * 3600 * 1000);
//        message.setData(template1);
//        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
//        message.setPushNetWorkType(0);
//        Target target = new Target();
//        target.setAppId(appId);
//        target.setClientId("b1285d35506244e750f4c68d731beb3a");
//
//        ret = null;
//        try {
//            ret = push.pushMessageToSingle(message, target);
//        } catch (RequestException e) {
//            e.printStackTrace();
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
//        }
//        if (ret != null) {
//
//            System.out.println(ret.getResponse().toString());
//        } else {
//            System.out.println("服务器响应异常");
//        }


    }


}









