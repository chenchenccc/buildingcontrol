package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.Role;
import com.building.service.ifc.RoleServiceIFC;

@SuppressWarnings("serial")
public class RoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private RoleServiceIFC roleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private Role role;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listRole(){
		List<Role> roleList = roleServiceProxy.queryRole4List(request,role);
		request.setAttribute("roleList", roleList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewRole(){
		Role _role = roleServiceProxy.queryRole4Bean(role);
		request.setAttribute("operate", "view");
		request.setAttribute("role", _role);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editRole(){
		Role _role = roleServiceProxy.queryRole4Bean(role);
		request.setAttribute("operate", "edit");
		request.setAttribute("role", _role);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditRole(){
		try {
			roleServiceProxy.saveEditRole(role);
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
	public String addRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddRole(){
		try {
			roleServiceProxy.saveAddRole(role);
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
	public String delRole(){
		try {
			roleServiceProxy.delRole(role);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public RoleServiceIFC getRoleServiceProxy() {
		return roleServiceProxy;
	}
	public void setRoleServiceProxy(RoleServiceIFC roleServiceProxy) {
		this.roleServiceProxy = roleServiceProxy;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
