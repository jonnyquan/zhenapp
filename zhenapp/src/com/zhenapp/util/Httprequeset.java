package com.zhenapp.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Httprequeset {
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
	
    public static void main(String[]args) throws Exception{
    	Httprequeset httprequeset =  new Httprequeset();
    	httprequeset.Post(url6);
    }
}
