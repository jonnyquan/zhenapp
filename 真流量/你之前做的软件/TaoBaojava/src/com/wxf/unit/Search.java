package com.wxf.unit;

import java.awt.AWTEvent;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import com.wxf.bean.TaoBaobean;

public class Search{
	public static StringBuffer getSB(String urlstr) throws Exception{
		URL url=new URL(urlstr);
		StringBuffer sb = new StringBuffer();  
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));  
        String line;  
        while ((line = in.readLine()) != null) {  
                sb.append(line);  
        }  
        in.close();  
        
        return sb;
	}
	
	
	public static String getaddress(TaoBaobean taobao) throws Exception{
		String address="http://api.s.m.taobao.com/search.json?vm=nw&search_wap_mall=false&ttid=700169%40taobao_android_5.2.6&search_wap_mall=false&vm=nw&sort=������è&itemfields=distance%2Carea%2CcommentCount&from=input&debug=false&propertyMenu=on&info=wifi&propno=4&style=list&utsid=VRJf9eVH%2B7QDADmC0dFlrCdS_12278902_1436063000856&page=ҳ��&longitude=113.120928&st=1436065504362&deviceId=AvJWeP1bTdZhNzY98JlbpapfaNOcSwzWgtL54SzT6luY&new_shopstar=true&filterEmpty=true&sk=a78ffc12e0d285dbde3f51dae51d12bf&imei=866229026902757&refpid=&end_price=100&sugg=&n=40&setting_on=imgBanners%2Cuserdoc��ַ&sputips=on&search_action=passive&v=*&referrer=http%3A%2F%2Fm.taobao.com%2Fchannel%2Fact%2Fmobile%2Fhomepage.html&utd_id=VRJf9eVH%2B7QDADmC0dFlrCdS&t=1436065505&filterUnused=true&q=�ؼ����˷�&imsi=460029899955362&latitude=23.166734&active_bd=1&appKey=21646297&start_price=��ͼ�";
		if(taobao.getSeller().equals("")){
			address=address.replace("��ַ","");	
		}else{
			address=address.replace("��ַ", "&&loc="+URLEncoder.encode(taobao.getSeller(), "UTF-8"));
		}
		if(taobao.getGoods().equals("��è")){
			address=address.replace("��è","&tab=mall");	
		}else{
			address=address.replace("��è", "");
		}
		if(taobao.getFreight().equals("���˷�")){
			address=address.replace("�˷�","&service=myf");	
		}else{
			address=address.replace("�˷�", "");
		}
		address=address.replace("����", taobao.getSort());
		address=address.replace("�ؼ���", URLEncoder.encode(taobao.getKeyword(), "UTF-8"));
		address=address.replace("��ͼ�", taobao.getStartPrice());
		address=address.replace("end_price=100", "end_price="+taobao.getEndPrice());
		return address;
	}
	public static String getaddressztc(TaoBaobean taobao,String isSeller,String isGoods,String isFreight,String isPrice,String startPrice,String endPrice) throws Exception{
		String address="http://api.s.m.taobao.com/search.json?vm=nw&search_wap_mall=false&ttid=700169%40taobao_android_5.2.6&search_wap_mall=false&vm=nw&sort=������è&itemfields=distance%2Carea%2CcommentCount&from=input&debug=false&propertyMenu=on&info=wifi&propno=4&style=list&utsid=VRJf9eVH%2B7QDADmC0dFlrCdS_12278902_1436063000856&page=ҳ��&longitude=113.120928&st=1436065504362&deviceId=AvJWeP1bTdZhNzY98JlbpapfaNOcSwzWgtL54SzT6luY&new_shopstar=true&filterEmpty=true&sk=a78ffc12e0d285dbde3f51dae51d12bf&imei=866229026902757&refpid=&end_price=100&sugg=&n=40&setting_on=imgBanners%2Cuserdoc��ַ&sputips=on&search_action=passive&v=*&referrer=http%3A%2F%2Fm.taobao.com%2Fchannel%2Fact%2Fmobile%2Fhomepage.html&utd_id=VRJf9eVH%2B7QDADmC0dFlrCdS&t=1436065505&filterUnused=true&q=�ؼ����˷�&imsi=460029899955362&latitude=23.166734&active_bd=1&appKey=21646297&start_price=��ͼ�";
		if(isSeller.equals("1")){
			address=address.replace("��ַ","");	
		}else if(isSeller.equals("0")){
			address=address.replace("��ַ", "&&loc="+URLEncoder.encode(taobao.getSeller(), "UTF-8"));
		}
		if(isGoods.equals("0")){
			address=address.replace("��è","&tab=mall");	
		}else if(isGoods.equals("1")){
			address=address.replace("��è", "");
		}
		if(isFreight.equals("0")){
			address=address.replace("�˷�","&service=myf");	
		}else if(isFreight.equals("1")){
			address=address.replace("�˷�", "");
		}
		if(isPrice.equals("0")){
			address=address.replace("��ͼ�", taobao.getStartPrice());
			address=address.replace("end_price=100", taobao.getEndPrice());
		}else if(isPrice.equals("1")){
			address=address.replace("��ͼ�", startPrice);
			address=address.replace("end_price=100", endPrice);
		}
		address=address.replace("����", taobao.getSort());
		address=address.replace("�ؼ���", URLEncoder.encode(taobao.getKeyword(), "UTF-8"));
		
		return address;
	}
	public static void getSubImage2(String url,String toPath,HttpServletRequest request,int x,int y,int w,int h){
		  FileInputStream fis = null ;  
	        ImageInputStream iis =null ;  
	        try{     
	            //��ȡͼƬ�ļ�   
	            fis = new FileInputStream(url);   
	            Iterator it = ImageIO.getImageReadersByFormatName("jpg");   
	            ImageReader reader = (ImageReader) it.next();   
	            //��ȡͼƬ��    
	            iis = ImageIO.createImageInputStream(fis);    
	            reader.setInput(iis,true) ;  
	            ImageReadParam param = reader.getDefaultReadParam();   
	            //����һ������   
	            Rectangle rect = new Rectangle(x, y, w, h);   
	            //�ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ    
	            param.setSourceRegion(rect);  
	            BufferedImage bi = reader.read(0,param);                  
	            //������ͼƬ    
	            ImageIO.write(bi, "jpg", new File(toPath));       
	        }catch (Exception e) {
				e.printStackTrace();
			}finally{  
	            if(fis!=null)
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}         
	            if(iis!=null)
					try {
						iis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}   
	        }   
	}
	public static File getSubImage(String url,String topath,int x,int y,int w,int h) throws Exception{
		InputStream is=new URL(url).openStream();
		BufferedImage bi =ImageIO.read(is);
		
		String filePath=topath+"\\temp.png";
		File file=new File(filePath);
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		BufferedImage subImage=bi.getSubimage(x, y, w, h);
		
		ImageIO.write(subImage, "png", file);
		
		return file;
	}
	
	public static void getSubImage3(String destUrl,String topath,int x,int y,int w,int h) throws Exception{
		URL url = new URL(destUrl);  
		  //URL url = new URL(fileUrl);/*��������Դ��ַ����,����ֵ��url*/
          /*��Ϊ��ϵ���������Դ�Ĺ̶���ʽ�÷����Ա�����in�������url��ȡ������Դ��������*/
          HttpURLConnection connection = (HttpURLConnection)url.openConnection();
          DataInputStream in = new DataInputStream(connection.getInputStream());
          /*�˴�Ҳ����BufferedInputStream��BufferedOutputStream*/
          DataOutputStream out = new DataOutputStream(new FileOutputStream(topath+"\\temp.png"));
          /*������savePath��������ȡ��ͼƬ�Ĵ洢�ڱ��ص�ַ��ֵ��out�������ָ���ĵ�ַ*/
          byte[] buffer = new byte[4096];
          int count = 0;
          while ((count = in.read(buffer)) > 0)/*�����������ֽڵ���ʽ��ȡ��д��buffer��*/
          {
              out.write(buffer, 0, count);
          }
          out.close();/*��������Ϊ�ر�����������Լ�������Դ�Ĺ̶���ʽ*/
          in.close();
          connection.disconnect();
          //------------------------------------------------------------------------------------
          File srcImg=new File(topath+"\\temp.png");
          if(srcImg.exists()){
              java.io.FileInputStream fis = null;
              ImageInputStream iis = null;
              try {
                  fis = new FileInputStream(srcImg);
                  // ImageIO ֧�ֵ�ͼƬ���� : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                  String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
                  String suffix = null;
                  // ��ȡͼƬ��׺
                  if(srcImg.getName().indexOf(".") > -1) {
                      suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
                  }// ���ͺ�ͼƬ��׺ȫ��Сд��Ȼ���жϺ�׺�Ƿ�Ϸ�
                  if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()+",") < 0){
                      System.out.println("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                      return ;
                  }
                  // ��FileInputStream ת��ΪImageInputStream
                  iis = ImageIO.createImageInputStream(fis);
                  // ����ͼƬ���ͻ�ȡ�������͵�ImageReader
                  ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
                  reader.setInput(iis,true);
                  ImageReadParam param = reader.getDefaultReadParam();
                  param.setSourceRegion(new java.awt.Rectangle( x, y, w,h));
                  BufferedImage bi = reader.read(0, param);
                  FileOutputStream ops=new FileOutputStream(new File(topath+"\\temp2.png"));
                  
                  ImageIO.write(bi, suffix, ops);
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              } finally {
                  try {
                      if(fis != null) fis.close();
                      if(iis != null) iis.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }else {
              System.out.println("the src image is not exist.");
          }
	}

		 public static void main(String []args) throws Exception{
		//	(new Search()).getSubImage("http://g.search2.alicdn.com/img/bao/uploaded/i4/i1/TB1OffnKFXXXXckXXXXXXXXXXXX_!!2-item_pic.png_220x220.jpg", "", 0, 0, 0, 0);
			 URL url = new URL("http://g.search2.alicdn.com/img/bao/uploaded/i4/i1/TB1OffnKFXXXXckXXXXXXXXXXXX_!!2-item_pic.png_220x220.jpg");  
			  //URL url = new URL(fileUrl);/*��������Դ��ַ����,����ֵ��url*/
	            /*��Ϊ��ϵ���������Դ�Ĺ̶���ʽ�÷����Ա�����in�������url��ȡ������Դ��������*/
	            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	            DataInputStream in = new DataInputStream(connection.getInputStream());
	            /*�˴�Ҳ����BufferedInputStream��BufferedOutputStream*/
	            DataOutputStream out = new DataOutputStream(new FileOutputStream("E:/temp.png"));
	            /*������savePath��������ȡ��ͼƬ�Ĵ洢�ڱ��ص�ַ��ֵ��out�������ָ���ĵ�ַ*/
	            byte[] buffer = new byte[4096];
	            int count = 0;
	            while ((count = in.read(buffer)) > 0)/*�����������ֽڵ���ʽ��ȡ��д��buffer��*/
	            {
	                out.write(buffer, 0, count);
	            }
	            out.close();/*��������Ϊ�ر�����������Լ�������Դ�Ĺ̶���ʽ*/
	            in.close();
	            connection.disconnect();
	            //------------------------------------------------------------------------------------
	            File srcImg=new File("E:/temp.png");
	            if(srcImg.exists()){
	                java.io.FileInputStream fis = null;
	                ImageInputStream iis = null;
	                try {
	                    fis = new FileInputStream(srcImg);
	                    // ImageIO ֧�ֵ�ͼƬ���� : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
	                    String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
	                    String suffix = null;
	                    // ��ȡͼƬ��׺
	                    if(srcImg.getName().indexOf(".") > -1) {
	                        suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
	                    }// ���ͺ�ͼƬ��׺ȫ��Сд��Ȼ���жϺ�׺�Ƿ�Ϸ�
	                    if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()+",") < 0){
	                        System.out.println("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
	                        return ;
	                    }
	                    // ��FileInputStream ת��ΪImageInputStream
	                    iis = ImageIO.createImageInputStream(fis);
	                    // ����ͼƬ���ͻ�ȡ�������͵�ImageReader
	                    ImageReader reader = ImageIO.getImageReadersBySuffix(suffix).next();
	                    reader.setInput(iis,true);
	                    ImageReadParam param = reader.getDefaultReadParam();
	                    param.setSourceRegion(new java.awt.Rectangle( 91, 41, 25, 100));
	                    BufferedImage bi = reader.read(0, param);
	                    FileOutputStream ops=new FileOutputStream(new File("E:/temp2.png"));
	                    
	                    ImageIO.write(bi, suffix, ops);
	                } catch (FileNotFoundException e) {
	                    e.printStackTrace();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } finally {
	                    try {
	                        if(fis != null) fis.close();
	                        if(iis != null) iis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }else {
	                System.out.println("the src image is not exist.");
	            }
		 }
}
