package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.commons.global.PageBean;
import com.building.dao.ifc.AuthoDAO;
import com.building.model.Autho;
import com.building.model.AuthoExample;
import com.building.model.AuthoExample.Criteria;
import com.building.service.ifc.AuthoServiceIFC;

public class AuthoServiceImpl implements AuthoServiceIFC {
	/**
	 * @Description: DAO对象 
	 */
	private AuthoDAO authoDao;
	
	/**
	 * @Description: 获取实体列表 
	 */
	public List<Autho> queryAutho4List(HttpServletRequest request, Autho autho) {
		//构造Criteria
		AuthoExample example = new AuthoExample();
		Criteria criteria = example.createCriteria();
	
		return authoDao.selectByExample(example);
	}
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	public Autho queryAutho4Bean(Autho autho) {
		Autho _autho = null;
		//构造Criteria
		AuthoExample example = new AuthoExample();
		Criteria criteria = example.createCriteria();
	
		List<Autho> list= authoDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_autho = list.get(0);
		}
	return _autho;
	}
	/**
	 * @Description: 保存添加实体对象 
	 */
	public void saveAddAutho(Autho autho) {
		authoDao.insert(autho);
	}
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	public void saveEditAutho(Autho autho) {
		authoDao.updateByPrimaryKey(autho);
	}
	
	
	/**
	 * @Description: 删除实体对象 
	 */
	public void delAutho(Autho autho) {
		authoDao.updateByPrimaryKeySelective(autho);
	}
	
	/**
	 * @Description: 实体列表总数 
	 */
	public int countByExample(Autho autho) {
	  AuthoExample example = new AuthoExample();
	  Criteria criteria = example.createCriteria();
	  criteria.andIsDelEqualTo( 1 );
	  return authoDao.countByExample(example);
	}
	
	/**
	 * @Description: 根据ID获取对象 
	 */
	public Autho queryAuthoById(Integer id) {
	  return authoDao.selectByPrimaryKey(id);
	}
	
	public AuthoDAO getAuthoDao() {
		return authoDao;
	}
	public void setAuthoDao(AuthoDAO authoDao) {
		this.authoDao = authoDao;
	}
}
