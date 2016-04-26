package com.wxf.service;

import org.junit.Test;

import com.wxf.bean.TaoBaoQuery;
import com.wxf.bean.TaoBaobean;
import com.wxf.unit.Search;
import com.wxf.unit.Taobaosearch;

public class TaoBaoservice {
	public TaoBaoQuery TaoBaomainservice(String itemId, String fullname,
			String sort, String keyword, String pagecount, String path) {
		boolean checkhot = false;
		StringBuffer SB = new StringBuffer();
		TaoBaobean taobao = new TaoBaobean();
		try {
			SB = Search.getSB("http://hws.m.taobao.com/cache/wdetail/5.0/?id="
					+ itemId);
			String[] arr1 = SB.toString().split(",\"title\":\"");
			if (arr1.length > 0) {
				String[] arr2 = arr1[1].split("\",\"picsPath\":");
				fullname = arr2[0];
				taobao = Taobaosearch.search(fullname, itemId);
				taobao.setFullname(fullname);
				taobao.setSort(sort);
				taobao.setKeyword(keyword);
				taobao.setStartPrice(taobao.getPrice().equals("") ? ""
						: (Double.parseDouble(taobao.getPrice()) - 1) + "");
				taobao.setEndPrice(taobao.getPrice().equals("") ? "" : (Double
						.parseDouble(taobao.getPrice()) + 1)
						+ "");
				if (fullname.equals("")) {
					return null;
				}
				if (taobao.getSeller().equals("")) {
					String[] arr4 = SB.toString().split("location\":\"");
					String seller = arr4[1].split("\",\"price")[0];// ���ҵ���
					taobao.setSeller(seller.substring(3, 5));
				}
				/*String address = Search.getaddress(taobao);

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
								String shortname = "";// ������
								String price = "";// �Żݼ۸�
								//String map = "";// ��ͼ
								String seller = "";// ���ҵ���
								String oldprice = "";// ԭ�۸�
								String sales = "";// ����
								String freight = "";// �˷�
								String goods = "";// ��Ʒ
								String auctionURL = "";// ���̷��ʵ�ַ
								String commentCount = "";// ������
								String ztc = "";// ֱͨ��
								String[] arr11 = arrstr[a].split("title\":\"");
								shortname = arr11[1].split("\",\"sameCount")[0];
								String[] arr22 = arrstr[a]
										.split("priceWithRate\":\"");
								if(arr22.length>1){
								price = arr22[1].split("\",\"pic_path")[0];}
								String[] arr3 = arrstr[a]
										.split("pic_path\":\"");
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
								String[] arr4 = arrstr[a]
										.split("location\":\"");
								seller = arr4[1].split("\",\"price")[0];// ���ҵ���
								String[] arr5 = arrstr[a].split("price\":\"");
								oldprice = arr5[1].split("\",\"priceColor")[0];// ԭ�۸�
								String[] arr7 = arrstr[a]
										.split("shipping\":\"");
								freight = arr7[1].split("\",\"ratesum")[0];// �˷�
								String[] arr8 = arrstr[a]
										.split("auctionURL\":\"");
								auctionURL = arr8[1].split("\",\"type")[0];// ���ʵ�ַ
								String[] arr10 = arrstr[a]
										.split("commentCount\":\"");
								commentCount = arr10[1]
										.split("\",\"ordinaryPostFee")[0];// ������
								String[] arr13 = arrstr[a]
										.split("iconList\":\"");
								ztc = arr13[1].split("\",\"uniqpid")[0];// ֱͨ��

								goods = "�Ա�";// ��Ʒ
								if (arrstr[a].contains("tmall,xxpf,xfbug")) {
									goods = "��è";
								}
								if (freight.equals("")) {
									String[] arr12 = arrstr[a]
											.split("ordinaryPostFee\":\"");
									freight = arr12[1].split("\",\"distance")[0];
								}
								if (freight.equals("")) {
									String[] arr12 = arrstr[a]
											.split("fastPostFee\":\"");
									freight = arr12[1].split("\",\"title")[0];
								}
								if (price.equals("")) {
									price = oldprice;
								}
								if (seller.equals("")) {
									String[] arr12 = arrstr[a]
											.split("sellerLoc\":\"");
									freight = arr12[1]
											.split("\",\"fastPostFee")[0];
								}
								if (freight.equals("0.00")) {
									freight = "���˷�";
								}
								if (ztc.indexOf("p4p") != -1) {
									checkhot = true;
								}
								taobao.setCheckhot(checkhot);
								taobao.setShortname(shortname);// ������
								taobao.setPrice(price);// �Żݼ۸�
								//taobao.setMap(map);// ��ͼ
								taobao.setSeller(seller.length() > 3 ? seller
										.substring(3, 5) : seller);// ���ҵ���
								taobao.setOldprice(oldprice);// ԭ�۸�
								taobao.setSales(sales);// ����
								taobao.setFreight(freight);// �˷�
								taobao.setGoods(goods);// ��Ʒ
								taobao.setAuctionURL(auctionURL);// ���ʵ�ַ
								taobao.setCommentCount(commentCount);// ������
								taobao.setRanking("��" + ii + "ҳ����" + a + "��");// ����

								break;
							}
						}
						if (taobao.getRanking().length() > 1) {
							break;
						}
					}
				}*/
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
		try {
			System.out.println(path);
			Search.getSubImage(taobao.getMap().replace("60x60", "220x220"),path, 91, 41, 25, 100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taobaoquery;
	}
	@Test
	public void TestTaoBaomainservice(){
		TaoBaoservice taobaoservice=new TaoBaoservice();
		/*
		 * ����id��itemId, 
		 * ����ȫ����fullname, 
		 * ��ѯ��ʽsort, 
		 * �ؼ���keyword, 
		 * ��ҳ��pagecount, 
		 * ͼƬ���ɵ�ַ�������ļ�����path
		 * 
		 */
		System.out.println(taobaoservice.TaoBaomainservice("42369515833", "", "_coefp", "��װ", "10", "C:\\"));
	}
}
