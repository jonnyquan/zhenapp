package com.zhenapp.controller.phoneapi;

import org.apache.commons.httpclient.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenapp.util.Httprequeset;

@Controller
public class RequestWebToCID {
	HttpClient httpClient = new HttpClient();
	@RequestMapping("/api/requestWebToCID/task")
	public @ResponseBody String requestWebToCID(String content) throws Exception{
    	String id = "";
    	for (int i = 0; i < 5; i++) {
    		id = Httprequeset.requestId(content);
    		if(id.length()>1){
    			break;
    		}else{
    			Thread.sleep(2000);
    		}
		}
		return id;
	}
}
