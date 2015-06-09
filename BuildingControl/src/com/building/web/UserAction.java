package com.building.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
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
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listUser(){
		List<User> userList = userServiceProxy.queryUser4List(request,user);
		request.setAttribute("userList", userList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( userList, jsonConfig );
        
        responseJson(userServiceProxy.countByExample(user), jsonArr);
		return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewUser(){
		User _user = userServiceProxy.queryUserById( user.getId() );
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                user.setUpdateUserId( loginUser.getId() );
            }
            user.setUpdateTime( new Date() );
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
		    HttpSession session = request.getSession();
		    User loginUser = (User) session.getAttribute( "loginUser" );
		    if(loginUser != null) {
		        user.setCreateUserId( loginUser.getId() );
		    }
		    user.setCreateTime( new Date() );
		    // 设置用户状态为离线
		    user.setIsOnline( 2L );
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
		    user.setIsDel( 1 );
			userServiceProxy.delUser(user);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public String disableUser() {
	    try {
            user.setIsOnline( 3L );
            userServiceProxy.delUser(user);
            responseJson(true, "禁用用户成功!");
        } catch (Exception e) {
            responseJson(false, "禁用用户失败!");
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
