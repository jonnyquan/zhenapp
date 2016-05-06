package com.zhenapp.po.Custom;

import java.util.Date;

import com.zhenapp.po.TPointsInfo;
import com.zhenapp.util.DateUtilWxf;

public class TPointsInfoCustom extends TPointsInfo{
	private String pointstypename;

	public String getPointstypename() {
		return pointstypename;
	}

	public void setPointstypename(String pointstypename) {
		this.pointstypename = pointstypename;
	}
	
	
	
	public static int cost(TTaskInfoCustom tTaskInfoCustom,TPriceInfoCustom tPriceInfoCustom) throws Exception{
		Date date = new Date();
		int hours = date.getHours()+1;
		int days = DateUtilWxf.getBetweenDays(tTaskInfoCustom.getTaskstartdate().replace("-", ""), tTaskInfoCustom.getTaskenddate().replace("-", ""));
		String [] taskkeywordarr=tTaskInfoCustom.getTaskkeyword().split("====");
		String [] hourarr = tTaskInfoCustom.getTaskhourcounts().split(",");
		int flowcounts = 0;
		int subflowcounts = 0;
		for (int i = 0; i < hourarr.length; i++) {
			flowcounts = flowcounts + Integer.parseInt(hourarr[i]);
		}
		for (int i = 0; i < hours; i++) {
			subflowcounts = subflowcounts + Integer.parseInt(hourarr[i]);
		}
		int flowpoints = flowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1()) * hourarr.length * (days + 1)  - subflowcounts * Integer.parseInt(tPriceInfoCustom.getPricecounts1());
		int Collectionpoints = tTaskInfoCustom.getCollectioncount() * Integer.parseInt(tPriceInfoCustom.getPricecounts2());
		int Shoppingpoints = tTaskInfoCustom.getShoppingcount() * Integer.parseInt(tPriceInfoCustom.getPricecounts3());
		int subtractpoints=flowpoints + Collectionpoints + Shoppingpoints;
		return subtractpoints;
	}
}
