package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenapp.mapper.Custom.TTaskInfoCustomMapper;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;
@Service
public class TaskInfoServiceImp implements TaskInfoService {
	
	@Autowired
	private TTaskInfoCustomMapper tTaskInfoCustomMapper;
	
	@Override
	public int insertTaskInfo(TTaskInfoCustom tTaskInfoCustom) throws Exception {
		return tTaskInfoCustomMapper.insertTaskInfo(tTaskInfoCustom);
	}

	@Override
	public List<TTaskInfoCustom> findTaskBypage(HashMap<String, Object> hashmap)
			throws Exception {
		return tTaskInfoCustomMapper.findTaskBypage(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findAllTaskBypage(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findAllTaskBypage(hashmap);
	}

	@Override
	public void deleteTaskBypk(String taskpk) throws Exception {
		tTaskInfoCustomMapper.deleteTaskBypk(taskpk);
	}

	@Override
	public List<TTaskInfoCustom> findTaskallocation(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findTaskallocation(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findIsFirst(String taskkeynum) throws Exception {
		return tTaskInfoCustomMapper.findIsFirst(taskkeynum);
	}

	@Override
	public int updateTaskstate(HashMap<String,Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.updateTaskstate(hashmap);
	}

	@Override
	public int findTotalTaskBypage(HashMap<String, Object> hashmap)
			throws Exception {
		return tTaskInfoCustomMapper.findTotalTaskBypage(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findTaskBypageAndrole(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findTaskBypageAndrole(hashmap);
	}

	@Override
	public int findTotalTaskBypageAndrole(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findTotalTaskBypageAndrole(hashmap);
	}

	@Override
	public TTaskInfoCustom findTaskInfoByTaskid(String taskid) throws Exception {
		return tTaskInfoCustomMapper.findTaskInfoByTaskid(taskid);
	}

	@Override
	public List<TTaskInfoCustom> findTaskInfoByTaskstate(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findTaskInfoByTaskstate(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findTaskInfoBypks(String pks) throws Exception {
		return tTaskInfoCustomMapper.findTaskInfoBypks(pks);
	}

	@Override
	public List<TTaskInfoCustom> findTaskerrorcounts(HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findTaskerrorcounts(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findEndTaskfordel(
			HashMap<String, Object> hashmap) throws Exception {
		return tTaskInfoCustomMapper.findEndTaskfordel(hashmap);
	}

	@Override
	public int updatedeepclick(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoCustomMapper.updatedeepclick(hashmap);
	}

	@Override
	public List<TTaskInfoCustom> findAllocation(HashMap<String, Object> hashmap)
			throws Exception {
		// TODO Auto-generated method stub
		return tTaskInfoCustomMapper.findAllocation(hashmap);
	}

}
