package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.UserHasRole;

public interface UserHasRoleServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<UserHasRole> queryUserHasRole4List(HttpServletRequest request, UserHasRole userHasRole);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	UserHasRole queryUserHasRole4Bean(UserHasRole userHasRole);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddUserHasRole(UserHasRole userHasRole);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditUserHasRole(UserHasRole userHasRole);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delUserHasRole(UserHasRole userHasRole);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(UserHasRole userHasRole);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	UserHasRole queryUserHasRoleById( Integer id);
	
}
