package com.zhenapp.controller.Timedtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.po.Custom.TDateInfoCustom;
import com.zhenapp.service.DateInfoService;

@Service
public class TestTranService {
	@Autowired
	private DateInfoService dateInfoService;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat HHmm = new SimpleDateFormat("HHmm");
	
	public void test(int i) throws Exception{
		TDateInfoCustom tDateInfoCustom = new TDateInfoCustom();
			tDateInfoCustom.setDateid(yyyyMMdd.format(new Date()));
			tDateInfoCustom.setDatevalue(yyyyMMdd.format(new Date()));
			tDateInfoCustom.setCreatetime(sdf.format(new Date()));
			tDateInfoCustom.setCreateuser("sys");
			tDateInfoCustom.setUpdatetime(sdf.format(new Date()));
			tDateInfoCustom.setUpdateuser("sys");
			dateInfoService.insertDate(tDateInfoCustom);
			if(i==5){
				throw new RuntimeException();
			}
		
	}
}
