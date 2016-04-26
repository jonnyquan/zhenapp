package com.wxf.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxf.bean.TaoBaobean;
import com.wxf.unit.Search;
import com.wxf.unit.Taobaosearch;

public class Taobaomain extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Taobaomain() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname="";
		boolean checkhot=false;
		TaoBaobean taobao=new TaoBaobean();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String zt=new String(request.getParameter("zt").getBytes("ISO-8859-1"),"utf-8");
		if(zt.equals("")){
			zt="0";
		}
		zt=(Integer.parseInt(zt)+1)+"";
		String check=new String(request.getParameter("check").getBytes("ISO-8859-1"),"utf-8");
		String keyword=new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"utf-8");
		String itemId=new String(request.getParameter("itemId").getBytes("ISO-8859-1"),"utf-8");
		String sort=new String(request.getParameter("sort").getBytes("ISO-8859-1"),"utf-8");
		String startPrice=new String(request.getParameter("startPrice").getBytes("ISO-8859-1"),"utf-8");
		String endPrice=new String(request.getParameter("endPrice").getBytes("ISO-8859-1"),"utf-8");
		String pagecount=new String(request.getParameter("pagecount").getBytes("ISO-8859-1"),"utf-8");
		String isSeller =request.getParameter("isSeller")!=null?new String(request.getParameter("isSeller").getBytes(
		"ISO-8859-1"), "utf-8"):"1";// 0�� 1����
String isGoods = request.getParameter("isGoods")!=null?new String(request.getParameter("isGoods").getBytes(
		"ISO-8859-1"), "utf-8"):"1";// 0�� 1����
String isFreight = request.getParameter("isFreight")!=null?new String(request.getParameter("isFreight")
		.getBytes("ISO-8859-1"), "utf-8"):"1";// 0�� 1����
String isPrice = request.getParameter("isPrice")!=null?new String(request.getParameter("isPrice").getBytes(
"ISO-8859-1"), "utf-8"):"1";// 0�� 1����
String isztc2 = request.getParameter("isztc2")!=null?new String(request.getParameter("isztc2").getBytes(
"ISO-8859-1"), "utf-8"):"1";// 0�� 1����
		StringBuffer SB=new StringBuffer();
		try {
			SB=Search.getSB("http://hws.m.taobao.com/cache/wdetail/5.0/?id="+itemId);
			System.err.println(SB);
			String []arr1=SB.toString().split(",\"title\":\"");
			if(arr1.length>0){
				String []arr2=arr1[1].split("\",\"picsPath\":");
				fullname=arr2[0];
				taobao=Taobaosearch.search(fullname,itemId);
				taobao.setFullname(fullname);
				taobao.setSort(sort);
				taobao.setKeyword(keyword);
				//taobao.setStartPrice(startPrice.equals("")?taobao.getPrice():startPrice);
				//taobao.setEndPrice(endPrice.equals("")?(Double.parseDouble(taobao.getPrice())+1)+"":startPrice);
				taobao.setStartPrice(taobao.getPrice().equals("")?"":(Double.parseDouble(taobao.getPrice())-1)+"");
				taobao.setEndPrice(taobao.getPrice().equals("")?"":(Double.parseDouble(taobao.getPrice())+1)+"");
				
				if(fullname.equals("")){
					return;
				}
				if(taobao.getSeller().equals("")){
					String []arr4=SB.toString().split("location\":\"");
					String seller=arr4[1].split("\",\"price")[0];//���ҵ���
					taobao.setSeller(seller.substring(3, 5));
				}/*
				String address=Search.getaddress(taobao);
				
				for(int ii=1;ii<=Integer.parseInt(pagecount);ii++){
					String address1=address.replace("ҳ��", String.valueOf(ii));
					StringBuffer stringbuffer=Search.getSB(address1);
					
					if(stringbuffer.toString().contains(itemId)){
						
					String []arrstr=stringbuffer.toString().split("\"sold\"");
					for(int a=0;a<arrstr.length;a++){
						if(arrstr[a].contains(itemId)){
							System.out.println(arrstr[a]);
						System.out.println("��"+ii+"ҳ,��"+a+"��");
							String shortname="";//������
							String price="";//�Żݼ۸�
							String map="";//��ͼ
							String seller="";//���ҵ���
							String oldprice="";//ԭ�۸�
							String sales="";//����
							String freight="";//�˷�
							String goods="";//��Ʒ
							String auctionURL="";//���̷��ʵ�ַ
							String commentCount="";//������
							String ztc="";//ֱͨ��
							String []arr11=arrstr[a].split("title\":\"");
							shortname=arr11[1].split("\",\"sameCount")[0];
							String []arr22=arrstr[a].split("priceWithRate\":\"");
							if(arr22.length>1){
							price=arr22[1].split("\",\"pic_path")[0];}
							String []arr3=arrstr[a].split("pic_path\":\"");
							if(arr3[1].indexOf("uprightImg")!=-1){
								map = arr3[1].split("\",\"uprightImg")[0];
							}else if(arr3[1].indexOf("priceWap")!=-1){
								map = arr3[1].split("\",\"priceWap")[0];
							}else {
								map = arr3[1].split("\",\"auctionURL")[0];
								
							}
							if(map.indexOf("solar")!=-1){
								continue;
							}
							String []arr4=arrstr[a].split("location\":\"");
							seller=arr4[1].split("\",\"price")[0];//���ҵ���
							String []arr5=arrstr[a].split("price\":\"");
							oldprice=arr5[1].split("\",\"priceColor")[0];//ԭ�۸�
							String []arr7=arrstr[a].split("shipping\":\"");
							freight=arr7[1].split("\",\"ratesum")[0];//�˷�
							String []arr8=arrstr[a].split("auctionURL\":\"");
							auctionURL=arr8[1].split("\",\"type")[0];//���ʵ�ַ
							String []arr10=arrstr[a].split("commentCount\":\"");
							commentCount="";
							String []arr13=arrstr[a].split("iconList\":\"");
							ztc=arr13[1].split("\",\"uniqpid")[0];//ֱͨ��
							
							goods="�Ա�";//��Ʒ
							if(arrstr[a].contains("tmall,xxpf,xfbug")){
								goods="��è";
							}
							if(freight.equals("")){
								String []arr12=arrstr[a].split("ordinaryPostFee\":\"");
								freight=arr12[1].split("\",\"distance")[0];
							}
							if(freight.equals("")){
								String []arr12=arrstr[a].split("fastPostFee\":\"");
								freight=arr12[1].split("\",\"title")[0];
							}
							if(price.equals("")){
								price=oldprice;
							}
							if(seller.equals("")){
								String []arr12=arrstr[a].split("sellerLoc\":\"");
								freight=arr12[1].split("\",\"fastPostFee")[0];
							}
							if(freight.equals("0.00")){
								freight="���˷�";
							}
							if(ztc.indexOf("p4p")!=-1){
								checkhot=true;
							}
							taobao.setCheckhot(checkhot);
							taobao.setShortname(shortname);//������
							taobao.setPrice(price);//�Żݼ۸�
							taobao.setMap(map);//��ͼ
							taobao.setSeller(seller.length()>3?seller.substring(3, 5):seller);//���ҵ���
							taobao.setOldprice(oldprice);//ԭ�۸�
							taobao.setSales(sales);//����
							taobao.setFreight(freight);//�˷�
							taobao.setGoods(goods);//��Ʒ
							taobao.setAuctionURL(auctionURL);//���ʵ�ַ
							taobao.setCommentCount(commentCount);//������
							taobao.setRanking("��"+ii+"ҳ����"+a+"��");//����
							
							break;
						}
						}
					if(taobao.getRanking().length()>1){
						break;
					}
					}
				}*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("taobao", taobao);
		request.setAttribute("zt", zt);
		request.setAttribute("keyword", keyword);
		request.setAttribute("itemId", itemId);
		request.setAttribute("startPrice", taobao.getStartPrice());
		request.setAttribute("endPrice", taobao.getEndPrice());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("check", check);
		request.setAttribute("isSeller", isSeller);
		request.setAttribute("isGoods", isGoods);
		request.setAttribute("isFreight", isFreight);
		request.setAttribute("isPrice", isPrice);
		request.setAttribute("isztc2", isztc2);
		
		try {
			String path=request.getSession().getServletContext().getRealPath("/");
			//System.out.println(path);
			Search.getSubImage(taobao.getMap().replace("60x60", "220x220"),path, 91, 41, 25, 100);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
