package com.zhenapp.mapper.Custom;

import com.zhenapp.po.TWebInfo;
import com.zhenapp.po.Custom.TWebInfoCustom;

public interface TWebInfoCustomMapper {
   
    TWebInfo selectByPrimaryKey(Integer webpk);

    TWebInfoCustom findWebBywebwww(String webwww);

}