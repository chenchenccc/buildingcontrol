package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.User;

public interface UserServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<User> queryUser4List(HttpServletRequest request, User user);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	User queryUser4Bean(User user);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddUser(User user);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditUser(User user);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delUser(User user);
	
}
