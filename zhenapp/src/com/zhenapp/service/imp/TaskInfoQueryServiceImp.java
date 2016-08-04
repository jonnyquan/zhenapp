package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTaskInfoQueryCustomMapper;
import com.zhenapp.po.Custom.TTaskInfoQueryCustom;
import com.zhenapp.service.TaskInfoQueryService;
@Service
public class TaskInfoQueryServiceImp implements TaskInfoQueryService {

	@Autowired
	private TTaskInfoQueryCustomMapper tTaskInfoQueryCustomMapper;
	
	@Override
	public int saveTaskInfo(TTaskInfoQueryCustom tTaskInfoQueryCustom) throws Exception {
		
		return tTaskInfoQueryCustomMapper.saveTaskInfo(tTaskInfoQueryCustom);
	}

	@Override
	public List<TTaskInfoQueryCustom> findTaskInfo(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoQueryCustomMapper.findTaskInfo(hashmap);
	}

	@Override
	public List<TTaskInfoQueryCustom> findTaskInfoByMap(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoQueryCustomMapper.findTaskInfoByMap(hashmap);
	}

	@Override
	public int updateTaskInfo(HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoQueryCustomMapper.updateTaskInfo(hashmap);
	}

	@Override
	public int updateTaskInfoState(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoQueryCustomMapper.updateTaskInfoState(hashmap);
	}

	@Override
	public int findTotalTaskInfoByMap(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoQueryCustomMapper.findTotalTaskInfoByMap(hashmap);
	}
	
}
