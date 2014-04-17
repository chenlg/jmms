/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.biz.service.handle.account;

import javax.jws.WebService;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.Validate;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;

import com.jmms.biz.service.handle.Validators;
import com.jmms.biz.service.handle.exception.ServiceExceptions;
import com.jmms.common.service.facade.account.AccountSoapServiceFacade;
import com.jmms.common.service.response.WsConstants;
import com.jmms.common.service.response.account.GetUserResult;
import com.jmms.common.service.response.account.dto.UserDTO;
import com.jmms.common.service.response.base.IdResult;
import com.jmms.common.service.response.base.WSResult;
import com.jmms.common.utils.annotation.AspectLogger;
import com.jmms.core.domain.account.AccountDomain;
import com.jmms.core.persistant.po.account.UserPO;

/**
 * Reason:	 SOAP接口实现类. 
 * 
 * @author chenlg
 * @version $Id: AccountSoapServiceFacadeHandle.java, v 0.1 2014年4月16日 下午4:10:56 chenlg Exp $
 * @since    JDK 1.7
 */
@Monitored
//serviceName指明WSDL中<wsdl:service>与<wsdl:binding>元素的名称, endpointInterface属性指向Interface类全称.
@WebService(serviceName = "AccountService", endpointInterface = "com.jmms.common.service.facade.account.AccountSoapServiceFacade", targetNamespace = WsConstants.NS)
public class AccountSoapServiceFacadeHandle extends Validators implements AccountSoapServiceFacade {

    private static Logger logger = LoggerFactory.getLogger(AccountSoapServiceFacadeHandle.class);

    @Autowired
    @Qualifier("accountDomain")
    private AccountDomain accountDomain;
    
    /** 
     * @see com.jmms.common.service.facade.account.AccountSoapServiceFacade#getUser(java.lang.Integer)
     */
    @Override
    @AspectLogger(value = "用户查询", discover = true)
    public GetUserResult getUser(Integer userId) {

        GetUserResult result = new GetUserResult();
        try {

            Validate.notNull(userId, "id参数为空");

            UserPO userPo = accountDomain.getUser(userId);

            Validate.notNull(userPo, "用户不存在(id:" + userId + ")");

            /*
             * 对象po转dto
             */
            UserDTO userDto = new UserDTO();
            BeanUtils.copyProperties(userPo, userDto);

            result.setUser(userDto);

        } catch (NullPointerException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
        } catch (IllegalArgumentException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
        } catch (RuntimeException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());

            result.setDefaultError();
        }

        return result;
    }

    /**
     * @see com.jmms.common.service.facade.account.AccountSoapServiceFacade#createUser(com.jmms.common.service.response.account.dto.UserDTO)
     */
    @Override
    @AspectLogger(value = "用户新增", discover = true)
    public IdResult createUser(UserDTO user) {
        IdResult result = new IdResult();
        UserPO userPo = null;
        try {
            Validate.notNull(user, "用户参数为空");

            userPo = new UserPO();
            /*
             * 复制对象
             */
            BeanUtils.copyProperties(user, userPo);
            /*
             * 验证对象-->这一步可以在DTO称呼
             */
            validateWithException(userPo);

            accountDomain.saveUser(userPo);

            return new IdResult(userPo.getUserId());
        } catch (ConstraintViolationException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
        } catch (RuntimeException e) {
            if (ServiceExceptions.isCausedBy(e, DuplicateKeyException.class)) {
                String message = "新建用户参数存在唯一性冲突(用户:" + userPo + ")";
                if (logger.isErrorEnabled())
                    logger.error(message, e.getMessage());
                result.setError(WSResult.PARAMETER_ERROR, message);
            } else {
                if (logger.isErrorEnabled())
                    logger.error(e.getMessage());
                result.setDefaultError();
            }
        }

        return result;
    }

    /**
     * @see com.jmms.common.service.facade.account.AccountSoapServiceFacade#deleteUser(java.lang.Integer)
     */
    @Override
    @AspectLogger(value = "用户删除", discover = true)
    public WSResult deleteUser(Integer userId) {
        WSResult result = new WSResult();
        try {
            Validate.notNull(userId, "用户ID为空");

            accountDomain.deleteUser(userId);
            result.setMessage("删除成功!");

        } catch (NullPointerException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
        } catch (ConstraintViolationException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
        } catch (RuntimeException e) {
            if (logger.isErrorEnabled())
                logger.error(e.getMessage());
            result.setDefaultError();
        }
        return result;
    }

}
