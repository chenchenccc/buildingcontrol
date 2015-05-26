package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.UserHasRoleDAO;
import com.building.model.UserHasRole;
import com.building.model.UserHasRoleExample;
import com.building.model.UserHasRoleExample.Criteria;
import com.building.service.ifc.UserHasRoleServiceIFC;

public class UserHasRoleServiceImpl implements UserHasRoleServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private UserHasRoleDAO userHasRoleDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<UserHasRole> queryUserHasRole4List(HttpServletRequest request, UserHasRole userHasRole) {
		//构造Criteria
		UserHasRoleExample example = new UserHasRoleExample();
		Criteria criteria = example.createCriteria();
	
		return userHasRoleDao.selectByExample(example);
	}
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	public UserHasRole queryUserHasRole4Bean(UserHasRole userHasRole) {
		UserHasRole _userHasRole = null;
		//构造Criteria
		UserHasRoleExample example = new UserHasRoleExample();
		Criteria criteria = example.createCriteria();
	
		List<UserHasRole> list= userHasRoleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_userHasRole = list.get(0);
		}
	return _userHasRole;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddUserHasRole(UserHasRole userHasRole) {
		userHasRoleDao.insert(userHasRole);
	}
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	public void saveEditUserHasRole(UserHasRole userHasRole) {
		userHasRoleDao.updateByPrimaryKey(userHasRole);
	}
	
	
	/**
	 * @Description: 删除实体对象 
	 */
	public void delUserHasRole(UserHasRole userHasRole) {
		userHasRoleDao.updateByPrimaryKeySelective(userHasRole);
	}
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(UserHasRole userHasRole) {
	  UserHasRoleExample example = new UserHasRoleExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return userHasRoleDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public UserHasRole queryUserHasRoleById(Integer id) {
	  return userHasRoleDao.selectByPrimaryKey(id);
	}
	
	public UserHasRoleDAO getUserHasRoleDao() {
		return userHasRoleDao;
	}
	public void setUserHasRoleDao(UserHasRoleDAO userHasRoleDao) {
		this.userHasRoleDao = userHasRoleDao;
	}
}
