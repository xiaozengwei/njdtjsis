package com.gx.soft.monitor.web;

import com.gx.core.hibernate.PropertyFilter;
import com.gx.soft.common.util.DateFormatUtil;
import com.gx.soft.monitor.persistence.domain.YcMonitor;
import com.gx.soft.monitor.persistence.manager.YcMonitorManager;
import com.gx.soft.restservice.persistence.domain.CuringTemperature;
import com.gx.soft.restservice.persistence.manager.CuringTemperatureManager;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("monitor")
public class YcMonitorController {
    @Autowired
    private YcMonitorManager ycMonitorManager;
    @Autowired
    private CuringTemperatureManager curingTemperatureManager;

    @Scheduled(cron = "0 0/5 * * * ? ")
    @RequestMapping(value = "yc", method = RequestMethod.GET, produces = "application/json")
    public void inputYc() {
        getYcMessage("bltyc005210","bltyc123456","燕子矶","22202",1);
        getYcMessage("bltyc008080","bltyc123456","笆斗山","32888",0);
    }

    /**
     * 按天定时 删除三月之外的数据
     */
    @Scheduled(cron ="0 0 0 * * ?")
    @RequestMapping(value = "clearTemperatureMonitor", method = RequestMethod.GET, produces = "application/json")
    public void clearTemperatureMonitor() {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH,-3);
        Map<String,Object> map=new HashMap<>();
        map.put("filter_LED_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
        List<CuringTemperature> list=curingTemperatureManager.find(PropertyFilter.buildFromMap(map));
        curingTemperatureManager.removeAll(list);

        List<YcMonitor> ycMonitors=ycMonitorManager.find("from YcMonitor where localRecordTime<?",map.get("filter_LED_time"));
        ycMonitorManager.removeAll(ycMonitors);

    }


    private void getYcMessage(String username,String password,String bdName,String idNum,int start){
        try {
            HttpClient client=new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://web.tlink.io/user/login.htm");
            List<NameValuePair> nvp = new ArrayList<NameValuePair>();
            nvp.add(new BasicNameValuePair("loginAccount",username));
            nvp.add(new BasicNameValuePair("loginPassword", password));
            nvp.add(new BasicNameValuePair("companyUserId", "0"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvp, HTTP.UTF_8));
            HttpResponse response1 = client.execute(httpPost);
            httpPost.abort();//关闭httppost，不关闭的话下面使用httpget会报错
            if (response1.getStatusLine().getStatusCode() == 200) {//使用httppost执行，会导致302重定向，response中会包含重定向的地址yyy，需使用get方式访问
                HttpGet httpget = new HttpGet("http://web.tlink.io/user/searchSensorsPage.htm");
                HttpResponse response = client.execute(httpget);
                String entity = EntityUtils.toString (response.getEntity(),"utf-8");
//                System.out.println(entity);//输出的就是html的内容
                Document document=Jsoup.parse(entity);
                if(document.getElementById("sz_"+idNum+"1").text().equals("未连接")){
                    return;
                }
                List<String> list=new ArrayList<>();
                for(int i=start;i<9;i++) {
//                    System.out.println(document.select("span[id='s_22202"+i+"']").first().toString());
                    list.add(document.getElementById("s_"+idNum+i).text());
                }
                YcMonitor ycMonitor = new YcMonitor();
                ycMonitor.setBdId("010802");
                ycMonitor.setBdName(bdName);
                ycMonitor.setTemperature(list.get(0));
                ycMonitor.setHumidity(list.get(1));
                ycMonitor.setSpeed(list.get(2));
                ycMonitor.setWind(list.get(3)+"度");
                ycMonitor.setPm25(list.get(5));
                ycMonitor.setPm10(list.get(6));
                ycMonitor.setDb(list.get(7));
                ycMonitor.setRowId(null);
                ycMonitor.setTime(document.getElementById("st_"+idNum+"2").text());
                ycMonitor.setLocalRecordTime(DateFormatUtil.convertUtilDateToString(new Date()));
                if(InetAddress.getLocalHost().getHostAddress().equals("10.0.0.12")){
                    ycMonitorManager.save(ycMonitor);
                }
            }else {
                System.out.println("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
