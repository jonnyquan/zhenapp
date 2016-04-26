package com.wxf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxf.bean.TaoBaobean;
import com.wxf.unit.Search;
import com.wxf.unit.Taobaosearch;

public class ztc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ztc() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = "";
		boolean checkhot = false;
		TaoBaobean taobao = new TaoBaobean();
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String zt = new String(request.getParameter("zt")
				.getBytes("ISO-8859-1"), "utf-8");
		if (zt.equals("")) {
			zt = "0";
		}
		zt = (Integer.parseInt(zt) + 1) + "";
		String check = new String(request.getParameter("check").getBytes(
				"ISO-8859-1"), "utf-8");
		String keyword = new String(request.getParameter("keyword").getBytes(
				"ISO-8859-1"), "utf-8");
		String itemId = new String(request.getParameter("itemId").getBytes(
				"ISO-8859-1"), "utf-8");
		String sort = new String(request.getParameter("sort").getBytes(
				"ISO-8859-1"), "utf-8");
		String startPrice = new String(request.getParameter("startPrice")
				.getBytes("ISO-8859-1"), "utf-8");
		String endPrice = new String(request.getParameter("endPrice").getBytes(
				"ISO-8859-1"), "utf-8");
		String pagecount = new String(request.getParameter("pagecount")
				.getBytes("ISO-8859-1"), "utf-8");
		String isSeller =request.getParameter("isSeller")!=null?new String(request.getParameter("isSeller").getBytes(
				"ISO-8859-1"), "utf-8"):"1";// 0是 1不是
		String isGoods = request.getParameter("isGoods")!=null?new String(request.getParameter("isGoods").getBytes(
				"ISO-8859-1"), "utf-8"):"1";// 0是 1不是
		String isFreight = request.getParameter("isFreight")!=null?new String(request.getParameter("isFreight")
				.getBytes("ISO-8859-1"), "utf-8"):"1";// 0是 1不是
		String isPrice = request.getParameter("isPrice")!=null?new String(request.getParameter("isPrice").getBytes(
		"ISO-8859-1"), "utf-8"):"1";// 0是 1不是
		
		String isztc2 = request.getParameter("isztc2")!=null?new String(request.getParameter("isztc2").getBytes(
		"ISO-8859-1"), "utf-8"):"1";// 0是 1不是
		String ztimgurl = new String(request.getParameter("ztimgurl").getBytes(
		"ISO-8859-1"), "utf-8");
		String ztcimgurl = new String(request.getParameter("ztcimgurl").getBytes(
		"ISO-8859-1"), "utf-8");
		
		
		StringBuffer SB = new StringBuffer();
		try {
			SB = Search.getSB("http://hws.m.taobao.com/cache/wdetail/5.0/?id="
					+ itemId);
			// System.out.println(SB.toString());
			String[] arr1 = SB.toString().split(",\"title\":\"");
			if (arr1.length > 0) {
				String[] arr2 = arr1[1].split("\",\"picsPath\":");
				fullname = arr2[0];
				taobao = Taobaosearch.search(fullname, itemId);
				taobao.setFullname(fullname);
				taobao.setSort(sort);
				taobao.setKeyword(keyword);
				if(isPrice.equals("0")){
					taobao.setStartPrice(startPrice.equals("") ?"": startPrice);
					taobao.setEndPrice(endPrice.equals("") ?"": endPrice);
				}else{
					taobao.setStartPrice((Double
							.parseDouble(taobao.getPrice()) - 1)
							+ "");
					taobao.setEndPrice((Double
							.parseDouble(taobao.getPrice()) + 1)
							+ "");
				}/*
				taobao.setStartPrice(startPrice.equals("") ? taobao.getPrice()
						: startPrice);
				taobao.setEndPrice(endPrice.equals("") ? (Double
						.parseDouble(taobao.getPrice()) + 1)
						+ "" : startPrice);*/
				if (fullname.equals("")) {
					return;
				}
				if (taobao.getSeller().equals("")) {
					String[] arr4 = SB.toString().split("location\":\"");
					String seller = arr4[1].split("\",\"price")[0];// 卖家地区
					taobao.setSeller(seller.substring(3, 5));
				}
				String address = Search.getaddressztc(taobao, isSeller,
						isGoods, isFreight, isPrice,startPrice,endPrice);

				for (int ii = 1; ii <= Integer.parseInt(pagecount); ii++) {
					String address1 = address.replace("页数", String.valueOf(ii));
					StringBuffer stringbuffer = Search.getSB(address1);
					if (stringbuffer.toString().contains(itemId)) {

						String[] arrstr = stringbuffer.toString().split(
								"\"sold\"");
						for (int a = 0; a < arrstr.length; a++) {
							if (arrstr[a].contains(itemId)) {
								System.out.println(arrstr[a]);
								System.out.println("第" + ii + "页,第" + a + "个");
								String map = "";// 贴图
								String[] arr3 = arrstr[a]
										.split("pic_path\":\"");
								if(arr3[1].indexOf("uprightImg")!=-1){
									map = arr3[1].split("\",\"uprightImg")[0];
								}else{
									map = arr3[1].split("\",\"priceWap")[0];
								}
								System.out.println(map);
								map=map.replace("60x60", "220x220");
								String ztcPicPathSuffix=map.substring(map.indexOf("XXXXXX")-15,map.indexOf("XXXXXX"));
								if(isztc2.equals("0")){
									//用提供的直通车地址和和获取的图片地址进行判断。
									if(ztcimgurl != null && !"".equals(ztcimgurl) && !ztcPicPathSuffix.equals(ztcimgurl.substring(ztcimgurl.indexOf("XXXXXX")-15,ztcimgurl.indexOf("XXXXXX")))){
										continue;
									}
										//根据用户提供的宝贝主图地址和获取的主图地址进行判断
									if(ztimgurl != null && !"".equals(ztimgurl) &&  ztimgurl.substring(ztimgurl.indexOf("XXXXXX")-15,ztimgurl.indexOf("XXXXXX")).equals(ztcPicPathSuffix)){
										continue;
									}
								}else{
									/*
									 *根据是否有solar 标识   来判断是否直通车
									 */
									if(map.indexOf("solar")==-1){
										continue;
									}
								}
								System.out.println("该商品是直通车商品");
								checkhot = true;
								taobao.setCheckhot(checkhot);
								taobao.setMap(map);// 贴图
								taobao.setRanking("第" + ii + "页，第" + a + "个");// 排名
								break;
							}
						}
						if (taobao.isCheckhot()) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("taobao", taobao);
		request.setAttribute("zt", zt);
		request.setAttribute("keyword", keyword);
		request.setAttribute("itemId", itemId);
		request.setAttribute("startPrice", startPrice);
		request.setAttribute("endPrice", endPrice);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("check", check);
		request.setAttribute("isSeller", isSeller);
		request.setAttribute("isGoods", isGoods);
		request.setAttribute("isFreight", isFreight);
		request.setAttribute("isPrice", isPrice);
		request.setAttribute("isztc2", isztc2);
		request.setAttribute("ztimgurl", ztimgurl);
		request.setAttribute("ztcimgurl", ztcimgurl);
		try {
			String path = request.getSession().getServletContext().getRealPath(
					"/");
			//System.out.println(path);
			
			Search.getSubImage(taobao.getMap().replace("60x60", "220x220"), path, 91, 41, 25, 100);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
