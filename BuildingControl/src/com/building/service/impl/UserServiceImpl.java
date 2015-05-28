package com.building.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.dao.ifc.RoleDAO;
import com.building.dao.ifc.UserDAO;
import com.building.dao.ifc.UserHasRoleDAO;
import com.building.model.Role;
import com.building.model.User;
import com.building.model.UserExample;
import com.building.model.UserHasRole;
import com.building.model.UserHasRoleExample;
import com.building.model.UserExample.Criteria;
import com.building.service.ifc.UserServiceIFC;

public class UserServiceImpl implements UserServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private UserDAO userDao;
	
	private UserHasRoleDAO userHasRoleDao;
    
    private RoleDAO roleDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<User> queryUser4List(HttpServletRequest request, User user) {
		//构造Criteria
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
        
        if(null != request.getParameter("rows") && null != request.getParameter("page")) {
            int limit = Integer.parseInt(request.getParameter("rows"));
            int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
            example.setLimitStart(start);
            example.setLimitEnd(limit);
        }
        
        criteria.andIsDelEqualTo( 1 );
	
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
	    user.setIsDel( 1 );
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
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(User user) {
	  UserExample example = new UserExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return userDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public User queryUserById(Integer id) {
	  return userDao.selectByPrimaryKey(id);
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

    public User checkUsername( String username ) {
        //构造Criteria
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo( username );
        List list = userDao.selectByExample( example );
        if(list != null && list.size() > 0) {
            return (User) list.get( 0 );
        }
        return null;
    }

    public List<Role> getRoleList( Integer userId ) {
        List<Role> ret = new ArrayList<Role>(); 
        try {
            UserHasRoleExample example = new UserHasRoleExample();
            UserHasRoleExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo( userId );
            List<UserHasRole> UserHasRoleList = userHasRoleDao.selectByExample( example  );
            
            if( UserHasRoleList != null && UserHasRoleList.size() > 0 ) {
                for (UserHasRole ur : UserHasRoleList) {
                    Role i = roleDao.selectByPrimaryKey( ur.getRoleId() );
                    ret.add( i );
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ret;
    }


    
    public UserHasRoleDAO getUserHasRoleDao() {
        return userHasRoleDao;
    }


    
    public void setUserHasRoleDao( UserHasRoleDAO userHasRoleDao ) {
        this.userHasRoleDao = userHasRoleDao;
    }
    
    public RoleDAO getRoleDao() {
        return roleDao;
    }

    public void setRoleDao( RoleDAO roleDao ) {
        this.roleDao = roleDao;
    }
    
    
}
