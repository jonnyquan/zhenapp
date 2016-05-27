package com.zhenapp.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.po.Custom.TDateInfoCustom;
import com.zhenapp.service.DateInfoService;

@Service
public class DateService {
	@Autowired
	private DateInfoService dateInfoService;
	
	public void insertDate() throws Exception{
		TDateInfoCustom tDateInfoCustom = new TDateInfoCustom();
		try{
			dateInfoService.insertDate(tDateInfoCustom);
			throw new RuntimeException();
		}catch(Exception e){
			
		}
		System.out.println("runtime");
	}
}
