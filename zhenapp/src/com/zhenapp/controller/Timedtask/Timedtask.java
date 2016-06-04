package com.zhenapp.controller.Timedtask;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component(value="/Timedtask")
public class Timedtask {
	private static Logger logger = Logger.getLogger(Timedtask.class);
	
	@Value("${host}")
	private String host;
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次 判断终止中的任务是否已终止
	public void job1() throws HttpException, IOException {
		logger.info("任务执行开始....每分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/updateTaskstateByTiming";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
        logger.info("判断终止中的任务是否已终止....每分钟执行一次");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次 将执行终止状态的详情任务删除
	public void job2() throws HttpException, IOException {
		logger.info("任务执行开始....每分钟执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/deleteTaskstate";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
        logger.info("将执行终止状态的详情任务删除....每分钟执行一次");
	}
	
	@Scheduled(cron = "0 */10 * * * ?")//每隔10分钟执行一次 判断任务是否已完成
	public void job3() throws HttpException, IOException {
		logger.info("任务执行开始....每10分钟执行一次检查任务是否执行完成");
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/cyclecheckTask";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
        logger.info("任务执行结束....每10分钟执行一次检查任务是否执行完成");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次 将任务错误数大于等于系统设置的最大任务错误数即终止该任务
	public void job4() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/platform/endTaskstate";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
        logger.info("任务错误数大于等于系统设置的最大任务错误数即终止该任务数....每分钟执行一次");
	}
	
	@Scheduled(cron = "0 */2 * * * ?")//每隔2分钟执行一次 将符合要求的详情任务放入详情任务临时表
	public void job5() throws HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String result="";
		String url = host+"/api/allocationTask";
        PostMethod postMethod = new PostMethod(url);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
	}
	
	@Scheduled(cron = "0 1 0 * * ?")//每天0点1分执行一次
	public void updateTaskstateByTime() throws Exception { 
		logger.info("任务执行开始....每天0点1分执行一次");
		HttpClient httpClient = new HttpClient();
		String result="";
        PostMethod postMethod = new PostMethod(host+"/api/platform/updateTaskstateByTime");
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        int statusCode =  httpClient.executeMethod(postMethod);
        if(statusCode == 200) {
            System.out.println("调用成功");
            result = postMethod.getResponseBodyAsString();
            System.out.println(result);
        }else {
            System.out.println("调用失败" + statusCode);
        }
		logger.info("任务执行完成....每天0点1分执行一次");
	}
}
