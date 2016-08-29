package com.zhenapp.mapper.Custom;

import java.util.HashMap;
import java.util.List;

import com.zhenapp.po.Custom.TTaskDetailinfoTempCustom;

public interface TTaskDetailinfoTempCustomMapper {
	public int deleteDate(HashMap<String, Object> hashmap) throws Exception;
	//保存详情任务临时信息
	public int insertDetailinfo(TTaskDetailinfoTempCustom tTaskDetailinfoTempCustom) throws Exception;
	//根据手机号查询详情任务临时信息
	public TTaskDetailinfoTempCustom findTTaskDetailinfoTempByphoneid(HashMap<String, Object> hashmap) throws Exception;
	//根据条件删除详情任务的临时信息
	public int deletetaskDetailInfoTemp(HashMap<String, Object> hashmap) throws Exception;
	//根据条件修改详情任务临时信息的状态
	public int updatestate(HashMap<String, Object> hashmap) throws Exception;
	//根据手机号查询某一日期做过的任务类型的宝贝id
	public List<TTaskDetailinfoTempCustom> findtaskkeynumlist(HashMap<String, Object> hashmap) throws Exception;
	//根据手机号查询某一日期做过的任务类型的宝贝id
	public List<TTaskDetailinfoTempCustom> findtaskkeynumlistll(HashMap<String, Object> hashmap) throws Exception;
	//分页查询详情任务临时信息
	public List<TTaskDetailinfoTempCustom> findallocation (HashMap<String, Object> hashmap) throws Exception;
	//分页查询详情任务临时信息
	public int findTotalallocation (HashMap<String, Object> hashmap) throws Exception;
}