package com.building.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.RoleHasBuilding;
import com.building.service.ifc.RoleHasBuildingServiceIFC;

@SuppressWarnings("serial")
public class RoleHasBuildingAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private RoleHasBuildingServiceIFC roleHasBuildingServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private RoleHasBuilding roleHasBuilding;
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listRoleHasBuilding(){
		List<RoleHasBuilding> roleHasBuildingList = roleHasBuildingServiceProxy.queryRoleHasBuilding4List(request,roleHasBuilding);
		request.setAttribute("roleHasBuildingList", roleHasBuildingList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( roleHasBuildingList, jsonConfig );
        
        responseJson(roleHasBuildingServiceProxy.countByExample(roleHasBuilding), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewRoleHasBuilding(){
		RoleHasBuilding _roleHasBuilding = roleHasBuildingServiceProxy.queryRoleHasBuilding4Bean(roleHasBuilding);
		request.setAttribute("operate", "view");
		request.setAttribute("roleHasBuilding", _roleHasBuilding);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editRoleHasBuilding(){
		RoleHasBuilding _roleHasBuilding = roleHasBuildingServiceProxy.queryRoleHasBuilding4Bean(roleHasBuilding);
		request.setAttribute("operate", "edit");
		request.setAttribute("roleHasBuilding", _roleHasBuilding);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditRoleHasBuilding(){
		try {
			roleHasBuildingServiceProxy.saveEditRoleHasBuilding(roleHasBuilding);
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
	public String addRoleHasBuilding(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddRoleHasBuilding(){
		try {
			roleHasBuildingServiceProxy.saveAddRoleHasBuilding(roleHasBuilding);
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
	public String delRoleHasBuilding(){
		try {
			roleHasBuildingServiceProxy.delRoleHasBuilding(roleHasBuilding);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public RoleHasBuildingServiceIFC getRoleHasBuildingServiceProxy() {
		return roleHasBuildingServiceProxy;
	}
	public void setRoleHasBuildingServiceProxy(RoleHasBuildingServiceIFC roleHasBuildingServiceProxy) {
		this.roleHasBuildingServiceProxy = roleHasBuildingServiceProxy;
	}
	public RoleHasBuilding getRoleHasBuilding() {
		return roleHasBuilding;
	}
	public void setRoleHasBuilding(RoleHasBuilding roleHasBuilding) {
		this.roleHasBuilding = roleHasBuilding;
	}
}
