package com.zhenapp.util;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 字符串工具类.
 * 
 * @author sunruyi
 */
public class StringUtilWxf {
	private static Logger logger = Logger.getLogger(StringUtilWxf.class);
	/**
	 * 去除字符串首尾出现的某个字符.
	 * 
	 * @param source
	 *            源字符串.
	 * @param element
	 *            需要去除的字符.
	 * @return String.
	 */
	public static String trimFirstAndLastChar(String source, String element) {
		boolean beginIndexFlag = true;
		boolean endIndexFlag = true;
		do {
			int beginIndex = source.indexOf(element) == 0 ? 1 : 0;
			int endIndex = source.lastIndexOf(element) + 1 == source.length() ? source
					.lastIndexOf(element) : source.length();
			source = source.substring(beginIndex, endIndex);
			beginIndexFlag = (source.indexOf(element) == 0);
			endIndexFlag = (source.lastIndexOf(element) + 1 == source.length());
		} while (beginIndexFlag || endIndexFlag);
		return source;
	}
	
	
	/*
	 * 判断调用第一个网站的接口 返回错误码解析
	 */
	public static String translat(String code) throws Exception{
		String str="未知错误";
		if(code.equals("100")){
			str="每小时发送量必须是24位长度数组";
		}else if(code.equals("101")){
			str="无法获得商品信息";
		}else if(code.equals("102")){
			str="无法识别商品URL";
		}else if(code.equals("103")){
			str="关键词不符合要求";
		}else if(code.equals("104")){
			str="任务开始时间不能早于今天";
		}else if(code.equals("105")){
			str="开始时间不能在结束时间后";
		}else if(code.equals("106")){
			str="请选择停留时间";
		}else if(code.equals("107")){
			str="总的发送量必须大于0";
		}else if(code.equals("108")){
			str="日期格式不正确";
		}else if(code.equals("109")){
			str="任务名称必须填写";
		}else if(code.equals("110")){
			str="积分不足";
		}else if(code.equals("111")){
			str="gprs网络的手机百分比必须是0-100整数";
		}else if(code.equals("112")){
			str="天猫app百分比必须是0-100整数";
		}else if(code.equals("113")){
			str="刷入天猫APP必须加载第三方统计，即plus的值必须为true";
		}else if(code.equals("114")){
			str="深入点击必须加载第三方统计，即plus的值必须为true";
		}else if(code.equals("115")){
			str="深入点击百分比必须是0-100整数";
		}else if(code.equals("116")){
			str="店铺中没有其他宝贝，无法深入点击";
		}else if(code.equals("117")){
			str="由于浏览店铺其他宝贝比较耗时，深入点击不支持30秒以下的停留";
		}else{
			logger.error("调用失败时间：" + new Date() + "错误码为:"+code);
		}
		return str;
	}
	
	public static String checkcode(String code){
		String str="";
		if(code.equals("35")){
			str="综合";
		}else if(code.equals("36")){
			str="信用";
		}else if(code.equals("37")){
			str="价格低到高";
		}else if(code.equals("38")){
			str="价格高到低";
		}else if(code.equals("39")){
			str="销量";
		}else{
			str="未知排序类型";
		}
		return str;
	}
	
	public static String strtonull(String str1){
		String str="";
		if(str1==null){
			str="null";
		}else{
			if(str1.length()<1){
				str="null";
			}else{
				str=str1;
			}
		}
		return str;
	}

}
