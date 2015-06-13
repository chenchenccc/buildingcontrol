package com.building.service.ifc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.building.model.Role;
import com.building.model.User;

public interface UserServiceIFC {
	
	/**
	 * @Description: 获取实体列表 
	 */
	List<User> queryUser4List(HttpServletRequest request, User user);
	
	
	/**
	 * @Description: 查看实体对象 
	 */
	User queryUser4Bean(User user);
	
	
	/**
	 * @Description: 保存添加实体对象 
	 */
	void saveAddUser(User user);
	
	
	/**
	 * @Description: 保存编辑实体对象 
	 */
	void saveEditUser(User user);
	
	
	/**
	 * @Description: 删除实体对象
	 */
	void delUser(User user);
	
	
	/**
	 * @Description: 实体列表总数
	 */
	int countByExample(User user);
	
	
	/**
	 * @Description: 根据ID查询对象
	 */
	User queryUserById( Integer id);

	/**
	 * 验证用户名是否存在
	 * @author chenrh
	 *
	 * @param username
	 * @return
	 */
    User checkUsername( String username );

    /**
     * 获取角色列表 
     * @author chenrh
     *
     * @param userId
     * @return
     */
    List<Role> getRoleList( Integer userId );
    
    /**
     * 更新密码
     * @author chenrh
     *
     * @param smUser
     */
    void updataPassword( User user );
	
}
