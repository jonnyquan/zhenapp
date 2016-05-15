package com.zhenapp.controller.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="/Timedtask")
public class Timedtask {
	private static Logger logger = Logger.getLogger(Timedtask.class);
	
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次
	public void job1() throws HttpException, IOException {
		logger.info("任务进行中....每隔1分钟执行一次");
	}
	
	
	
	@Scheduled(cron = "0 1 0 * * ?")//每天0点1分执行一次
	public void updateTaskstateByTime() throws Exception { 
		logger.info("任务执行开始....每天0点1分执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod("http://localhost:8080/zhenapp/api/updateTaskstateByTime");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }
        else {
            System.out.println("调用失败" + statusCode);
        }
		logger.info("任务执行完成....每天0点1分执行一次");
	}
}
