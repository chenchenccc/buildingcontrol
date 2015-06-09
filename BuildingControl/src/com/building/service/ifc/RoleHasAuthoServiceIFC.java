package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.RoleHasAutho;

public interface RoleHasAuthoServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<RoleHasAutho> queryRoleHasAutho4List(HttpServletRequest request, RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	RoleHasAutho queryRoleHasAutho4Bean(RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddRoleHasAutho(RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditRoleHasAutho(RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delRoleHasAutho(RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(RoleHasAutho roleHasAutho);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	RoleHasAutho queryRoleHasAuthoById( Integer id);
	
}
