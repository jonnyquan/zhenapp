package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TRechargeInfoCustomMapper;
import com.zhenapp.po.Custom.TRechargeInfoCustom;
import com.zhenapp.service.RechargeInfoService;

@Service
public class RechargeInfoServiceImp implements RechargeInfoService{
	@Autowired
	private TRechargeInfoCustomMapper tRechargeInfoCustomMapper;
	
	@Override
	public List<TRechargeInfoCustom> findRechargeinfoByUser(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findRechargeinfoByUser(hashmap);
	}

	@Override
	public int insertRechargeinfo(TRechargeInfoCustom tRechargeInfoCustom)
			throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.insertRechargeinfo(tRechargeInfoCustom);
	}

	@Override
	public int deleteRechargeinfoByid(String rechargeids) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.deleteRechargeinfoByid(rechargeids);
	}

	@Override
	public List<TRechargeInfoCustom> findRechargeinfoByUserAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findRechargeinfoByUserAndpage(hashmap);
	}

	@Override
	public int findTotalRechargeinfoByUserAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findTotalRechargeinfoByUserAndpage(hashmap);
	}

	@Override
	public int updateRechargestate(String verificationcode) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.updateRechargestate(verificationcode);
	}

	@Override
	public TRechargeInfoCustom findRechargeBycode(String verificationcode)
			throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findRechargeBycode(verificationcode);
	}

	@Override
	public int findTotalRechargeinfoByRoleAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findTotalRechargeinfoByRoleAndpage(hashmap);
	}

	@Override
	public List<TRechargeInfoCustom> findRechargeinfoByRoleAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tRechargeInfoCustomMapper.findRechargeinfoByRoleAndpage(hashmap);
	}

}
