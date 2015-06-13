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
import com.building.model.Autho;
import com.building.model.Role;
import com.building.model.RoleHasAutho;
import com.building.model.User;
import com.building.service.ifc.AuthoServiceIFC;
import com.building.service.ifc.RoleHasAuthoServiceIFC;
import com.building.service.ifc.RoleServiceIFC;

@SuppressWarnings("serial")
public class RoleAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private RoleServiceIFC roleServiceProxy;
    private RoleHasAuthoServiceIFC roleHasAuthoServiceProxy;
    private AuthoServiceIFC authoServiceProxy;
    
	/**
	  * @Description:  实体对象
	  */
	private Role role;
    private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();	
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listRole(){
		List<Role> roleList = roleServiceProxy.queryRole4List(request,role);
		request.setAttribute("roleList", roleList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( roleList, jsonConfig );
        
        responseJson(roleServiceProxy.countByExample(role), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewRole(){
		Role _role = roleServiceProxy.queryRoleById( role.getId() );
		request.setAttribute("operate", "view");
		request.setAttribute("role", _role);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editRole(){
		Role _role = roleServiceProxy.queryRole4Bean(role);
		request.setAttribute("operate", "edit");
		request.setAttribute("role", _role);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditRole(){
		try {
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                role.setUpdateUserId( loginUser.getId() );
            }
            role.setUpdateTime( new Date() );
			roleServiceProxy.saveEditRole(role);
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
	public String addRole(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddRole(){
		try {
		    HttpSession session = request.getSession();
            User loginUser = (User) session.getAttribute( "loginUser" );
            if(loginUser != null) {
                role.setCreateUserId( loginUser.getId() );
            }
            role.setCreateTime( new Date() );
			roleServiceProxy.saveAddRole(role);
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
	public String delRole(){
		try {
		    role.setIsDel( 2 );
			roleServiceProxy.delRole(role);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	

    public String authoList(){
        try {
            RoleHasAutho roleAutho = new RoleHasAutho();
            roleAutho.setRoleId( role.getId() );
            List<RoleHasAutho> raList = roleHasAuthoServiceProxy.queryRoleHasAutho4List( request, roleAutho  );
            List<Autho> authoList = new ArrayList<Autho>();
            for (RoleHasAutho ra : raList) {
                Autho autho = authoServiceProxy.queryAuthoById( ra.getAuthoId() );
                if(autho != null) {
                    authoList.add( autho );
                }
            }
            request.setAttribute("authoList", authoList);
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( authoList, jsonConfig );
            
            responseJson(true, jsonArr);
        } catch (Exception e) {
            responseJson(false, "服务出错了!");
            RJLog.error(e);
        }
        return SUCCESS;
    }
    
    public String addAuthoList(){
        try {
            RoleHasAutho roleAutho = new RoleHasAutho();
            roleAutho.setRoleId( role.getId() );
            List<Autho> allList = authoServiceProxy.queryAutho4List( request, null );
            Autho smAutho = null;
            request.setAttribute("authoList", allList);
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
            
            jsonArr= JSONArray.fromObject( allList, jsonConfig );
            
            responseJson(true, jsonArr);
        } catch (Exception e) {
            responseJson(false, "服务出错了!");
            e.printStackTrace();
            RJLog.error(e);
        }
        return SUCCESS;
    }
	
	public RoleServiceIFC getRoleServiceProxy() {
		return roleServiceProxy;
	}
	public void setRoleServiceProxy(RoleServiceIFC roleServiceProxy) {
		this.roleServiceProxy = roleServiceProxy;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

    
    public RoleHasAuthoServiceIFC getRoleHasAuthoServiceProxy() {
        return roleHasAuthoServiceProxy;
    }

    
    public void setRoleHasAuthoServiceProxy( RoleHasAuthoServiceIFC roleHasAuthoServiceProxy ) {
        this.roleHasAuthoServiceProxy = roleHasAuthoServiceProxy;
    }

    
    public AuthoServiceIFC getAuthoServiceProxy() {
        return authoServiceProxy;
    }

    
    public void setAuthoServiceProxy( AuthoServiceIFC authoServiceProxy ) {
        this.authoServiceProxy = authoServiceProxy;
    }
	
	
}
