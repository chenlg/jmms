/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.biz.service.handle.account;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jmms.biz.service.handle.exception.ServiceExceptions;
import com.jmms.common.service.facade.account.AccountJaxRsServiceFacade;
import com.jmms.common.service.response.account.jaxrs.UserJaxrsDTO;
import com.jmms.core.domain.account.AccountDomain;
import com.jmms.core.persistant.po.account.UserPO;

/**
 * Reason:	JaxRs接口实现类
 * 
 * @author chenlg
 * @version $Id: AccountJaxServiceFacade.java, v 0.1 2014年4月17日 下午3:11:42 chenlg Exp $
 * @since    JDK 1.7
 */
@Monitored
@Path("/account")
public class AccountJaxRsServiceFacadeHandle implements AccountJaxRsServiceFacade {
    
    private static Logger logger = LoggerFactory.getLogger(AccountJaxRsServiceFacadeHandle.class);

    @Autowired
    @Qualifier("accountDomain")
    private AccountDomain accountDomain;

    /**
     * @see com.jmms.common.service.facade.account.AccountJaxRsServiceFacade#getAsXml(java.lang.Integer)
     */
    @GET
    @Path("/{userId}.xml")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public UserJaxrsDTO getAsXml(@PathParam("userId") Integer userId) {
        UserPO user = accountDomain.getUser(userId);
        if (user == null) {
            String message = "用户不存在(id:" + userId + ")";
            logger.warn(message);
            throw ServiceExceptions.buildException(Status.NOT_FOUND, message);
        }
        UserJaxrsDTO userJaxrsDTO = new UserJaxrsDTO();
        BeanUtils.copyProperties(user, userJaxrsDTO);
        return userJaxrsDTO;
    }

   /**
    * @see com.jmms.common.service.facade.account.AccountJaxRsServiceFacade#getAsJson(java.lang.Integer)
    */
    @GET
    @Path("/{userId}.json")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public UserJaxrsDTO getAsJson(@PathParam("userId") Integer userId) {
        UserPO user = accountDomain.getUser(userId);
        if (user == null) {
            String message = "用户不存在(id:" + userId + ")";
            logger.warn(message);
            throw ServiceExceptions.buildException(Status.NOT_FOUND, message);
        }

        UserJaxrsDTO userJaxrsDTO = new UserJaxrsDTO();
        BeanUtils.copyProperties(user, userJaxrsDTO);
        return userJaxrsDTO;
    }

}
