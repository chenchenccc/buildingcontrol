package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.ScheduleDAO;
import com.building.model.Schedule;
import com.building.model.ScheduleExample;
import com.building.model.ScheduleExample.Criteria;
import com.building.service.ifc.ScheduleServiceIFC;

public class ScheduleServiceImpl implements ScheduleServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private ScheduleDAO scheduleDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<Schedule> querySchedule4List(HttpServletRequest request, Schedule schedule) {
		//构造Criteria
		ScheduleExample example = new ScheduleExample();
		Criteria criteria = example.createCriteria();
	
		return scheduleDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public Schedule querySchedule4Bean(Schedule schedule) {
		Schedule _schedule = null;
		//构造Criteria
		ScheduleExample example = new ScheduleExample();
		Criteria criteria = example.createCriteria();
	
		List<Schedule> list= scheduleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_schedule = list.get(0);
		}
	return _schedule;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSchedule(Schedule schedule) {
		scheduleDao.insert(schedule);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSchedule(Schedule schedule) {
		scheduleDao.updateByPrimaryKey(schedule);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSchedule(Schedule schedule) {
		scheduleDao.updateByPrimaryKeySelective(schedule);
	}
	
	public ScheduleDAO getScheduleDao() {
		return scheduleDao;
	}
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}
}
