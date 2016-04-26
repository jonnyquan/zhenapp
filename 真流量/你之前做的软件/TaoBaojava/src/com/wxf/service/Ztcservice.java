package com.wxf.service;

import org.junit.Test;

import com.wxf.bean.TaoBaoQuery;
import com.wxf.bean.TaoBaobean;
import com.wxf.unit.Search;
import com.wxf.unit.Taobaosearch;

public class Ztcservice {
	public TaoBaoQuery TaoBaomainservice(String itemId, String fullname,String sort, String keyword, String pagecount, String path
			,String check,String startPrice,String endPrice,String ztimgurl,String ztcimgurl,
			String isPrice,String isSeller,String isGoods,String isFreight,String ztc2) {
		boolean checkhot = false;
	TaoBaobean taobao = new TaoBaobean();
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
				return null;
			}
			if (taobao.getSeller().equals("")) {
				String[] arr4 = SB.toString().split("location\":\"");
				String seller = arr4[1].split("\",\"price")[0];// ���ҵ���
				taobao.setSeller(seller.substring(3, 5));
			}
			String address = Search.getaddressztc(taobao, isSeller,
					isGoods, isFreight, isPrice,startPrice,endPrice);

			for (int ii = 1; ii <= Integer.parseInt(pagecount); ii++) {
				String address1 = address.replace("ҳ��", String.valueOf(ii));
				StringBuffer stringbuffer = Search.getSB(address1);
				if (stringbuffer.toString().contains(itemId)) {

					String[] arrstr = stringbuffer.toString().split(
							"\"sold\"");
					for (int a = 0; a < arrstr.length; a++) {
						if (arrstr[a].contains(itemId)) {
							System.out.println(arrstr[a]);
							System.out.println("��" + ii + "ҳ,��" + a + "��");
							String map = "";// ��ͼ
							String[] arr3 = arrstr[a]
									.split("pic_path\":\"");
							if(arr3[1].indexOf("uprightImg")!=-1){
								map = arr3[1].split("\",\"uprightImg")[0];
							}else if(arr3[1].indexOf("priceWap")!=-1){
								map = arr3[1].split("\",\"priceWap")[0];
							}else {
								map = arr3[1].split("\",\"auctionURL")[0];
								
							}
							System.out.println(map);
							map=map.replace("60x60", "220x220");
							String ztcPicPathSuffix=map.substring(map.indexOf("XXXXXX")-15,map.indexOf("XXXXXX"));
							if(ztc2.equals("0")){
								//���ṩ��ֱͨ����ַ�ͺͻ�ȡ��ͼƬ��ַ�����жϡ�
								if(ztcimgurl != null && !"".equals(ztcimgurl) && !ztcPicPathSuffix.equals(ztcimgurl.substring(ztcimgurl.indexOf("XXXXXX")-15,ztcimgurl.indexOf("XXXXXX")))){
									continue;
								}
									//�����û��ṩ�ı�����ͼ��ַ�ͻ�ȡ����ͼ��ַ�����ж�
								if(ztimgurl != null && !"".equals(ztimgurl) &&  ztimgurl.substring(ztimgurl.indexOf("XXXXXX")-15,ztimgurl.indexOf("XXXXXX")).equals(ztcPicPathSuffix)){
									continue;
								}
							}else{
								/*
								 *�����Ƿ���solar ��ʶ   ���ж��Ƿ�ֱͨ��
								 */
								if(map.indexOf("solar")==-1){
									continue;
								}
							}
							System.out.println("����Ʒ��ֱͨ����Ʒ");
							checkhot = true;
							taobao.setCheckhot(checkhot);
							taobao.setMap(map);// ��ͼ
							taobao.setRanking("��" + ii + "ҳ����" + a + "��");// ����
							break;
						}
					}
					if (taobao.getMap().length() > 1) {
						break;
					}
				}
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	TaoBaoQuery taobaoquery = new TaoBaoQuery();
	taobaoquery.setTaobao(taobao);
	taobaoquery.setKeyword(keyword);
	taobaoquery.setItemId(itemId);
	taobaoquery.setStartPrice(taobao.getStartPrice());
	taobaoquery.setEndPrice(taobao.getEndPrice());
	taobaoquery.setPagecount(pagecount);
	taobaoquery.setCheck(check);
	taobaoquery.setIsSeller(isSeller);
	taobaoquery.setIsGoods(isGoods);
	taobaoquery.setIsFreight(isFreight);
	taobaoquery.setIsPrice(isPrice);
	try {
		Search.getSubImage(taobao.getMap().replace("60x60", "220x220"), path, 91, 41, 25, 100);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return taobaoquery;
	}
	@Test
	public void TestTaoBaomainservice(){
		Ztcservice ztcservice=new Ztcservice();
		/*
		 * ����id��itemId, 
		 * ����ȫ����fullname, 
		 * ��ѯ��ʽsort, 
		 * �ؼ���keyword, 
		 * ��ҳ��pagecount, 
		 * ͼƬ���ɵ�ַ�������ļ�����path
		 * �Ƿ���ֱͨ����ѯ(1��ʾֱͨ����ѯ����check��
		 * ��ͼ۸� startPrice,
		 * ��߼۸� endPrice,
		 * ��ͼ��ַ�� ztimgurl,
		 * ֱͨ��ͼƬ��ַ ztcimgurl,
		 * �Ƿ�ʹ�ü۸�ɸѡ isPrice,
		 * �Ƿ�ʹ�����ҵ���ɸѡisSeller,
		 * �Ƿ�ʹ���Ա���èɸѡ isGoods,
		 * �Ƿ�ʹ���˷���ѡ isFreight
		 *  
		 *  ��ȷ�����߲���Ҫ���ݵ��봫����Ϊ"";
		 * isztc2   0��ʾ��ͼƬ��ַƥ��  ������ʾ�ж�solar
		 * 
		 */
		TaoBaoQuery taoBaomainservice = ztcservice.TaoBaomainservice("523021020320", "", "_coefp", "��װ", "10", "C:\\", "1", "67.0", "69.0", "", "", "0", "0", "1", "1","1");
		TaoBaobean taobao = taoBaomainservice.getTaobao();
	
		System.out.println(taobao.toString());
	}
}
