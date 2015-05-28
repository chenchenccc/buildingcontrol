package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.RoleHasBuildingDAO;
import com.building.model.RoleHasBuilding;
import com.building.model.RoleHasBuildingExample;
import com.building.model.RoleHasBuildingExample.Criteria;
import com.building.service.ifc.RoleHasBuildingServiceIFC;

public class RoleHasBuildingServiceImpl implements RoleHasBuildingServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private RoleHasBuildingDAO roleHasBuildingDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<RoleHasBuilding> queryRoleHasBuilding4List(HttpServletRequest request, RoleHasBuilding roleHasBuilding) {
		//构造Criteria
		RoleHasBuildingExample example = new RoleHasBuildingExample();
		Criteria criteria = example.createCriteria();

        
        if(null != request.getParameter("rows") && null != request.getParameter("page")) {
            int limit = Integer.parseInt(request.getParameter("rows"));
            int start = (Integer.parseInt(request.getParameter("page")) - 1) * limit;
            example.setLimitStart(start);
            example.setLimitEnd(limit);
        }
        
        criteria.andIsDelEqualTo( 1 );
		return roleHasBuildingDao.selectByExample(example);
	}
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	public RoleHasBuilding queryRoleHasBuilding4Bean(RoleHasBuilding roleHasBuilding) {
		RoleHasBuilding _roleHasBuilding = null;
		//构造Criteria
		RoleHasBuildingExample example = new RoleHasBuildingExample();
		Criteria criteria = example.createCriteria();
	
		List<RoleHasBuilding> list= roleHasBuildingDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_roleHasBuilding = list.get(0);
		}
	return _roleHasBuilding;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddRoleHasBuilding(RoleHasBuilding roleHasBuilding) {
	    roleHasBuilding.setIsDel( 1 );
		roleHasBuildingDao.insert(roleHasBuilding);
	}
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	public void saveEditRoleHasBuilding(RoleHasBuilding roleHasBuilding) {
		roleHasBuildingDao.updateByPrimaryKey(roleHasBuilding);
	}
	
	
	/**
	 * @Description: 删除实体对象 
	 */
	public void delRoleHasBuilding(RoleHasBuilding roleHasBuilding) {
		roleHasBuildingDao.updateByPrimaryKeySelective(roleHasBuilding);
	}
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(RoleHasBuilding roleHasBuilding) {
	  RoleHasBuildingExample example = new RoleHasBuildingExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return roleHasBuildingDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public RoleHasBuilding queryRoleHasBuildingById(Integer id) {
	  return roleHasBuildingDao.selectByPrimaryKey(id);
	}
	
	public RoleHasBuildingDAO getRoleHasBuildingDao() {
		return roleHasBuildingDao;
	}
	public void setRoleHasBuildingDao(RoleHasBuildingDAO roleHasBuildingDao) {
		this.roleHasBuildingDao = roleHasBuildingDao;
	}
}
