package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.BuildingDAO;
import com.building.model.Building;
import com.building.model.BuildingExample;
import com.building.model.BuildingExample.Criteria;
import com.building.service.ifc.BuildingServiceIFC;

public class BuildingServiceImpl implements BuildingServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private BuildingDAO buildingDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<Building> queryBuilding4List(HttpServletRequest request, Building building) {
		//构造Criteria
		BuildingExample example = new BuildingExample();
		Criteria criteria = example.createCriteria();
	
		return buildingDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public Building queryBuilding4Bean(Building building) {
		Building _building = null;
		//构造Criteria
		BuildingExample example = new BuildingExample();
		Criteria criteria = example.createCriteria();
	
		List<Building> list= buildingDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_building = list.get(0);
		}
	return _building;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddBuilding(Building building) {
		buildingDao.insert(building);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditBuilding(Building building) {
		buildingDao.updateByPrimaryKey(building);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delBuilding(Building building) {
		buildingDao.updateByPrimaryKeySelective(building);
	}
	
	public BuildingDAO getBuildingDao() {
		return buildingDao;
	}
	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}
}
