package com.zhenapp.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhenapp.mapper.TTaskInfoMapper;
import com.zhenapp.mapper.Custom.TTaskInfoCustomMapper;
import com.zhenapp.po.TTaskInfo;
import com.zhenapp.po.Custom.TTaskInfoCustom;
import com.zhenapp.service.TaskInfoService;

public class TaskInfoServiceImp implements TaskInfoService {
	@Autowired
	private TTaskInfoMapper tTaskInfoMapper; 
	@Autowired
	private TTaskInfoCustomMapper tTaskInfoCustomMapper;
	
	@Override
	public int insertTask(TTaskInfo tTaskInfo) throws Exception {
		return tTaskInfoMapper.insert(tTaskInfo);
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
	public void deleteTaskBypk(Integer taskpk) throws Exception {
		tTaskInfoMapper.deleteByPrimaryKey(taskpk);
	}

}
