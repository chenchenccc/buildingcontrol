package com.building.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.Building;
import com.building.model.User;
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
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listBuilding(){
		List<Building> buildingList = buildingServiceProxy.queryBuilding4List(request,building);
		request.setAttribute("buildingList", buildingList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( buildingList, jsonConfig );
        
        responseJson(buildingServiceProxy.countByExample(building), jsonArr);
        return SUCCESS;
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                building.setUpdateUserId( loginUser.getId() );
            }
            building.setUpdateTime( new Date() );
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
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                building.setCreateUserId( loginUser.getId() );
            }
            building.setCreateTime( new Date() );
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
