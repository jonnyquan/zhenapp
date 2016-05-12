package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTaskDetailinfoCustomMapper;
import com.zhenapp.po.Custom.TTaskDetailInfoCustom;
import com.zhenapp.service.TaskDetailInfoService;

@Service
public class TaskDetailInfoServiceImp implements TaskDetailInfoService {
	@Autowired
	private TTaskDetailinfoCustomMapper tTaskDetailinfoCustomMapper;
	@Override
	public int insertDetailinfo(TTaskDetailInfoCustom tTaskDetailInfoCustom)
			throws Exception {
		return tTaskDetailinfoCustomMapper.insertDetailinfo(tTaskDetailInfoCustom);
	}
	@Override
	public TTaskDetailInfoCustom requesttaskByphoneid(String phoneid)
			throws Exception {
		return tTaskDetailinfoCustomMapper.requesttaskByphoneid(phoneid);
	}
	@Override
	public int updateTaskDetailstate(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.updateTaskDetailstate(hashmap);
	}
	@Override
	public int updateterminationstate(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.updateterminationstate(hashmap);
	}
	@Override
	public int findPointsByteterminationstate(String taskid) throws Exception {
		return tTaskDetailinfoCustomMapper.findPointsByteterminationstate(taskid);
	}
	@Override
	public TTaskDetailInfoCustom findTaskDetailByPidAndState(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByPidAndState(hashmap);
	}
	@Override
	public int updateTaskDetailByPidAndState(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoCustomMapper.updateTaskDetailByPidAndState(hashmap);
	}
	@Override
	public List<TTaskDetailInfoCustom> findTaskDetailByPage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoCustomMapper.findTaskDetailByPage(hashmap);
	}
	@Override
	public int findTaskDetailTotalByPage(
			HashMap<String, Object> hashmap) throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoCustomMapper.findTaskDetailTotalByPage(hashmap);
	}
}
