package com.building.service.ifc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Schedule;

public interface ScheduleServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<Schedule> querySchedule4List(HttpServletRequest request, Schedule schedule);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	Schedule querySchedule4Bean(Schedule schedule);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddSchedule(Schedule schedule);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditSchedule(Schedule schedule);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delSchedule(Schedule schedule);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(Schedule schedule);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	Schedule queryScheduleById( Integer id);


	/**
	 * 执行日程任务
	 * @author chenrh
	 *
	 * @param date
	 */
    void getScheduleTask( Date date );
	
}
