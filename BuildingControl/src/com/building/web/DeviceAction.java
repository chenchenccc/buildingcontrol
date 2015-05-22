package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.Device;
import com.building.service.ifc.DeviceServiceIFC;

@SuppressWarnings("serial")
public class DeviceAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private DeviceServiceIFC deviceServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private Device device;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listDevice(){
		List<Device> deviceList = deviceServiceProxy.queryDevice4List(request,device);
		request.setAttribute("deviceList", deviceList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewDevice(){
		Device _device = deviceServiceProxy.queryDevice4Bean(device);
		request.setAttribute("operate", "view");
		request.setAttribute("device", _device);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editDevice(){
		Device _device = deviceServiceProxy.queryDevice4Bean(device);
		request.setAttribute("operate", "edit");
		request.setAttribute("device", _device);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditDevice(){
		try {
			deviceServiceProxy.saveEditDevice(device);
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
	public String addDevice(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddDevice(){
		try {
			deviceServiceProxy.saveAddDevice(device);
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
	public String delDevice(){
		try {
			deviceServiceProxy.delDevice(device);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public DeviceServiceIFC getDeviceServiceProxy() {
		return deviceServiceProxy;
	}
	public void setDeviceServiceProxy(DeviceServiceIFC deviceServiceProxy) {
		this.deviceServiceProxy = deviceServiceProxy;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
}
