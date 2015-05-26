package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.RoleHasBuilding;

public interface RoleHasBuildingServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<RoleHasBuilding> queryRoleHasBuilding4List(HttpServletRequest request, RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	RoleHasBuilding queryRoleHasBuilding4Bean(RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddRoleHasBuilding(RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditRoleHasBuilding(RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delRoleHasBuilding(RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(RoleHasBuilding roleHasBuilding);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	RoleHasBuilding queryRoleHasBuildingById( Integer id);
	
}
