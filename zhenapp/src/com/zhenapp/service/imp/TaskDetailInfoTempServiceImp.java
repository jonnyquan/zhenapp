package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTaskDetailinfoTempCustomMapper;
import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;
import com.zhenapp.service.TaskDetailInfoTempService;

@Service
public class TaskDetailInfoTempServiceImp implements TaskDetailInfoTempService {
	@Autowired
	private TTaskDetailinfoTempCustomMapper TTaskDetailinfoTempCustomMapper;

	@Override
	public int insertDetailinfo(TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom)throws Exception {
		return TTaskDetailinfoTempCustomMapper.insertDetailinfo(tTaskDetailinfoTempCustom);
	}
	@Override
	public TTaskDetailinfoTempCustom findTTaskDetailinfoTempByphoneid(
			HashMap<String, Object> hashmap) throws Exception {
		return TTaskDetailinfoTempCustomMapper.findTTaskDetailinfoTempByphoneid(hashmap);
	}
	@Override
	public int deletetaskDetailInfoTemp(HashMap<String, Object> hashmap)
			throws Exception {
		return TTaskDetailinfoTempCustomMapper.deletetaskDetailInfoTemp(hashmap);
	}
	@Override
	public int updatestate(HashMap<String, Object> hashmap) throws Exception {
		return TTaskDetailinfoTempCustomMapper.updatestate(hashmap);
	}
	@Override
	public List<TTaskDetailinfoTempCustom> findtaskkeynumlist(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return TTaskDetailinfoTempCustomMapper.findtaskkeynumlist(hashmap);
	}
}
