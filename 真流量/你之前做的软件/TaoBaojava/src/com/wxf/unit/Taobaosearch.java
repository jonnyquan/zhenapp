package com.wxf.unit;

import java.net.URLEncoder;

import com.wxf.bean.TaoBaobean;

public class Taobaosearch {
	public static TaoBaobean search(String fullname,String itemId) throws Exception{
		String shortname="";//短名字
		String price="";//优惠价格
		String map="";//贴图
		String seller="";//卖家地区
		String oldprice="";//原价格
		String sales="";//销量
		String freight="";//运费
		String goods="";//商品
		String auctionURL="";//店铺访问地址
		String coinInfo="";//金币抵扣
		String commentCount="";//评论数
		for(int i=0;i<100;i++){
			
			
			String bben = "";
			for (int j = 0; j < 40; j++) {
				String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "a",
						"b", "c", "d", "e" };
				int b = (int) (Math.random() * 14);
				bben = bben + arr[b];
			}
			String str="";
			for(int a=0;a<15;a++){
				int b = (int) (Math.random() * 10);
				str=str+b;
			}
			String str2="";
			for(int a=0;a<15;a++){
				int b = (int) (Math.random() * 10);
				str2=str2+b;
			}
			
			String address="http://s.m.taobao.com/search.json?vm=nw&search_wap_mall=false&ttid=212200%40taobao_android_3.5.3&v=*&page="+i+"&q="+URLEncoder.encode(fullname, "UTF-8");
			address=address+"&imei="+str+"&n=40&device_id="+bben+"&imsi="+str2;
			StringBuffer SB=Search.getSB(address);
			String []arrstr=SB.toString().split("\"sold\"");
			for(int a=0;a<arrstr.length;a++){
				if(arrstr[a].contains(itemId)){
					String []arr1=arrstr[a].split("\",\"title\":\"");
					shortname=arr1[1].split("\",\"sameCount")[0];
					String []arr2=arrstr[a].split("priceWithRate\":\"");
					price=arr2[1].split("\",\"pic_path")[0];
					String []arr3=arrstr[a].split("pic_path\":\"");
					map=arr3[1].split("\",\"uprightImg")[0];
					String []arr4=arrstr[a].split("location\":\"");
					seller=arr4[1].split("\",\"price")[0];//卖家地区
					String []arr5=arrstr[a].split("price\":\"");
					oldprice=arr5[1].split("\",\"priceColor")[0];//原价格
					String []arr7=arrstr[a].split("shipping\":\"");
					freight=arr7[1].split("\",\"ratesum")[0];//运费
					String []arr8=arrstr[a].split("auctionURL\":\"");
					auctionURL=arr8[1].split("\",\"type")[0];//访问地址
					String []arr10=arrstr[a].split("coinInfo\":\"");
					coinInfo=arr10[1].split("\",\"auctionURL")[0];//访问地址
					String []arr11=arrstr[a].split("commentCount\":\"");
					commentCount=arr11[1].split("\",\"ordinaryPostFee")[0];//评论数
					
					
					goods="淘宝";//商品
					if(arrstr[a].contains("tmall,xxpf,xfbug")){
						goods="天猫";
					}
					if(freight.equals("")){
						String []arr9=arrstr[a].split("ordinaryPostFee\":\"");
						freight=arr9[1].split("\",\"distance")[0];
					}
					if(freight.equals("")){
						String []arr9=arrstr[a].split("fastPostFee\":\"");
						freight=arr9[1].split("\",\"title")[0];
					}
					if(price.equals("")){
						price=oldprice;
					}
					if(seller.equals("")){
						String []arr9=arrstr[a].split("sellerLoc\":\"");
						freight=arr9[1].split("\",\"fastPostFee")[0];
					}
					if(freight.equals("0.00")){
						freight="免运费";
					}
					break;
				}
				
			}
			if(shortname.length()>1){
				break;
			}
		}
		TaoBaobean taobao=new TaoBaobean();
		taobao.setShortname(shortname);//短名字
		taobao.setPrice(price);//优惠价格
		taobao.setMap(map);//贴图
		//taobao.setSeller(seller.length()>3?seller.substring(3, 5):seller);//卖家地区
		taobao.setSeller((seller.length()>3 && seller.indexOf(" ")!=-1)?seller.substring(3, 5):seller);//卖家地区
		taobao.setOldprice(oldprice);//原价格
		taobao.setSales(sales);//销量
		taobao.setFreight(freight);//运费
		taobao.setGoods(goods);//商品
		taobao.setAuctionURL(auctionURL);//访问地址
		taobao.setCoinInfo(coinInfo);//金币抵扣
		taobao.setCommentCount(commentCount);//评论数
		return taobao;
	}
	
	
	
	public static void main(String[]args) throws Exception{
		Taobaosearch taobao=new Taobaosearch();
		TaoBaobean search = taobao.search("男装2015秋季长袖t恤男圆领修身秋衣韩版男士加绒加厚打底衫男潮","522607293172");
		System.out.println(search);
	}
}
