package com.building.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.Device;
import com.building.model.User;
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
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listDevice(){
		List<Device> deviceList = deviceServiceProxy.queryDevice4List(request,device);
		request.setAttribute("deviceList", deviceList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( deviceList, jsonConfig );
        
        responseJson(deviceServiceProxy.countByExample(device), jsonArr);
        return SUCCESS;
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                device.setUpdateUserId( loginUser.getId() );
            }
            device.setUpdateTime( new Date() );
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                device.setCreateUserId( loginUser.getId() );
            }
            device.setCreateTime( new Date() );
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
