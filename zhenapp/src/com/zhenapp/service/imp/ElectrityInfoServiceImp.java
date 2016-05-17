package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.TElectricityInfoMapper;
import com.zhenapp.mapper.Custom.TElectricityInfoCustomMapper;
import com.zhenapp.po.TElectricityInfo;
import com.zhenapp.po.Custom.TelectricityCustom;
import com.zhenapp.service.ElectrityInfoService;

@Service
public class ElectrityInfoServiceImp  implements ElectrityInfoService{
	@Autowired
	private TElectricityInfoMapper tElectricityInfoMapper; 
	@Autowired
	private TElectricityInfoCustomMapper tElectricityInfoCustomMapper;
	
	public int insertElectrity(TElectricityInfo electricityInfo) throws Exception{
		return tElectricityInfoMapper.insert(electricityInfo);
	}

	@Override
	public List<TelectricityCustom> findElectrity_10() throws Exception {
		
		return tElectricityInfoCustomMapper.findElectrity_10();
	}

	@Override
	public List<TelectricityCustom> findAllElectrity() throws Exception {
		// TODO Auto-generated method stub
		return tElectricityInfoCustomMapper.findAllElectrity();
	}

	@Override
	public TelectricityCustom findElectrityBypk(String electricitypk)
			throws Exception {
		// TODO Auto-generated method stub
		return tElectricityInfoCustomMapper.findElectrityBypk(electricitypk);
	}

	@Override
	public List<TelectricityCustom> findElectrityBypage(HashMap<String,Object> pagemap) throws Exception {
		// TODO Auto-generated method stub
		return tElectricityInfoCustomMapper.findElectrityBypage(pagemap);
	}

	@Override
	public int updateElectrityById(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tElectricityInfoCustomMapper.updateElectrityById(hashmap);
	}

	@Override
	public int deleteById(HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tElectricityInfoCustomMapper.deleteById(hashmap);
	}
}
