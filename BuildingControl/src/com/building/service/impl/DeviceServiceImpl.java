package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.DeviceDAO;
import com.building.model.Device;
import com.building.model.DeviceExample;
import com.building.model.DeviceExample.Criteria;
import com.building.service.ifc.DeviceServiceIFC;

public class DeviceServiceImpl implements DeviceServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private DeviceDAO deviceDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<Device> queryDevice4List(HttpServletRequest request, Device device) {
		//构造Criteria
		DeviceExample example = new DeviceExample();
		Criteria criteria = example.createCriteria();
	
		return deviceDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public Device queryDevice4Bean(Device device) {
		Device _device = null;
		//构造Criteria
		DeviceExample example = new DeviceExample();
		Criteria criteria = example.createCriteria();
	
		List<Device> list= deviceDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_device = list.get(0);
		}
	return _device;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddDevice(Device device) {
		deviceDao.insert(device);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditDevice(Device device) {
		deviceDao.updateByPrimaryKey(device);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delDevice(Device device) {
		deviceDao.updateByPrimaryKeySelective(device);
	}
	
	public DeviceDAO getDeviceDao() {
		return deviceDao;
	}
	public void setDeviceDao(DeviceDAO deviceDao) {
		this.deviceDao = deviceDao;
	}
}
