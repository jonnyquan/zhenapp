package com.zhenapp.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.zhenapp.po.TElectricityInfo;

public class TextImprot {
	
	public List<TElectricityInfo> improt() throws Exception{
		List<TElectricityInfo> listTElectricityInfo=new ArrayList<TElectricityInfo>();
		String filepath="C:\\liuliangcun";
		File file =new File(filepath);
        if (!file.isDirectory()) {
                System.out.println("文件");
        } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                        File readfile = new File(filepath + "\\" + filelist[i]);
                        if (!readfile.isDirectory()) {
                                //System.out.println("path=" + readfile.getPath());
                                //System.out.println("absolutepath=" + readfile.getAbsolutePath());
                                System.out.println("name=" + readfile.getName());
                                FileInputStream in = new FileInputStream(readfile);
                                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                                String str="";
                                String line = br.readLine();  
                                while(line != null) {
                                	line = br.readLine();
                                	str=str+line;
                                }
                                System.out.println(str.trim());
                                TElectricityInfo tElectricityInfo=new TElectricityInfo();
                                tElectricityInfo.setElectricitypk(i);
                                tElectricityInfo.setElectricityid(i);
                                tElectricityInfo.setElectricityname(readfile.getName().replace(".txt", ""));
                                tElectricityInfo.setElectricitytext(str.trim());
                                listTElectricityInfo.add(tElectricityInfo);
                                /*
                                BufferedWriter bw;
                                BufferedReader bf=null;
                                File fout = new File("D:\\123.txt");
                                PrintWriter pw = new PrintWriter(fout);
                                String line1 = str.trim();
                                pw.println(line1);
                                pw.close();
                                pw=null;
                                */
                        } else if (readfile.isDirectory()) {
                                System.out.println("文件夹");
                        }
                }
        }
        return listTElectricityInfo;
	}
}
