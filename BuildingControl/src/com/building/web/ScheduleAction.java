package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.Schedule;
import com.building.service.ifc.ScheduleServiceIFC;

@SuppressWarnings("serial")
public class ScheduleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private ScheduleServiceIFC scheduleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private Schedule schedule;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSchedule(){
		List<Schedule> scheduleList = scheduleServiceProxy.querySchedule4List(request,schedule);
		request.setAttribute("scheduleList", scheduleList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSchedule(){
		Schedule _schedule = scheduleServiceProxy.querySchedule4Bean(schedule);
		request.setAttribute("operate", "view");
		request.setAttribute("schedule", _schedule);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editSchedule(){
		Schedule _schedule = scheduleServiceProxy.querySchedule4Bean(schedule);
		request.setAttribute("operate", "edit");
		request.setAttribute("schedule", _schedule);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditSchedule(){
		try {
			scheduleServiceProxy.saveEditSchedule(schedule);
			responseJson(true, "修改成功!");
		} catch (Exception e) {
			responseJson(false, "修改失败!");
			RJLog.error(e);
		}
	return SUCCESS;
	}
	
	/**
	  * @Description: 添加实体对象 
	  */
	public String addSchedule(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddSchedule(){
		try {
			scheduleServiceProxy.saveAddSchedule(schedule);
			responseJson(true, "添加成功!");
		} catch (Exception e) {
			responseJson(false, "添加失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	/**
	  * @Description: 删除实体对象
	  */
	public String delSchedule(){
		try {
			scheduleServiceProxy.delSchedule(schedule);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public ScheduleServiceIFC getScheduleServiceProxy() {
		return scheduleServiceProxy;
	}
	public void setScheduleServiceProxy(ScheduleServiceIFC scheduleServiceProxy) {
		this.scheduleServiceProxy = scheduleServiceProxy;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
}
