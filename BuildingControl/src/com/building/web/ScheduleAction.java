package com.building.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.net.aso.s;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.Schedule;
import com.building.model.User;
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
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listSchedule(){
		List<Schedule> scheduleList = scheduleServiceProxy.querySchedule4List(request,schedule);
		request.setAttribute("scheduleList", scheduleList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( scheduleList, jsonConfig );
        
        responseJson(scheduleServiceProxy.countByExample(schedule), jsonArr);
        return SUCCESS;
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                schedule.setUpdateUserId( loginUser.getId() );
            }
            schedule.setUpdateTime( new Date() );
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                schedule.setCreateUserId( loginUser.getId() );
            }
            schedule.setCreateTime( new Date() );
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
