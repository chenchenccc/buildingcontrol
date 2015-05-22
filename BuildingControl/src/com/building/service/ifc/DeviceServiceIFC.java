package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Device;

public interface DeviceServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<Device> queryDevice4List(HttpServletRequest request, Device device);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	Device queryDevice4Bean(Device device);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddDevice(Device device);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditDevice(Device device);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delDevice(Device device);
	
}
