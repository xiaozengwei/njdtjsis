package com.gx.soft.restservice.persistence.domain;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpClient {

    public static String sendHttpRequest(String url,String parameter,String contentType){
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent=null;
        HttpPost httpPost=new HttpPost(url);
        httpPost.setHeader("Content-Type",contentType);
        StringEntity entity=new StringEntity(parameter,"UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        try{
            CloseableHttpResponse response=client.execute(httpPost);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity he=response.getEntity();
                respContent= EntityUtils.toString(he,"UTF-8");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return respContent;
    }
}
