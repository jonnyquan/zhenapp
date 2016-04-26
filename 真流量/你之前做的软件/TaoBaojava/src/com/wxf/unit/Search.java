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
		String address="http://api.s.m.taobao.com/search.json?vm=nw&search_wap_mall=false&ttid=700169%40taobao_android_5.2.6&search_wap_mall=false&vm=nw&sort=代号天猫&itemfields=distance%2Carea%2CcommentCount&from=input&debug=false&propertyMenu=on&info=wifi&propno=4&style=list&utsid=VRJf9eVH%2B7QDADmC0dFlrCdS_12278902_1436063000856&page=页数&longitude=113.120928&st=1436065504362&deviceId=AvJWeP1bTdZhNzY98JlbpapfaNOcSwzWgtL54SzT6luY&new_shopstar=true&filterEmpty=true&sk=a78ffc12e0d285dbde3f51dae51d12bf&imei=866229026902757&refpid=&end_price=100&sugg=&n=40&setting_on=imgBanners%2Cuserdoc地址&sputips=on&search_action=passive&v=*&referrer=http%3A%2F%2Fm.taobao.com%2Fchannel%2Fact%2Fmobile%2Fhomepage.html&utd_id=VRJf9eVH%2B7QDADmC0dFlrCdS&t=1436065505&filterUnused=true&q=关键词运费&imsi=460029899955362&latitude=23.166734&active_bd=1&appKey=21646297&start_price=最低价";
		if(taobao.getSeller().equals("")){
			address=address.replace("地址","");	
		}else{
			address=address.replace("地址", "&&loc="+URLEncoder.encode(taobao.getSeller(), "UTF-8"));
		}
		if(taobao.getGoods().equals("天猫")){
			address=address.replace("天猫","&tab=mall");	
		}else{
			address=address.replace("天猫", "");
		}
		if(taobao.getFreight().equals("免运费")){
			address=address.replace("运费","&service=myf");	
		}else{
			address=address.replace("运费", "");
		}
		address=address.replace("代号", taobao.getSort());
		address=address.replace("关键词", URLEncoder.encode(taobao.getKeyword(), "UTF-8"));
		address=address.replace("最低价", taobao.getStartPrice());
		address=address.replace("end_price=100", "end_price="+taobao.getEndPrice());
		return address;
	}
	public static String getaddressztc(TaoBaobean taobao,String isSeller,String isGoods,String isFreight,String isPrice,String startPrice,String endPrice) throws Exception{
		String address="http://api.s.m.taobao.com/search.json?vm=nw&search_wap_mall=false&ttid=700169%40taobao_android_5.2.6&search_wap_mall=false&vm=nw&sort=代号天猫&itemfields=distance%2Carea%2CcommentCount&from=input&debug=false&propertyMenu=on&info=wifi&propno=4&style=list&utsid=VRJf9eVH%2B7QDADmC0dFlrCdS_12278902_1436063000856&page=页数&longitude=113.120928&st=1436065504362&deviceId=AvJWeP1bTdZhNzY98JlbpapfaNOcSwzWgtL54SzT6luY&new_shopstar=true&filterEmpty=true&sk=a78ffc12e0d285dbde3f51dae51d12bf&imei=866229026902757&refpid=&end_price=100&sugg=&n=40&setting_on=imgBanners%2Cuserdoc地址&sputips=on&search_action=passive&v=*&referrer=http%3A%2F%2Fm.taobao.com%2Fchannel%2Fact%2Fmobile%2Fhomepage.html&utd_id=VRJf9eVH%2B7QDADmC0dFlrCdS&t=1436065505&filterUnused=true&q=关键词运费&imsi=460029899955362&latitude=23.166734&active_bd=1&appKey=21646297&start_price=最低价";
		if(isSeller.equals("1")){
			address=address.replace("地址","");	
		}else if(isSeller.equals("0")){
			address=address.replace("地址", "&&loc="+URLEncoder.encode(taobao.getSeller(), "UTF-8"));
		}
		if(isGoods.equals("0")){
			address=address.replace("天猫","&tab=mall");	
		}else if(isGoods.equals("1")){
			address=address.replace("天猫", "");
		}
		if(isFreight.equals("0")){
			address=address.replace("运费","&service=myf");	
		}else if(isFreight.equals("1")){
			address=address.replace("运费", "");
		}
		if(isPrice.equals("0")){
			address=address.replace("最低价", taobao.getStartPrice());
			address=address.replace("end_price=100", taobao.getEndPrice());
		}else if(isPrice.equals("1")){
			address=address.replace("最低价", startPrice);
			address=address.replace("end_price=100", endPrice);
		}
		address=address.replace("代号", taobao.getSort());
		address=address.replace("关键词", URLEncoder.encode(taobao.getKeyword(), "UTF-8"));
		
		return address;
	}
	public static void getSubImage2(String url,String toPath,HttpServletRequest request,int x,int y,int w,int h){
		  FileInputStream fis = null ;  
	        ImageInputStream iis =null ;  
	        try{     
	            //读取图片文件   
	            fis = new FileInputStream(url);   
	            Iterator it = ImageIO.getImageReadersByFormatName("jpg");   
	            ImageReader reader = (ImageReader) it.next();   
	            //获取图片流    
	            iis = ImageIO.createImageInputStream(fis);    
	            reader.setInput(iis,true) ;  
	            ImageReadParam param = reader.getDefaultReadParam();   
	            //定义一个矩形   
	            Rectangle rect = new Rectangle(x, y, w, h);   
	            //提供一个 BufferedImage，将其用作解码像素数据的目标。    
	            param.setSourceRegion(rect);  
	            BufferedImage bi = reader.read(0,param);                  
	            //保存新图片    
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
		  //URL url = new URL(fileUrl);/*将网络资源地址传给,即赋值给url*/
          /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
          HttpURLConnection connection = (HttpURLConnection)url.openConnection();
          DataInputStream in = new DataInputStream(connection.getInputStream());
          /*此处也可用BufferedInputStream与BufferedOutputStream*/
          DataOutputStream out = new DataOutputStream(new FileOutputStream(topath+"\\temp.png"));
          /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
          byte[] buffer = new byte[4096];
          int count = 0;
          while ((count = in.read(buffer)) > 0)/*将输入流以字节的形式读取并写入buffer中*/
          {
              out.write(buffer, 0, count);
          }
          out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
          in.close();
          connection.disconnect();
          //------------------------------------------------------------------------------------
          File srcImg=new File(topath+"\\temp.png");
          if(srcImg.exists()){
              java.io.FileInputStream fis = null;
              ImageInputStream iis = null;
              try {
                  fis = new FileInputStream(srcImg);
                  // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                  String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
                  String suffix = null;
                  // 获取图片后缀
                  if(srcImg.getName().indexOf(".") > -1) {
                      suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
                  }// 类型和图片后缀全部小写，然后判断后缀是否合法
                  if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()+",") < 0){
                      System.out.println("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
                      return ;
                  }
                  // 将FileInputStream 转换为ImageInputStream
                  iis = ImageIO.createImageInputStream(fis);
                  // 根据图片类型获取该种类型的ImageReader
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
			  //URL url = new URL(fileUrl);/*将网络资源地址传给,即赋值给url*/
	            /*此为联系获得网络资源的固定格式用法，以便后面的in变量获得url截取网络资源的输入流*/
	            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	            DataInputStream in = new DataInputStream(connection.getInputStream());
	            /*此处也可用BufferedInputStream与BufferedOutputStream*/
	            DataOutputStream out = new DataOutputStream(new FileOutputStream("E:/temp.png"));
	            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
	            byte[] buffer = new byte[4096];
	            int count = 0;
	            while ((count = in.read(buffer)) > 0)/*将输入流以字节的形式读取并写入buffer中*/
	            {
	                out.write(buffer, 0, count);
	            }
	            out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
	            in.close();
	            connection.disconnect();
	            //------------------------------------------------------------------------------------
	            File srcImg=new File("E:/temp.png");
	            if(srcImg.exists()){
	                java.io.FileInputStream fis = null;
	                ImageInputStream iis = null;
	                try {
	                    fis = new FileInputStream(srcImg);
	                    // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
	                    String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]", ",");
	                    String suffix = null;
	                    // 获取图片后缀
	                    if(srcImg.getName().indexOf(".") > -1) {
	                        suffix = srcImg.getName().substring(srcImg.getName().lastIndexOf(".") + 1);
	                    }// 类型和图片后缀全部小写，然后判断后缀是否合法
	                    if(suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()+",") < 0){
	                        System.out.println("Sorry, the image suffix is illegal. the standard image suffix is {}." + types);
	                        return ;
	                    }
	                    // 将FileInputStream 转换为ImageInputStream
	                    iis = ImageIO.createImageInputStream(fis);
	                    // 根据图片类型获取该种类型的ImageReader
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
