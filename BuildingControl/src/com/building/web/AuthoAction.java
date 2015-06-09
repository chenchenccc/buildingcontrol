package com.building.web;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.building.commons.base.BaseAction;
import com.building.commons.utils.JsonDateValueProcessor;
import com.building.commons.utils.RJLog;
import com.building.model.Autho;
import com.building.service.ifc.AuthoServiceIFC;

@SuppressWarnings("serial")
public class AuthoAction extends BaseAction{
	/**
	  * @Description: 业务代理对象 
	  */
	private AuthoServiceIFC authoServiceProxy;
	
	/**
	  * @Description:  实体对象
	  */
	private Autho autho;
	private JSONArray jsonArr = null;
    private JsonConfig jsonConfig = new JsonConfig();
	
	/**
	  * @Description: 获取实体列表 
	  */
	public String listAutho(){
		List<Autho> authoList = authoServiceProxy.queryAutho4List(request,autho);
		request.setAttribute("authoList", authoList);
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); // 默认 yyyy-MM-dd hh:mm:ss
        
        jsonArr= JSONArray.fromObject( authoList, jsonConfig );
        
        responseJson(authoServiceProxy.countByExample(autho), jsonArr);
        return SUCCESS;
	}
	
	/**
	  * @Description: 查看实体对象 
	  */
	public String viewAutho(){
		Autho _autho = authoServiceProxy.queryAutho4Bean(autho);
		request.setAttribute("operate", "view");
		request.setAttribute("autho", _autho);
		return VIEW_SUCCESS;
	}
	
	/**
	  * @Description: 编辑实体对象 
	  */
	public String editAutho(){
		Autho _autho = authoServiceProxy.queryAutho4Bean(autho);
		request.setAttribute("operate", "edit");
		request.setAttribute("autho", _autho);
		return EDIT_SUCCESS;
	}
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public String saveEditAutho(){
		try {
			authoServiceProxy.saveEditAutho(autho);
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
	public String addAutho(){
		request.setAttribute("operate", "add");
		return ADD_SUCCESS;
	}
	
	/**
	  * @Description: 保存添加实体对象 
	  */
	public String saveAddAutho(){
		try {
			authoServiceProxy.saveAddAutho(autho);
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
	public String delAutho(){
		try {
			authoServiceProxy.delAutho(autho);
			responseJson(true, "删除成功!");
		} catch (Exception e) {
			responseJson(false, "删除失败!");
			RJLog.error(e);
		}
		return SUCCESS;
	}
	
	public AuthoServiceIFC getAuthoServiceProxy() {
		return authoServiceProxy;
	}
	public void setAuthoServiceProxy(AuthoServiceIFC authoServiceProxy) {
		this.authoServiceProxy = authoServiceProxy;
	}
	public Autho getAutho() {
		return autho;
	}
	public void setAutho(Autho autho) {
		this.autho = autho;
	}
}
