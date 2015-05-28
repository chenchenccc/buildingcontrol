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
import com.building.model.User;
import com.building.service.ifc.BuildingServiceIFC;
import com.building.service.ifc.DeviceServiceIFC;

@SuppressWarnings("serial")
public class DeviceAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private DeviceServiceIFC deviceServiceProxy;
	private BuildingServiceIFC buildingServiceProxy;
	
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
		List<Device> retDeviceList = new ArrayList<Device>();
		// 添加所属楼层字段
		for (Device d : deviceList) {
            Long bid = d.getBuildingId();
            Building building = buildingServiceProxy.queryBuildingById( bid.intValue() );
            if(building != null && building.getSuperId() != 0 ) {
                
                Building superBuilding = buildingServiceProxy.queryBuildingById( building.getSuperId() );
                building.setBuildingName( superBuilding.getBuildingName() + ">" + building.getBuildingName() ); 
            }
            d.setBuildingName( building.getBuildingName() );
            retDeviceList.add( d );
        }
		request.setAttribute("deviceList", retDeviceList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( retDeviceList, jsonConfig );
        
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
		    if(device == null || device.getId() == null) {
                responseJson( false, "参数错误！" );
                return SUCCESS;
            }
		    device.setIsDel( 1 );
			deviceServiceProxy.delDevice(device);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public String changeState() {
	    try {
	        if(device == null || device.getId() == null) {
	            responseJson( false, "参数错误！" );
	            return SUCCESS;
	        }
	        device = deviceServiceProxy.queryDeviceById( device.getId() );
	        if(device == null) {
	            responseJson( false, "数据错误！" );
                return SUCCESS;
	        }
	        // state = 0 -> 转换为1， state = 1 -> 转换为0
	        int state = ( device.getState() + 1 ) % 2;
            device.setState( state );
            deviceServiceProxy.delDevice(device);
            responseJson(true, "更改状态成功!");
        } catch (Exception e) {
            responseJson(false, "更改状态失败!");
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

    
    public BuildingServiceIFC getBuildingServiceProxy() {
        return buildingServiceProxy;
    }

    
    public void setBuildingServiceProxy( BuildingServiceIFC buildingServiceProxy ) {
        this.buildingServiceProxy = buildingServiceProxy;
    }
	
	
}
