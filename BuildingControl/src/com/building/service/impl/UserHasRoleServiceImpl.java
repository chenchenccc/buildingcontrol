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
        
        if(null != request.getParameter("rows") && null != request.getParameter("page")) {
            int limit = Integer.parseInt(request.getParameter("rows"));
            int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
            example.setLimitStart(start);
            example.setLimitEnd(limit);
        }
        if(userHasRole != null && userHasRole.getRoleId() != null) {
            criteria.andRoleIdEqualTo( userHasRole.getRoleId() );
        }
        if(userHasRole != null && userHasRole.getUserId() != null) {
            criteria.andUserIdEqualTo( userHasRole.getUserId() );
        }
        criteria.andIsDelEqualTo( 1 );
	
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
		if(userHasRole != null && userHasRole.getRoleId() != null) {
            criteria.andRoleIdEqualTo( userHasRole.getRoleId() );
        }
        if(userHasRole != null && userHasRole.getUserId() != null) {
            criteria.andUserIdEqualTo( userHasRole.getUserId() );
        }
        if(userHasRole != null && userHasRole.getIsDel() != null) {
            criteria.andIsDelEqualTo( userHasRole.getIsDel() );
        }
		List<UserHasRole> list= userHasRoleDao.selectByExample(example);
		if(list != null && list.size() > 0){
			_userHasRole = list.get(0);
		}
	return _userHasRole;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddUserHasRole(UserHasRole userHasRole) {
	    userHasRole.setIsDel( 1 );
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
	    UserHasRoleExample example = new UserHasRoleExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo( userHasRole.getUserId() );
        criteria.andRoleIdEqualTo( userHasRole.getRoleId() );
        criteria.andIsDelEqualTo( 1 );
        List list = userHasRoleDao.selectByExample( example );
        if(list != null && list.size()> 0) {
            UserHasRole record = (UserHasRole) list.get( 0 );
            userHasRole.setId( record.getId() );
            userHasRoleDao.updateByPrimaryKeySelective(userHasRole);
        }
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
