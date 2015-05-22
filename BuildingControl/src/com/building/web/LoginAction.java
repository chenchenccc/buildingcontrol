package com.building.web;

import com.building.commons.base.BaseAction;
import com.building.service.ifc.UserServiceIFC;

@SuppressWarnings( "serial" )
public class LoginAction extends BaseAction {
    
    /**
     * @Description: 业务代理对象
     */
    private UserServiceIFC userServiceProxy;
    
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    public static final String LOGIN_FAILE = "LOGIN_FAILE";
    
    private String           username;
    private String           password;
    private String           validcode;
    
    /**
     * 登陆
     * 
     * @author chenrh
     * @return
     */
    public String login() {
        System.out.println( username );
        
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
    
}
