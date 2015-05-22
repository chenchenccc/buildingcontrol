package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.Building;
import com.building.service.ifc.BuildingServiceIFC;

@SuppressWarnings("serial")
public class BuildingAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private BuildingServiceIFC buildingServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private Building building;
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listBuilding(){
		List<Building> buildingList = buildingServiceProxy.queryBuilding4List(request,building);
		request.setAttribute("buildingList", buildingList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewBuilding(){
		Building _building = buildingServiceProxy.queryBuilding4Bean(building);
		request.setAttribute("operate", "view");
		request.setAttribute("building", _building);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editBuilding(){
		Building _building = buildingServiceProxy.queryBuilding4Bean(building);
		request.setAttribute("operate", "edit");
		request.setAttribute("building", _building);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditBuilding(){
		try {
			buildingServiceProxy.saveEditBuilding(building);
			responseJson(true, "修改成功!");
		} catch (Exception e) {
			responseJson(false, "修改失败!");
			RJLog.error(e);
		}
	return SUCCESS;
	}
	
	/**
	  * @Description: 添加实体对象 
	  */
	public String addBuilding(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddBuilding(){
		try {
			buildingServiceProxy.saveAddBuilding(building);
			responseJson(true, "添加成功!");
		} catch (Exception e) {
			responseJson(false, "添加失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	/**
	  * @Description: 删除实体对象
	  */
	public String delBuilding(){
		try {
			buildingServiceProxy.delBuilding(building);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public BuildingServiceIFC getBuildingServiceProxy() {
		return buildingServiceProxy;
	}
	public void setBuildingServiceProxy(BuildingServiceIFC buildingServiceProxy) {
		this.buildingServiceProxy = buildingServiceProxy;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
}
