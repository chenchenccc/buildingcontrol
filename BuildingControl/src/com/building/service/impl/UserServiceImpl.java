package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.UserDAO;
import com.building.model.User;
import com.building.model.UserExample;
import com.building.model.UserExample.Criteria;
import com.building.service.ifc.UserServiceIFC;

public class UserServiceImpl implements UserServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private UserDAO userDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<User> queryUser4List(HttpServletRequest request, User user) {
		//构造Criteria
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
	
		return userDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public User queryUser4Bean(User user) {
		User _user = null;
		//构造Criteria
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
	
		List<User> list= userDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_user = list.get(0);
		}
	return _user;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddUser(User user) {
		userDao.insert(user);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditUser(User user) {
		userDao.updateByPrimaryKey(user);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delUser(User user) {
		userDao.updateByPrimaryKeySelective(user);
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
