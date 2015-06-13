package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Autho;
import com.building.model.Role;

public interface RoleServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<Role> queryRole4List(HttpServletRequest request, Role role);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	Role queryRole4Bean(Role role);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddRole(Role role);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditRole(Role role);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delRole(Role role);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(Role role);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	Role queryRoleById( Integer id);


	/**
     * 获取权限列表
     *
     * @param roleIds
     * @return
     */
    public List<Autho> getAuthoList( List<Integer> roleIds );
	
}
