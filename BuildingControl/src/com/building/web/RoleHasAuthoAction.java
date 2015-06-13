package com.building.web;

import java.util.List;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.RJLog;
import com.building.model.RoleHasAutho;
import com.building.service.ifc.RoleHasAuthoServiceIFC;

@SuppressWarnings("serial")
public class RoleHasAuthoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private RoleHasAuthoServiceIFC roleHasAuthoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private RoleHasAutho roleHasAutho;
	private String authoIds;
	
    public String getAuthoIds() {
        return authoIds;
    }

    
    public void setAuthoIds( String authoIds ) {
        this.authoIds = authoIds;
    }

    /**
	  * @Description: 获取实体列表 
	  */
	public String listRoleHasAutho(){
		List<RoleHasAutho> roleHasAuthoList = roleHasAuthoServiceProxy.queryRoleHasAutho4List(request,roleHasAutho);
		request.setAttribute("roleHasAuthoList", roleHasAuthoList);
		return LIST_SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewRoleHasAutho(){
		RoleHasAutho _roleHasAutho = roleHasAuthoServiceProxy.queryRoleHasAutho4Bean(roleHasAutho);
		request.setAttribute("operate", "view");
		request.setAttribute("roleHasAutho", _roleHasAutho);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editRoleHasAutho(){
		RoleHasAutho _roleHasAutho = roleHasAuthoServiceProxy.queryRoleHasAutho4Bean(roleHasAutho);
		request.setAttribute("operate", "edit");
		request.setAttribute("roleHasAutho", _roleHasAutho);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditRoleHasAutho(){
		try {
			roleHasAuthoServiceProxy.saveEditRoleHasAutho(roleHasAutho);
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
	public String addRoleHasAutho(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddRoleHasAutho(){
		try {
		    if(authoIds != null) {
                String[] idArr = authoIds.split( "," );
                for (String s : idArr) {
                    roleHasAutho.setAuthoId( Integer.parseInt( s ) );
                    roleHasAutho.setId( null );
                    roleHasAutho.setIsDel( 1 );
                    RoleHasAutho ur = roleHasAuthoServiceProxy.queryRoleHasAutho4Bean( roleHasAutho );
                    if(ur == null) {
                        roleHasAuthoServiceProxy.saveAddRoleHasAutho( roleHasAutho);
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
	public String delRoleHasAutho(){
		try {
		    roleHasAutho.setIsDel( 2 );
			roleHasAuthoServiceProxy.delRoleHasAutho(roleHasAutho);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public RoleHasAuthoServiceIFC getRoleHasAuthoServiceProxy() {
		return roleHasAuthoServiceProxy;
	}
	public void setRoleHasAuthoServiceProxy(RoleHasAuthoServiceIFC roleHasAuthoServiceProxy) {
		this.roleHasAuthoServiceProxy = roleHasAuthoServiceProxy;
	}
	public RoleHasAutho getRoleHasAutho() {
		return roleHasAutho;
	}
	public void setRoleHasAutho(RoleHasAutho roleHasAutho) {
		this.roleHasAutho = roleHasAutho;
	}
}
