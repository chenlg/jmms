/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.core.persistant.po.account;

import java.io.Serializable;

/**
 * Reason:	 用户持久对象.
 * 
 * @author chenlg
 * @version $Id: UserPO.java, v 0.1 2014年4月16日 下午4:15:09 chenlg Exp $
 * @since    JDK 1.7
 */
public class UserPO implements Serializable {

    /**  */
    private static final long serialVersionUID = 2191541268713927325L;

    /**
     * 用户主键
     */
    private Integer           userId;

    /**
     * 用户名
     */
    private String            userName;

    /**
     * 登录名
     */
    private String            userAccount;

    /**
     * 登录密码
     */
    private String            userPwd;

    /**
     * 用户邮箱
     */
    private String            userEmail;

    /**
     * 用户状态
     */
    private Boolean           status;

    /**
     * 权限
     */
    private String            permissions;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

}
