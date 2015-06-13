package com.building.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.Building;
import com.building.model.Device;
import com.building.model.Schedule;
import com.building.model.User;
import com.building.service.ifc.BuildingServiceIFC;
import com.building.service.ifc.DeviceServiceIFC;
import com.building.service.ifc.ScheduleServiceIFC;

@SuppressWarnings("serial")
public class ScheduleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private ScheduleServiceIFC scheduleServiceProxy;
	private DeviceServiceIFC deviceServiceProxy;
	private BuildingServiceIFC buildingServiceProxy;
	
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
	    try {
	        List<Schedule> scheduleList = scheduleServiceProxy.querySchedule4List(request,schedule);
	        List<Schedule> retScheduleList = new ArrayList<Schedule>();
	        // 获取关联deviceName
	        for (Schedule s : scheduleList) {
	            Device d = deviceServiceProxy.queryDeviceById( s.getDeviceId() );
	            Building b = buildingServiceProxy.queryBuildingById( d.getBuildingId().intValue() );
	            if(b != null && b.getSuperId() != 0) {
	                Building superb = buildingServiceProxy.queryBuildingById( b.getSuperId() );
	                b.setBuildingName( superb.getBuildingName() + ">" + b.getBuildingName() );
	            }
	            s.setBuildingName( b.getBuildingName() );
	            s.setDeviceName( d.getDeviceName() );
	            retScheduleList.add( s );
	        }
	        request.setAttribute("scheduleList", retScheduleList);
	        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
	        
	        jsonArr= JSONArray.fromObject( retScheduleList, jsonConfig );
	        
	        responseJson(scheduleServiceProxy.countByExample(schedule), jsonArr);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewSchedule(){
		Schedule _schedule = scheduleServiceProxy.queryScheduleById( schedule.getId() );
		
		Device d = deviceServiceProxy.queryDeviceById( _schedule.getDeviceId() );
        Building b = buildingServiceProxy.queryBuildingById( d.getBuildingId().intValue() );
        if(b != null && b.getSuperId() != 0) {
            Building superb = buildingServiceProxy.queryBuildingById( b.getSuperId() );
            b.setBuildingName( superb.getBuildingName() + ">" + b.getBuildingName() );
        }
        _schedule.setBuildingName( b.getBuildingName() );
        _schedule.setDeviceName( d.getDeviceName() );
        
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
            schedule.setIsDone( 2 );
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
		    schedule.setIsDel( 1 );
			scheduleServiceProxy.delSchedule(schedule);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public String cancelSchedule() {
	    try {
	        if(schedule == null || schedule.getId() == null) {
	            responseJson( false, "参数错误！" );
	            return SUCCESS;
	        }
            schedule.setIsDone( 3 );
            scheduleServiceProxy.delSchedule(schedule);
            responseJson(true, "日程取消成功!");
        } catch (Exception e) {
            responseJson(false, "日程取消失败!");
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

    
    public DeviceServiceIFC getDeviceServiceProxy() {
        return deviceServiceProxy;
    }

    
    public void setDeviceServiceProxy( DeviceServiceIFC deviceServiceProxy ) {
        this.deviceServiceProxy = deviceServiceProxy;
    }

    
    public BuildingServiceIFC getBuildingServiceProxy() {
        return buildingServiceProxy;
    }

    
    public void setBuildingServiceProxy( BuildingServiceIFC buildingServiceProxy ) {
        this.buildingServiceProxy = buildingServiceProxy;
    }
	
	
}
