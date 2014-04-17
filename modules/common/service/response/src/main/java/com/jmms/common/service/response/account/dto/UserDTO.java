/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.response.account.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.jmms.common.service.response.WsConstants;

/**
 * Reason:	 Web Service传输User信息的DTO. 
 * 
 * <p>只传输外部接口需要的属性.使用JAXB 2.0的annotation标注JAVA-XML映射,尽量使用默认约定.
 * 
 * @author chenlg
 * @version $Id: UserDTO.java, v 0.1 2014年4月16日 下午3:59:28 chenlg Exp $
 * @since    JDK 1.7
 */
@XmlRootElement
@XmlType(name = "User", namespace = WsConstants.NS)
public class UserDTO implements Serializable {

    /**  */
    private static final long serialVersionUID = -1488587230177793787L;

    /**
     * 主键
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
     * 用户密码
     */
    private String            userPwd;
    /**
     * 用户邮件
     */
    private String            userEmail;
    /**
     * 状态
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

    /**
     * 重新实现toString()函数方便在日志中打印DTO信息.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
