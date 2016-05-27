package com.zhenapp.service.imp;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTaskDetailinfoFlowCustomMapper;
import com.zhenapp.po.Custom.TTaskDetailInfoFlowCustom;
import com.zhenapp.service.TaskDetailInfoFlowService;

@Service
public class TaskDetailInfoFlowServiceImp implements TaskDetailInfoFlowService {

	@Autowired
	private TTaskDetailinfoFlowCustomMapper tTaskDetailinfoFlowCustomMapper;
	
	@Override
	public int insertTaskDetailInfoFlow(TTaskDetailInfoFlowCustom tTaskDetailInfoFlowCustom) throws Exception {
		return tTaskDetailinfoFlowCustomMapper.insertTaskDetailInfoFlow(tTaskDetailInfoFlowCustom);
	}

	@Override
	public int updateTaskdetailIdByPk(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoFlowCustomMapper.updateTaskdetailIdByPk(hashmap);
	}

	@Override
	public int updateTaskstate(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoFlowCustomMapper.updateTaskstate(hashmap);
	}

	@Override
	public TTaskDetailInfoFlowCustom findTaskdetailInfo(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoFlowCustomMapper.findTaskdetailInfo(hashmap);
	}

	@Override
	public int updatefinishcount(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoFlowCustomMapper.updatefinishcount(hashmap);
	}
	
}
