package com.example.chen.hackathonproject;


import org.apache.http.params.CoreConnectionPNames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import ch.boye.httpclientandroidlib.HttpEntity;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;

/**
 * Created by chen on 15/10/24.
 */
public class NetCore {
    public static String postResultToNet(String url,List<NameValuePair> params) throws Exception{
        //创建连接地址

        HttpPost httpRequest = new HttpPost(url);
        //发送的信息以键值对的形式发送
        //编码成字符串,取出响应内容的消息对象
        HttpEntity httpEntity = new UrlEncodedFormEntity(params, "utf-8");
        httpRequest.setEntity(httpEntity);
        //发送请求
        HttpClient httpClient = new DefaultHttpClient();
        //设置请求超时和连接超时
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
        HttpResponse httpResponse = httpClient.execute(httpRequest);

        String result = "";
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            BufferedReader bin = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            result = bin.readLine();
            System.out.println(result);
        }
        return result;
    }

//    static String postResultToNet(String url, String content) throws Exception{
//        HttpPost httpRequest = new HttpPost(url);
//        HttpEntity httpEntity = new UrlEncodedFormEntity(content,"utf-8");
//        httpRequest.set
//
//        return null;
//    }
}
