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
	public TTaskDetailInfoCustom requesttaskByphoneid(HashMap<String, Object> hashmap)
			throws Exception {
		return tTaskDetailinfoCustomMapper.requesttaskByphoneid(hashmap);
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
	public TTaskDetailInfoCustom findTaskDetailByPidAndState( HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByPidAndState(hashmap);
	}
	@Override
	public int updateTaskDetailByPidAndState(HashMap<String, Object> hashmap)
			throws Exception {
		return tTaskDetailinfoCustomMapper.updateTaskDetailByPidAndState(hashmap);
	}
	@Override
	public List<TTaskDetailInfoCustom> findTaskDetailByPage( HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByPage(hashmap);
	}
	@Override
	public int findTaskDetailTotalByPage( HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailTotalByPage(hashmap);
	}
	@Override
	public int updateTaskDetailstateByTaskidAndoldstate(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.updateTaskDetailstateByTaskidAndoldstate(hashmap);
	}
	@Override
	public List<TTaskDetailInfoCustom> findTaskDetailByflow() throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByflow();
	}
	@Override
	public TTaskDetailInfoCustom findTaskDetailBypk(String taskdetailpk) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailBypk(taskdetailpk);
	}
	@Override
	public int findTaskDetailByIdAndtask(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByIdAndtask(hashmap);
	}
	@Override
	public int findTaskDetailInfoByIdAndTaskstate(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailInfoByIdAndTaskstate(hashmap);
	}
	@Override
	public int deleteTaskBystate(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.deleteTaskBystate(hashmap);
	}
	@Override
	public List<TTaskDetailInfoCustom> findTaskDetailByProblemAndPage(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTaskDetailByProblemAndPage(hashmap);
	}
	@Override
	public int findTotalTaskDetailByProblemAndPage(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findTotalTaskDetailByProblemAndPage(hashmap);
	}
	@Override
	public int findCounts(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findCounts(hashmap);
	}
	@Override
	public int findshoppingcount(HashMap<String, Object> hashmap)throws Exception {
		return tTaskDetailinfoCustomMapper.findshoppingcount(hashmap);
	}
	@Override
	public int findcollectioncount(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findcollectioncount(hashmap);
	}
	@Override
	public int updateTaskDetail(HashMap<String, Object> hashmap)throws Exception {
		return tTaskDetailinfoCustomMapper.updateTaskDetail(hashmap);
	}
	@Override
	public int updateTaskDetailresultByid(HashMap<String, Object> hashmap)throws Exception {
		return tTaskDetailinfoCustomMapper.updateTaskDetailresultByid(hashmap);
	}
	@Override
	public List<TTaskDetailInfoCustom> findtaskdatacount(HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.findtaskdatacount(hashmap);
	}
	@Override
	public TTaskDetailInfoCustom findtaskdatasum(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskDetailinfoCustomMapper.findtaskdatasum(hashmap);
	}
	@Override
	public TTaskDetailInfoCustom requesttaskByphoneid_temp(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskDetailinfoCustomMapper.requesttaskByphoneid_temp(hashmap);
	}
	@Override
	public int findcountEndstate(String taskid) throws Exception {
		return tTaskDetailinfoCustomMapper.findcountEndstate(taskid);
	}
}
