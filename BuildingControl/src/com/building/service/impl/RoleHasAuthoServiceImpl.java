package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.dao.ifc.RoleHasAuthoDAO;
import com.building.model.RoleHasAutho;
import com.building.model.RoleHasAuthoExample;
import com.building.model.RoleHasAutho;
import com.building.model.RoleHasAuthoExample;
import com.building.model.RoleHasAuthoExample.Criteria;
import com.building.service.ifc.RoleHasAuthoServiceIFC;

public class RoleHasAuthoServiceImpl implements RoleHasAuthoServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private RoleHasAuthoDAO roleHasAuthoDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<RoleHasAutho> queryRoleHasAutho4List(HttpServletRequest request, RoleHasAutho roleHasAutho) {
		//构造Criteria
		RoleHasAuthoExample example = new RoleHasAuthoExample();
		Criteria criteria = example.createCriteria();
	
		if(roleHasAutho != null && roleHasAutho.getRoleId() != null) {
            criteria.andRoleIdEqualTo( roleHasAutho.getRoleId() );
        }
        if(roleHasAutho != null && roleHasAutho.getAuthoId() != null) {
            criteria.andAuthoIdEqualTo( roleHasAutho.getAuthoId() );
        }
        criteria.andIsDelEqualTo( 1 );
		return roleHasAuthoDao.selectByExample(example);
	}
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	public RoleHasAutho queryRoleHasAutho4Bean(RoleHasAutho roleHasAutho) {
		RoleHasAutho _roleHasAutho = null;
		//构造Criteria
		RoleHasAuthoExample example = new RoleHasAuthoExample();
		Criteria criteria = example.createCriteria();
		if(roleHasAutho != null && roleHasAutho.getRoleId() != null) {
            criteria.andRoleIdEqualTo( roleHasAutho.getRoleId() );
        }
        if(roleHasAutho != null && roleHasAutho.getAuthoId() != null) {
            criteria.andAuthoIdEqualTo( roleHasAutho.getAuthoId() );
        }
        criteria.andIsDelEqualTo( 1 );
		List<RoleHasAutho> list= roleHasAuthoDao.selectByExample(example);
		if(list != null && list.size() > 0){
			_roleHasAutho = list.get(0);
		}
		return _roleHasAutho;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddRoleHasAutho(RoleHasAutho roleHasAutho) {
		roleHasAuthoDao.insert(roleHasAutho);
	}
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	public void saveEditRoleHasAutho(RoleHasAutho roleHasAutho) {
		roleHasAuthoDao.updateByPrimaryKey(roleHasAutho);
	}
	
	
	/**
	 * @Description: 删除实体对象 
	 */
	public void delRoleHasAutho(RoleHasAutho roleHasAutho) {
	    RoleHasAuthoExample example = new RoleHasAuthoExample();
        Criteria criteria = example.createCriteria();
        criteria.andAuthoIdEqualTo( roleHasAutho.getAuthoId() );
        criteria.andRoleIdEqualTo( roleHasAutho.getRoleId() );
        criteria.andIsDelEqualTo( 1 );
        List list = roleHasAuthoDao.selectByExample( example );
        if(list != null && list.size()> 0) {
            RoleHasAutho record = (RoleHasAutho) list.get( 0 );
            roleHasAutho.setId( record.getId() );
            roleHasAuthoDao.updateByPrimaryKeySelective(roleHasAutho);
        }
	}
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(RoleHasAutho roleHasAutho) {
	  RoleHasAuthoExample example = new RoleHasAuthoExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return roleHasAuthoDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public RoleHasAutho queryRoleHasAuthoById(Integer id) {
	  return roleHasAuthoDao.selectByPrimaryKey(id);
	}
	
	public RoleHasAuthoDAO getRoleHasAuthoDao() {
		return roleHasAuthoDao;
	}
	public void setRoleHasAuthoDao(RoleHasAuthoDAO roleHasAuthoDao) {
		this.roleHasAuthoDao = roleHasAuthoDao;
	}
}
