package com.zhenapp.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhenapp.po.Custom.TPriceInfoCustom;
import com.zhenapp.service.PriceInfoService;

@Controller
@RequestMapping(value="/price")
public class PriceInfoController {

	@Autowired
	private PriceInfoService priceInfoService;
	
	/*
	 * 查询单价列表
	 */
	@RequestMapping(value="/findAllPrice")
	public ModelAndView findAllPrice() throws Exception{
		ModelAndView mv=new ModelAndView();
		List<TPriceInfoCustom> tPriceInfoCustomlist=priceInfoService.findAllPrice();
		mv.addObject("tPriceInfoCustomlist",tPriceInfoCustomlist);
		mv.setViewName("/page/main/pricemange.jsp");
		return mv;
	}
	
	/*
	 * 修改单价信息
	 */
	@RequestMapping(value="/updatePriceBycode")
	public ModelAndView updatePriceBycode(String [] pricecounts,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		HashMap<String, Object> hashmap=new HashMap<String,Object>();
		HttpSession session=request.getSession();
		String usernick=session.getAttribute("usernick").toString();
		hashmap.put("usernick", usernick);
		hashmap.put("updatetime", sdf.format(new Date()));
		for (int i = 0; i < pricecounts.length; i++) {
			String pricecount=pricecounts[i];
			if(i==0){
				hashmap.put("pricecode", "lldj");
				hashmap.put("pricecount", pricecount);
			}else if(i==1){
				hashmap.put("pricecode", "scdj");
				hashmap.put("pricecount", pricecount);
			}else if(i==2){
				hashmap.put("pricecode", "gwcdj");
				hashmap.put("pricecount", pricecount);
			}else if(i==3){
				hashmap.put("pricecode", "ztcdj");
				hashmap.put("pricecount", pricecount);
			}
			priceInfoService.updatePriceBycode(hashmap);
		}
		mv.setViewName("findAllPrice");
		return mv;
	}
}
