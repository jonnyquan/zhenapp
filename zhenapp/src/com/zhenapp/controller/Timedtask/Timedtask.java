package com.zhenapp.controller.Timedtask;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhenapp.controller.TaskInfoQuery.DeleteTaskQueryController;
import com.zhenapp.controller.TaskInfoQuery.TaskInfoQueryController;
import com.zhenapp.controller.TaskInfoQuery.UpdateTaskInfoQueryStateController;
import com.zhenapp.controller.TaskInfoQuery.UpdateTaskInfoQueryllController;
import com.zhenapp.controller.TaskInfoQuery.UpdateTaskInfoQueryztcController;
import com.zhenapp.controller.apitest.CheckTaskallocationll;
import com.zhenapp.controller.apitest.CheckTaskallocationztc;
import com.zhenapp.controller.apitest.Taskallocationll;
import com.zhenapp.controller.apitest.Taskallocationztc;
import com.zhenapp.controller.publishinterface.DeleteEndOrder;

@Component(value="/Timedtask")
public class Timedtask {
	private static Logger logger = Logger.getLogger(Timedtask.class);
	@Autowired
	private CheckEndOrderll checkEndOrderll;
	@Autowired
	private CheckEndOrderztc checkEndOrderztc;
	@Autowired
	private DeleteEndOrder deleteEndOrder;
	@Autowired
	private CheckFinshOrderByZtc checkFinshOrderByZtc;
	@Autowired
	private CheckFinshOrderByll checkFinshOrderByll;
	@Autowired
	private CheckErrorll checkErrorll;
	@Autowired
	private CheckErrorztcTask checkErrorztcTask;
	@Autowired
	private AllocationTask allocationTask;
	@Autowired
	private AllocationZtcTask allocationZtcTask;
	@Autowired
	private CheckBeforeOrderll checkBeforeOrderll;
	@Autowired
	private CheckBeforeOrderztc checkBeforeOrderztc;
	@Autowired
	private CheckBeforeOrderEnd checkBeforeOrderEnd;
	@Autowired
	private Taskallocationll taskallocationll;
	@Autowired
	private Taskallocationztc taskallocationztc;
	@Autowired
	private TaskInfoQueryController taskInfoQueryController;
	@Autowired
	private UpdateTaskInfoQueryllController updateTaskInfoQueryllController;
	@Autowired
	private UpdateTaskInfoQueryztcController updateTaskInfoQueryztcController;
	@Autowired
	private UpdateTaskInfoQueryStateController updateTaskInfoQueryStateController;
	@Autowired
	private CheckTaskallocationll checkTaskallocationll;
	@Autowired
	private CheckTaskallocationztc checkTaskallocationztc;
	@Autowired
	private InsertDate insertDate;
	@Autowired
	private DeleteTaskQueryController deleteTaskQueryController;
	@Autowired
	private DeleteData deleteData;
	@Autowired
	private SaveDatacount saveDatacount;
	
	
	@Value("${host}")
	private String host;
	
	/** 定时执行一次的任务 */ 
	@Scheduled(cron = "0 2 0 * * ?")//每天0点2分执行一次
	public void insertDateByTimes() throws Exception { 
		insertDate.insertDateByTimes();
		logger.info("插入日期....每天0点2分执行一次");
	}
	@Scheduled(cron = "0 50 0 * * ?")//每天0点50分执行一次 将执行终止状态的详情任务删除
	public void job2() throws HttpException, IOException {
		try {
			deleteEndOrder.deleteTaskstate();
			logger.info("调用接口成功(/api/platform/deleteTaskstate)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/platform/deleteTaskstate)");
		}
        logger.info("每天0点5分执行一次 将执行终止状态的详情任务删除");
	}
	@Scheduled(cron = "0 2 0 * * ?")//每天0点2分执行一次 将未完成的流量任务自动终止
	public void updateTaskstateByTimell() throws Exception {
        checkBeforeOrderll.checkBeforeOrder();
		logger.info("每天0点2分执行一次 将未完成的流量任务自动终止");
	}
	@Scheduled(cron = "0 3 0 * * ?")//每天0点3分执行一次 将未完成的流量任务自动终止
	public void updateTaskstateByTimeztc() throws Exception {
        checkBeforeOrderztc.checkBeforeOrder();
		logger.info("每天0点3分执行一次 将未完成的直通车任务自动终止");
	}
	
	@Scheduled(cron = "0 20 0 * * ?")//每天0点20分执行一次 处理前一天终止中的任务
	public void updateTaskstateByTimeEnd() throws Exception { 
		checkBeforeOrderEnd.updateTaskstateByTime();
		logger.info("处理前一天终止中的任务....每天0点20分执行一次");
	}
	@Scheduled(cron = "0 30 1 * * ?")//每天1点30分删除前一天的数据
	public void deleteDate() throws Exception { 
		deleteData.deleteData();
	}
	
	@Scheduled(cron = "0 50 0 * * ?")//每天0点50分执行一次 保存数据统计信息
	public void saveDatacount() throws Exception { 
		saveDatacount.saveDatacount();
	}
	/** 定时循环执行的任务 */
	@Scheduled(cron = "0 */10 * * * ?")//每10分钟删除已完成和已终止的详情任务数据
	public void deleteDetailinfoDate() throws Exception { 
		deleteData.deleteDetailinfoDate();
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//判断终止中的流量任务是否已终止
	public void job1() throws HttpException, IOException {
		try {
			checkEndOrderll.checkEndOrderll();
			logger.info("调用接口成功(/api/platform/checkEndOrderll)");
		} catch (Exception e) {
			logger.error("调用接口失败(/api/platform/checkEndOrderll)");
		}
        logger.info("判断终止中的流量任务是否已终止....每分钟执行一次");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//判断终止中的直通车任务是否已终止
	public void job11() throws HttpException, IOException {
		try {
			checkEndOrderztc.checkEndOrderztc();
			logger.info("调用接口成功(/api/platform/checkEndOrderztc)");
		} catch (Exception e) {
			logger.error("调用接口失败(/api/platform/checkEndOrderztc)");
		}
        logger.info("判断终止中的直通车任务是否已终止....每分钟执行一次");
	}

	@Scheduled(cron = "0 */3 * * * ?")//每隔3分钟执行一次 判断直通车任务是否已完成
	public void job3() throws HttpException, IOException {
		try {
			checkFinshOrderByZtc.checkFinshOrderByZtc();
			logger.info("调用接口成功(/api/platform/cyclecheckTaskByztc)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/platform/cyclecheckTaskByztc)");
		}
        logger.info("每隔3分钟执行一次 判断直通车任务是否已完成");
	}

	@Scheduled(cron = "0 */3 * * * ?")//每隔3分钟执行一次 判断流量任务是否已完成
	public void job33() throws HttpException, IOException {
		try {
			checkFinshOrderByll.checkFinshOrderByll();
			logger.info("调用接口成功(/api/platform/cyclecheckTaskByll)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/platform/cyclecheckTaskByll)");
		}
        logger.info("每隔3分钟执行一次 判断流量任务是否已完成");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每分钟检测流量任务执行错误数是否超出限制
	public void job4() throws HttpException, IOException {
		try {
			checkErrorll.checkErrorll();
			logger.info("调用接口成功(/api/platform/checkErrorll)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/platform/checkErrorll)");
		}
        logger.info("每分钟检测流量任务执行错误数是否超出限制");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每分钟检测直通车任务执行错误数是否超出限制
	public void job44() throws HttpException, IOException {
		try {
			checkErrorztcTask.checkErrorztcTask();
			logger.info("调用接口成功(/api/platform/checkErrorztcTaskztc)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/platform/checkErrorztcTaskztc)");
			e.printStackTrace();
		}
        logger.info("每分钟检测直通车任务执行错误数是否超出限制");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每隔1分钟执行一次 将符合要求的详情任务放入详情任务临时表 (流量任务)  
	public void job5() throws HttpException, IOException {
		try {
			allocationTask.allocateiontask();
			logger.info("调用接口成功(/api/allocationTask)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/allocationTask)");
			e.printStackTrace();
		}
		logger.info("每隔1分钟执行一次 将符合要求的详情任务放入详情任务临时表 (流量任务)");
	}
	
	//@Scheduled(cron = "0 */1 * * * ?")//每隔2分钟执行一次 将符合要求的详情任务放入详情任务临时表   
	/*public void job6() throws HttpException, IOException {
		try {
			allocationZtcTask.allocationztcTask();
			logger.info("调用接口成功(/api/allocationztcTask)");
		} catch (Exception e) {
			logger.info("调用接口失败(/api/allocationztcTask)");
			e.printStackTrace();
		}
		logger.info("每隔2分钟执行一次 将符合要求的详情任务放入详情任务临时表   ");
	}*/
	
	
	
	@Scheduled(cron = "0 */2 * * * ?")//每2分钟执行一次
	public void allocationll() throws Exception { 
		taskallocationll.allocationll();
		logger.info("分配流量任务完成....每2分钟执行一次");
	}
	
	@Scheduled(cron = "0 */1 * * * ?")//每1分钟执行一次
	public void allocationztc() throws Exception { 
		taskallocationztc.allocationztc();
		logger.info("分配直通车任务完成....每1分钟执行一次");
	}
	
	@Scheduled(cron = "0/40 * * * * ?")//每40秒钟执行一次
	public void saveTaskQuery() throws Exception { 
		taskInfoQueryController.saveTaskInfo();
	}
	
	@Scheduled(cron = "0 */3 * * * ?")//每3分钟执行一次
	public void updateTaskQueryll() throws Exception { 
		updateTaskInfoQueryllController.updateTaskInfo33();
	}

	@Scheduled(cron = "0 */3 * * * ?")//每3分钟执行一次
	public void updateTaskQueryztc() throws Exception { 
		updateTaskInfoQueryztcController.updateTaskInfo34();
	}

	@Scheduled(cron = "0 */4 * * * ?")//每4分钟执行一次
	public void updateTaskQuerystate() throws Exception { 
		updateTaskInfoQueryStateController.updateTaskInfostate();
	}
	
	@Scheduled(cron = "0 */5 * * * ?")//每5分钟执行一次
	public void checkTaskallocationll() throws Exception { 
		checkTaskallocationll.allocationll();
	}
	
	@Scheduled(cron = "0 */5 * * * ?")//每5分钟执行一次
	public void checkTaskallocationztc() throws Exception { 
		checkTaskallocationztc.allocationztc();
	}
	
	@Scheduled(cron = "0 */7 * * * ?")//每5分钟执行一次
	public void deleteTaskQuery() throws Exception { 
		deleteTaskQueryController.deleteTaskInfoQuery();
	}
	
	@Scheduled(cron = "0 */59 * * * ?")//每59分钟执行一次终止发布失败的流量任务
	public void endTaskError() throws Exception { 
		checkEndOrderll.checkEndErrorOrderll();
	}
}
