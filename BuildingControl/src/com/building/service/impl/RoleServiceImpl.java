package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.RoleDAO;
import com.building.model.Role;
import com.building.model.RoleExample;
import com.building.model.RoleExample.Criteria;
import com.building.service.ifc.RoleServiceIFC;

public class RoleServiceImpl implements RoleServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private RoleDAO roleDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<Role> queryRole4List(HttpServletRequest request, Role role) {
		//构造Criteria
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
        
        if(null != request.getParameter("rows") && null != request.getParameter("page")) {
            int limit = Integer.parseInt(request.getParameter("rows"));
            int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
            example.setLimitStart(start);
            example.setLimitEnd(limit);
        }
        
        criteria.andIsDelEqualTo( 1 );
	
		return roleDao.selectByExample(example);
	}
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	public Role queryRole4Bean(Role role) {
		Role _role = null;
		//构造Criteria
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
	
		List<Role> list= roleDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_role = list.get(0);
		}
	return _role;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddRole(Role role) {
	    role.setIsDel( 1 );
		roleDao.insert(role);
	}
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	public void saveEditRole(Role role) {
		roleDao.updateByPrimaryKey(role);
	}
	
	
	/**
	 * @Description: 删除实体对象 
	 */
	public void delRole(Role role) {
		roleDao.updateByPrimaryKeySelective(role);
	}
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(Role role) {
	  RoleExample example = new RoleExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return roleDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public Role queryRoleById(Integer id) {
	  return roleDao.selectByPrimaryKey(id);
	}
	
	public RoleDAO getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}
}
