/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.facade.account;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.jmms.common.service.response.WsConstants;
import com.jmms.common.service.response.account.GetUserResult;
import com.jmms.common.service.response.account.dto.UserDTO;
import com.jmms.common.service.response.base.IdResult;
import com.jmms.common.service.response.base.WSResult;

/**
 * Reason:  JAX-WS2.0的WebService接口定义类.
 * 
 * 使用JAX-WS2.0 annotation设置WSDL中的定义.
 * 使用WSResult及其子类类包裹返回结果.
 * 使用DTO传输对象隔绝系统内部领域对象的修改对外系统的影响.
 * 
 * @author chenlg
 * @version $Id: AccountSoapServiceFacade.java, v 0.1 2014年4月16日 下午3:26:23 chenlg Exp $
 * @since    JDK 1.7
 */
@WebService(name = "AccountServiceFacade", targetNamespace = WsConstants.NS)
public interface AccountSoapServiceFacade {

    /**
     * 获取用户信息.
     * 
     * @param id
     * @return GetUserResult
     */
    GetUserResult getUser(@WebParam(name = "userId") Integer userId);

    /**
     * 新建用户.
     * 
     * @param user
     * @return IdResult
     */
    IdResult createUser(@WebParam(name = "user") UserDTO user);

    /**
     * 删除用户.
     * 
     * @param userId
     */
    WSResult deleteUser(@WebParam(name = "userId") Integer userId);
}
