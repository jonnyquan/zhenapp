package com.zhenapp.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.cookie.CookieSpecBase;
import org.apache.commons.httpclient.cookie.MalformedCookieException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import com.zhenapp.controller.back.tbaccount.TbaccountInfoController;

public class Httprequeset {
	private static Logger logger = Logger.getLogger(Httprequeset.class);
	
	//private static String url2 = "http://liuliangapp.com/api/tasks/durations";
	private static String url6 = "http://liuliangapp.com/api/url/validate";
	//private static String url8 = "http://liuliangapp.com/api/points";
	
	
	public String Get(String url) throws Exception{
		HttpClient httpClient = new HttpClient();
		String result="";
        GetMethod getMethod = new GetMethod(url);
        getMethod.setRequestHeader("secret", "bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K");
        int statusCode =  httpClient.executeMethod(getMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = getMethod.getResponseBodyAsString();
            System.out.println(result);
        }
        else {
            System.out.println("调用失败" + statusCode);
            return "失败错误码" + statusCode;
        }
        return result;
	}
	
	public String Post(String url) throws Exception{
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(url);
        postMethod.setParameter("url", "https://item.taobao.com/item.htm?id=531027639098");
        postMethod.setParameter("cache", "true");
        postMethod.setRequestHeader("secret", "bLT?lAgO?zx=mNTJb85ryzRM<]s^wpxQ?_x0NLRMu2:Hosxp2ne^cIXjF`G9Ez9K");
        //postMethod.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
        //postMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }
        else {
            System.out.println("调用失败" + statusCode);
            return "失败错误码" + statusCode;
        }
        return result;
	}
	
	public static String requestId(String url){
		HttpClient httpClient = new HttpClient();
		GetMethod getmethod = new GetMethod(url);
		try {
			CookieSpecBase cs = new CookieSpecBase();

			httpClient.executeMethod(getmethod);
		} catch (Exception e) {
			logger.error("连接被拒绝!");
			e.printStackTrace();
		} 
    	Header[] head = getmethod.getResponseHeaders();
    	for (int i = 0; i < head.length; i++) {
    		if(head[i].getName().equals("at_itemId")){
    			System.out.println("获取短链id:"+head[i].getValue());
    			return head[i].getValue();
    		}
    			
		}
    	return "";
	}
	
    public static void main(String[]args) throws Exception{
    	Httprequeset httprequeset =  new Httprequeset();
    	System.out.println(httprequeset.requestId("http://tb.cn/7iEDrUx"));
    }
}
