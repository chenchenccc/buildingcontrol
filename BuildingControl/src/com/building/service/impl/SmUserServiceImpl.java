package com.building.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.dao.ifc.SmUserDAO;
import com.building.model.SmUser;
import com.building.model.SmUserExample;
import com.building.model.SmUserExample.Criteria;
import com.building.service.ifc.SmUserServiceIFC;

public class SmUserServiceImpl implements SmUserServiceIFC {
	/**
	  * @Description: DAO对象 
	  */
	private SmUserDAO smUserDao;
	
	/**
	  * @Description: 获取实体列表 
	  */
	public List<SmUser> querySmUser4List(HttpServletRequest request, SmUser smUser) {
		//构造Criteria
		SmUserExample example = new SmUserExample();
		Criteria criteria = example.createCriteria();
	
		return smUserDao.selectByExample(example);
	}
	
	
	/**
	  * @Description: 查看实体对象 
	  */
	public SmUser querySmUser4Bean(SmUser smUser) {
		SmUser _smUser = null;
		//构造Criteria
		SmUserExample example = new SmUserExample();
		Criteria criteria = example.createCriteria();
	
		List<SmUser> list= smUserDao.selectByExample(example);
		if(list != null && list.size() >= 0){
			_smUser = list.get(0);
		}
	return _smUser;
	}
	/**
	  * @Description: 保存添加实体对象 
	  */
	public void saveAddSmUser(SmUser smUser) {
		smUserDao.insert(smUser);
	}
	
	
	/**
	  * @Description: 保存编辑实体对象 
	  */
	public void saveEditSmUser(SmUser smUser) {
		smUserDao.updateByPrimaryKey(smUser);
	}
	
	
	/**
	  * @Description: 删除实体对象 
	  */
	public void delSmUser(SmUser smUser) {
		smUserDao.updateByPrimaryKeySelective(smUser);
	}
	
	public SmUserDAO getSmUserDao() {
		return smUserDao;
	}
	public void setSmUserDao(SmUserDAO smUserDao) {
		this.smUserDao = smUserDao;
	}
}
