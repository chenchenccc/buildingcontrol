package com.building.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.commons.utils.ZTreeBean;
import com.building.model.Building;
import com.building.model.RoleHasBuilding;
import com.building.model.User;
import com.building.model.UserHasRole;
import com.building.service.ifc.BuildingServiceIFC;
import com.building.service.ifc.RoleHasBuildingServiceIFC;
import com.building.service.ifc.UserHasRoleServiceIFC;

@SuppressWarnings("serial")
public class BuildingAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private BuildingServiceIFC buildingServiceProxy;
	private UserHasRoleServiceIFC userHasRoleServiceProxy;
	private RoleHasBuildingServiceIFC roleHasBuildingServiceProxy;
	
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
		List<Building> retBuildingList = new ArrayList<Building>();
		for (Building building : buildingList) {
            if(building.getSuperId() != 0) {
                Building superBuilding = buildingServiceProxy.queryBuildingById( building.getSuperId() );
                building.setBuildingName( superBuilding.getBuildingName() + ">" + building.getBuildingName());
            }
            retBuildingList.add( building );
        }
		request.setAttribute("buildingList", buildingList);
		request.getSession().setAttribute("buildingList", buildingList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( buildingList, jsonConfig );
        
        responseJson(buildingServiceProxy.countByExample(building), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewBuilding(){
		Building _building = buildingServiceProxy.queryBuildingById( building.getId() );
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
            if(building.getIsDel()!=null){
            	building.setIsDel(1);
            }
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
//            building.setBuildingName(building.getBuildingName().t)
            building.setCreateTime( new Date() );
            if(building.getBuildingType()==0){
            	building.setSuperId(0);
            }
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
		    building.setIsDel( 2 );
			buildingServiceProxy.delBuilding(building);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public String buildingTree() {
	    try {
    	    // 获取登录用户
    	    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser == null) {
                responseJson( false,"用户未登录" );
                return SUCCESS;
            }
            
            // 获取用户角色
            Integer userId = loginUser.getId();
            UserHasRole userHasRole = new UserHasRole();
            userHasRole.setUserId( userId );
            List<UserHasRole> userRoleList = userHasRoleServiceProxy.queryUserHasRole4List( request, userHasRole  );
            if(userRoleList == null || userRoleList.size() == 0) {
                // 用户没有角色
                responseJson( false,"用户无角色" );
                return SUCCESS;
            }
            List<Integer> buildingIds = new ArrayList<Integer>();
            for (UserHasRole ur : userRoleList) {
                Integer roleId = ur.getRoleId();
                
                RoleHasBuilding roleHasBuilding = new RoleHasBuilding();
                roleHasBuilding.setRoleId( roleId );
                //获取角色对象, 楼宇ID列表
                List<RoleHasBuilding> roleBuildingList = roleHasBuildingServiceProxy.queryRoleHasBuilding4List( request, roleHasBuilding  );
                for (RoleHasBuilding rb : roleBuildingList) {
                    buildingIds.add( rb.getBuildingId() );
                }
            }
            ZTreeBean buildingTree = null;
            List<ZTreeBean> ztreeList = new ArrayList<ZTreeBean>();
            Building b = null;
            // 获取楼宇对象
            for (Integer buildingId : buildingIds) {
                b = buildingServiceProxy.queryBuildingById( buildingId );
                if(b.getIsDel() == 1) {
                	buildingTree = new ZTreeBean();
                	buildingTree.setId(b.getId());
                	buildingTree.setName(b.getBuildingName());
                	buildingTree.setOpen(Boolean.TRUE);
                	buildingTree.setpId(b.getSuperId());
                	ztreeList.add(buildingTree);
                }
            }
           
            if(ztreeList == null || ztreeList.size() == 0) {
                responseJson( false,"用户无权限" );
                return SUCCESS;
            }
            jsonArr = JSONArray.fromObject(ztreeList);
            responseJson( true, jsonArr );
        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return SUCCESS;
	}
	
	/**
	 * 所有楼层 
	 * @return
	 */
	public String allBuilding(){
        try {
            building = new Building();
            building.setSuperId( 0 ); // 设置superId为0 为大楼
            building.setIsDel( 1 ); 
            List<Building> buildingList = buildingServiceProxy.queryBuilding4List(request,building);
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( buildingList, jsonConfig );
            
            responseJson(buildingServiceProxy.countByExample(building), jsonArr);
        } catch (Exception e) {
            responseJson(false, "失败!");
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

    
    public UserHasRoleServiceIFC getUserHasRoleServiceProxy() {
        return userHasRoleServiceProxy;
    }

    
    public void setUserHasRoleServiceProxy( UserHasRoleServiceIFC userHasRoleServiceProxy ) {
        this.userHasRoleServiceProxy = userHasRoleServiceProxy;
    }

    
    public RoleHasBuildingServiceIFC getRoleHasBuildingServiceProxy() {
        return roleHasBuildingServiceProxy;
    }

    
    public void setRoleHasBuildingServiceProxy( RoleHasBuildingServiceIFC roleHasBuildingServiceProxy ) {
        this.roleHasBuildingServiceProxy = roleHasBuildingServiceProxy;
    }
	
	
}
