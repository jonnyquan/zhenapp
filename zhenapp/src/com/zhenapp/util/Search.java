package com.zhenapp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Search {
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
}
