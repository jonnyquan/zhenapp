package com.zhenapp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.zhenapp.po.TElectricityInfo;

public class TextImprot {
	
	public List<TElectricityInfo> improt() throws Exception{
		List<TElectricityInfo> listTElectricityInfo=new ArrayList<TElectricityInfo>();
		String filepath="D:\\liuliangcun";
		File file =new File(filepath);
        if (!file.isDirectory()) {
                System.out.println("文件");
        } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                        File readfile = new File(filepath + "\\" + filelist[i]);
                        if (!readfile.isDirectory()) {
                                System.out.println("name=" + readfile.getName());
                                Reader reader = new InputStreamReader(new FileInputStream(readfile));
                                String str="";
                                int tempchar;
                                while ((tempchar = reader.read()) != -1) {
                                    // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                                    // 但如果这两个字符分开显示时，会换两次行。
                                    // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                                    if (((char) tempchar) != '\r') {
                                        str=str+(char) tempchar;
                                    }
                                }
                                reader.close();
                                
                                System.out.println(str.trim());
                                TElectricityInfo tElectricityInfo=new TElectricityInfo();
                                tElectricityInfo.setElectricityid(i);
                                tElectricityInfo.setElectricityname(readfile.getName().replace(".txt", ""));
                                tElectricityInfo.setElectricitytext(str.trim());
                                listTElectricityInfo.add(tElectricityInfo);
                        } else if (readfile.isDirectory()) {
                                System.out.println("文件夹");
                        }
                }
        }
        return listTElectricityInfo;
	}
}
