package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.UserHasRole;
import com.building.service.ifc.UserHasRoleServiceIFC;

@SuppressWarnings("serial")
public class UserHasRoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private UserHasRoleServiceIFC userHasRoleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private UserHasRole userHasRole;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listUserHasRole(){
		List<UserHasRole> userHasRoleList = userHasRoleServiceProxy.queryUserHasRole4List(request,userHasRole);
		request.setAttribute("userHasRoleList", userHasRoleList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewUserHasRole(){
		UserHasRole _userHasRole = userHasRoleServiceProxy.queryUserHasRole4Bean(userHasRole);
		request.setAttribute("operate", "view");
		request.setAttribute("userHasRole", _userHasRole);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editUserHasRole(){
		UserHasRole _userHasRole = userHasRoleServiceProxy.queryUserHasRole4Bean(userHasRole);
		request.setAttribute("operate", "edit");
		request.setAttribute("userHasRole", _userHasRole);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditUserHasRole(){
		try {
			userHasRoleServiceProxy.saveEditUserHasRole(userHasRole);
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
	public String addUserHasRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddUserHasRole(){
		try {
			userHasRoleServiceProxy.saveAddUserHasRole(userHasRole);
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
	public String delUserHasRole(){
		try {
			userHasRoleServiceProxy.delUserHasRole(userHasRole);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public UserHasRoleServiceIFC getUserHasRoleServiceProxy() {
		return userHasRoleServiceProxy;
	}
	public void setUserHasRoleServiceProxy(UserHasRoleServiceIFC userHasRoleServiceProxy) {
		this.userHasRoleServiceProxy = userHasRoleServiceProxy;
	}
	public UserHasRole getUserHasRole() {
		return userHasRole;
	}
	public void setUserHasRole(UserHasRole userHasRole) {
		this.userHasRole = userHasRole;
	}
}
