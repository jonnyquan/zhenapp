package com.zhenapp.controller.Timedtask;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod("http://liuliangapp.com/api/allocation");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            logger.info("调用接口成功(/api/allocation),返回："+result);
        }else {
            logger.info("调用接口失败(/api/allocation),返回："+statusCode);
        }
		logger.info("分配任务完成....每3分钟执行一次");
	}
}
