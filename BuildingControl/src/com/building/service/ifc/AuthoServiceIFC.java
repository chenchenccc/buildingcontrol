package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Autho;

public interface AuthoServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<Autho> queryAutho4List(HttpServletRequest request, Autho autho);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	Autho queryAutho4Bean(Autho autho);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddAutho(Autho autho);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditAutho(Autho autho);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delAutho(Autho autho);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(Autho autho);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	Autho queryAuthoById( Integer id);
	
}
