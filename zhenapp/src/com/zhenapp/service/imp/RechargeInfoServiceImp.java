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
		return tRechargeInfoCustomMapper.findRechargeinfoByUser(hashmap);
	}

	@Override
	public int insertRechargeinfo(TRechargeInfoCustom tRechargeInfoCustom)
			throws Exception {
		return tRechargeInfoCustomMapper.insertRechargeinfo(tRechargeInfoCustom);
	}

	@Override
	public int deleteRechargeinfoByid(String rechargeids) throws Exception {
		return tRechargeInfoCustomMapper.deleteRechargeinfoByid(rechargeids);
	}

	@Override
	public List<TRechargeInfoCustom> findRechargeinfoByUserAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		return tRechargeInfoCustomMapper.findRechargeinfoByUserAndpage(hashmap);
	}

	@Override
	public int findTotalRechargeinfoByUserAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		return tRechargeInfoCustomMapper.findTotalRechargeinfoByUserAndpage(hashmap);
	}

	@Override
	public int updateRechargestate(HashMap<String, Object> hashmap) throws Exception {
		return tRechargeInfoCustomMapper.updateRechargestate(hashmap);
	}

	@Override
	public TRechargeInfoCustom findRechargeBycode(String verificationcode)
			throws Exception {
		return tRechargeInfoCustomMapper.findRechargeBycode(verificationcode);
	}

	@Override
	public int findTotalRechargeinfoByRoleAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		return tRechargeInfoCustomMapper.findTotalRechargeinfoByRoleAndpage(hashmap);
	}

	@Override
	public List<TRechargeInfoCustom> findRechargeinfoByRoleAndpage(
			HashMap<String, Object> hashmap) throws Exception {
		return tRechargeInfoCustomMapper.findRechargeinfoByRoleAndpage(hashmap);
	}

}
