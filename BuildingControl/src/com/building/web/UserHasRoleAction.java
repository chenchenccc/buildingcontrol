package com.building.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.UserHasRole;
import com.building.service.ifc.UserHasRoleServiceIFC;

@SuppressWarnings("serial")
public class UserHasRoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private UserHasRoleServiceIFC userHasRoleServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private UserHasRole userHasRole;
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();	
    private String roleIds;
	
    public String getRoleIds() {
        return roleIds;
    }

    
    public void setRoleIds( String roleIds ) {
        this.roleIds = roleIds;
    }

    /**
	  * @Description: 获取实体列表 
	  */
	public String listUserHasRole(){
		List<UserHasRole> userHasRoleList = userHasRoleServiceProxy.queryUserHasRole4List(request,userHasRole);
		request.setAttribute("userHasRoleList", userHasRoleList);
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( userHasRoleList, jsonConfig );
        
        responseJson(userHasRoleServiceProxy.countByExample(userHasRole), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewUserHasRole(){
		UserHasRole _userHasRole = userHasRoleServiceProxy.queryUserHasRole4Bean(userHasRole);
		request.setAttribute("operate", "view");
		request.setAttribute("userHasRole", _userHasRole);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editUserHasRole(){
		UserHasRole _userHasRole = userHasRoleServiceProxy.queryUserHasRole4Bean(userHasRole);
		request.setAttribute("operate", "edit");
		request.setAttribute("userHasRole", _userHasRole);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditUserHasRole(){
		try {
			userHasRoleServiceProxy.saveEditUserHasRole(userHasRole);
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
	public String addUserHasRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddUserHasRole(){
		try {
		    if(roleIds != null) {
                String[] idArr = roleIds.split( "," );
                for (String s : idArr) {
                    userHasRole.setRoleId( Integer.parseInt( s ) );
                    userHasRole.setId( null );
                    userHasRole.setUserId( userHasRole.getUserId());
                    userHasRole.setIsDel( 1 );
                    UserHasRole ur = userHasRoleServiceProxy.queryUserHasRole4Bean( userHasRole );
                    if(ur == null) {
                        userHasRoleServiceProxy.saveAddUserHasRole( userHasRole);
                    }
                }
                
            }
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
	public String delUserHasRole(){
		try {
		    userHasRole.setIsDel( 2 );
			userHasRoleServiceProxy.delUserHasRole(userHasRole);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public UserHasRoleServiceIFC getUserHasRoleServiceProxy() {
		return userHasRoleServiceProxy;
	}
	public void setUserHasRoleServiceProxy(UserHasRoleServiceIFC userHasRoleServiceProxy) {
		this.userHasRoleServiceProxy = userHasRoleServiceProxy;
	}
	public UserHasRole getUserHasRole() {
		return userHasRole;
	}
	public void setUserHasRole(UserHasRole userHasRole) {
		this.userHasRole = userHasRole;
	}
}
