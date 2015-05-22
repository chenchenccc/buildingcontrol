package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.User;
import com.building.service.ifc.UserServiceIFC;

@SuppressWarnings("serial")
public class UserAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private UserServiceIFC userServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private User user;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listUser(){
		List<User> userList = userServiceProxy.queryUser4List(request,user);
		request.setAttribute("userList", userList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewUser(){
		User _user = userServiceProxy.queryUser4Bean(user);
		request.setAttribute("operate", "view");
		request.setAttribute("user", _user);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editUser(){
		User _user = userServiceProxy.queryUser4Bean(user);
		request.setAttribute("operate", "edit");
		request.setAttribute("user", _user);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditUser(){
		try {
			userServiceProxy.saveEditUser(user);
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
	public String addUser(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddUser(){
		try {
			userServiceProxy.saveAddUser(user);
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
	public String delUser(){
		try {
			userServiceProxy.delUser(user);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public UserServiceIFC getUserServiceProxy() {
		return userServiceProxy;
	}
	public void setUserServiceProxy(UserServiceIFC userServiceProxy) {
		this.userServiceProxy = userServiceProxy;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
