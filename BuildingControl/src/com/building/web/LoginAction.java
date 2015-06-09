package com.building.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.building.commons.base.BaseAction;
import com.building.model.Role;
import com.building.model.User;
import com.building.service.ifc.RoleServiceIFC;
import com.building.service.ifc.UserServiceIFC;

@SuppressWarnings( "serial" )
public class LoginAction extends BaseAction {
    
    /**
     * @Description: 业务代理对象
     */
    private UserServiceIFC userServiceProxy;
    private RoleServiceIFC roleServiceProxy;
    
    
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOGIN_FAILE = "LOGIN_FAILE";
    
    private String           username;
    private String           password;
    private String           validcode;
    
    private JSONArray jsonArr = null;
    
    /**
     * 登陆
     * 
     * @author chenrh
     * @return
     */
    public String login() throws Exception{
        // 1、验证验证码是否匹配
        HttpSession session = request.getSession();
        String v = (String) session.getAttribute( "validcode" );
        if( !validcode.equals( v )) {
            System.out.println("验证码错误");
            request.setAttribute("login_msg", "验证码错误"); // 用户对象
            return LOGIN_FAILE;
        }
        // 2、判断用户名是否存在
        User user = userServiceProxy.checkUsername(username);
        if(user == null) {
            System.out.println("用户名不存在");
            request.setAttribute("login_msg", "用户名不存在"); // 用户对象
            return LOGIN_FAILE;
        }
        // 3、判断密码是否正确
        if( !password.equals( user.getPassword() )) {
            System.out.println("密码错误");
            request.setAttribute("login_msg", "密码错误"); // 用户对象
            return LOGIN_FAILE;
        }
        
        // 登陆成功，设置用户为在线
        request.setAttribute("login_msg", "登陆成功");
        System.out.println("登陆成功");
        user.setIsOnline( 1L );
        user.setLastLogin( new Date() );
        userServiceProxy.saveEditUser( user );
        // TODO 验证成功, 获取权限等...
        // 设置密码为空
        user.setPassword( "" );
        // 设置用户
        request.setAttribute("loginUser", user);
        // 存入session
        session.setAttribute( "loginUser", user );
        // 设置角色
        Integer userId = user.getId();
        List<Role> list = userServiceProxy.getRoleList(userId);
        StringBuffer loginRoleName = new StringBuffer();
        List<Integer> roleIds = new ArrayList<Integer>();
        if(list == null || list.size() == 0) {
            System.out.println("该用户没有角色");
            request.setAttribute( "loginRoleName", "暂无角色" );
            return LOGIN_SUCCESS;
        }
        
        for (Role r : list) {
            loginRoleName.append( r.getRoleName() ).append( "," );
            roleIds.add( r.getId() );
        }
        request.setAttribute("loginRoleName", loginRoleName.toString());

        return LOGIN_SUCCESS;
    }
    
    public UserServiceIFC getUserServiceProxy() {
        return userServiceProxy;
    }


    
    public void setUserServiceProxy( UserServiceIFC userServiceProxy ) {
        this.userServiceProxy = userServiceProxy;
    }


    public String getUsername() {
        return username;
    }
    
    public void setUsername( String username ) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword( String password ) {
        this.password = password;
    }
    
    public String getValidcode() {
        return validcode;
    }
    
    public void setValidcode( String validcode ) {
        this.validcode = validcode;
    }

    
    public RoleServiceIFC getRoleServiceProxy() {
        return roleServiceProxy;
    }

    
    public void setRoleServiceProxy( RoleServiceIFC roleServiceProxy ) {
        this.roleServiceProxy = roleServiceProxy;
    }
    
}
