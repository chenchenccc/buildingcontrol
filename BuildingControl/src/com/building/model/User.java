package com.building.model;

import java.util.Date;

public class User {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.id
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.username
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private String username;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.password
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private String password;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.last_login
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private Date lastLogin;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.is_online
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private Long isOnline;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user.is_del
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    private Integer isDel;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.last_login
     *
     * @return the value of user.last_login
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.last_login
     *
     * @param lastLogin the value for user.last_login
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.is_online
     *
     * @return the value of user.is_online
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Long getIsOnline() {
        return isOnline;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.is_online
     *
     * @param isOnline the value for user.is_online
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setIsOnline(Long isOnline) {
        this.isOnline = isOnline;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user.is_del
     *
     * @return the value of user.is_del
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user.is_del
     *
     * @param isDel the value for user.is_del
     *
     * @ibatorgenerated Fri May 22 23:01:52 CST 2015
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}