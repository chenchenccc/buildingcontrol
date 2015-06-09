package com.building.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.dao.ifc.DeviceDAO;
import com.building.dao.ifc.ScheduleDAO;
import com.building.model.Device;
import com.building.model.Schedule;
import com.building.model.ScheduleExample;
import com.building.model.ScheduleExample.Criteria;
import com.building.service.ifc.ScheduleServiceIFC;

public class ScheduleServiceImpl implements ScheduleServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private ScheduleDAO scheduleDao;
	private DeviceDAO deviceDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<Schedule> querySchedule4List(HttpServletRequest request, Schedule schedule) {
		//构造Criteria
		ScheduleExample example = new ScheduleExample();
		Criteria criteria = example.createCriteria();
		if(schedule != null && schedule.getIsDone() != null) {
		    criteria.andIsDoneEqualTo( schedule.getIsDone() );
		}
        
        if(null != request.getParameter("rows") && null != request.getParameter("page")) {
            int limit = Integer.parseInt(request.getParameter("rows"));
            int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
            example.setLimitStart(start);
            example.setLimitEnd(limit);
        }
        
        criteria.andIsDelEqualTo( 1 );
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
	    schedule.setIsDel( 1 );
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
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(Schedule schedule) {
	  ScheduleExample example = new ScheduleExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return scheduleDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public Schedule queryScheduleById(Integer id) {
	  return scheduleDao.selectByPrimaryKey(id);
	}
	
	public void getScheduleTask( Date date ) {
	    System.out.println(date);
        ScheduleExample example = new ScheduleExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo( 1 );
        criteria.andScheduleDateLessThan( date );
        criteria.andIsDoneEqualTo( 2 ); // 未完成

        List<Schedule> list = scheduleDao.selectByExample( example );
        
        // 执行日程
        for (Schedule s : list) {
            s.getDeviceId();
            s.getChangeState();
            Device d = new Device();
            d.setId( s.getDeviceId() );
            d.setState( s.getChangeState() );
            deviceDao.updateByPrimaryKeySelective( d  );
            Schedule record = new Schedule();
            record.setId( s.getId() );
            record.setIsDone( 1 );
            scheduleDao.updateByPrimaryKeySelective( record  );
            System.out.println("设备"+d.getId()+"状态已经改变为"+(d.getState()==0?'关':'开'));
        }
        
    }
	
	public ScheduleDAO getScheduleDao() {
		return scheduleDao;
	}
	public void setScheduleDao(ScheduleDAO scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

    
    public DeviceDAO getDeviceDao() {
        return deviceDao;
    }


    
    public void setDeviceDao( DeviceDAO deviceDao ) {
        this.deviceDao = deviceDao;
    }
    
    
}
