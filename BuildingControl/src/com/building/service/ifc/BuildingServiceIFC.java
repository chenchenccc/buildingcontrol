package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Building;

public interface BuildingServiceIFC {
	
	/**
	  * @Description: 获取实体列表 
	  */
	List<Building> queryBuilding4List(HttpServletRequest request, Building building);
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	Building queryBuilding4Bean(Building building);
	
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	void saveAddBuilding(Building building);
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	void saveEditBuilding(Building building);
	
	
	/**
	  * @Description: 删除实体对象
	  */
	void delBuilding(Building building);
	
}
