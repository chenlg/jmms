/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.account;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.jmms.common.service.facade.account.AccountSoapServiceFacade;
import com.jmms.common.service.response.account.GetUserResult;
import com.jmms.common.service.response.account.dto.UserDTO;
import com.jmms.common.service.response.base.IdResult;
import com.jmms.common.service.response.base.WSResult;
import com.jmms.functional.unit.BaseUnitTestCase;
import com.jmms.functional.unit.data.UnitRandom;

/**
 * Reason: AccountService Web服务的功能测试
 * 
 * <p>运行方法直接初始化jetty web 服务器
 * 
 * @author chenlg
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ContextConfiguration(locations = { "/soap-client.xml" })
public class AccountSoapDynamicClientFT extends BaseUnitTestCase {

    @Autowired
    private AccountSoapServiceFacade accountSoapClientFacade;

    /**
     * 测试获取用户.
     */
    @Test
    public void getUser() {
        GetUserResult response = accountSoapClientFacade.getUser(new Integer(1));
        assertEquals("admin", response.getUser().getUserAccount());
    }

    /**
     * 测试创建用户.
     */
    @Test
    public void createUser() {
        UserDTO user = new UserDTO();
        String userName = UnitRandom.randomName("admin");
        user.setUserName(userName);
        user.setUserPwd("123456");
        user.setUserEmail(userName + "@gmail.com");
        user.setUserAccount(userName);
        user.setStatus(true);

        IdResult response = accountSoapClientFacade.createUser(user);
        Assert.assertNotNull("Id", response.getId());
    }

    /**
     * 测试删除用户.
     */
    @Test
    public void deleteUser() {
        WSResult response = accountSoapClientFacade.deleteUser(new Integer(17));
        assertEquals("0", response.getCode());
    }
}
