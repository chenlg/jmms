/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.test.domain.account;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jmms.core.domain.account.impl.AccountDomainImpl;
import com.jmms.core.persistant.po.account.UserPO;
import com.jmms.core.persistant.repository.account.UserMybatisDao;
import com.jmms.functional.unit.data.UnitRandom;

/**
 * Reason:	 Mockito 单元测试.
 *  
 *   <p>增加代码覆盖率
 *   
 * @author chenlg
 */
public class AccountDomainClientTest {

    @InjectMocks
    private AccountDomainImpl accountDomain;

    @Mock
    private UserMybatisDao    userDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void saveUser() {
        UserPO user = new UserPO();
        String userName = UnitRandom.randomName("admin");
        user.setUserName(userName);
        user.setUserPwd("123456");
        user.setUserEmail(userName + "@gmail.com");
        user.setUserAccount(userName);
        user.setStatus(true);

        // 正常保存用户.
        accountDomain.saveUser(user);
        Mockito.verify(userDao, Mockito.never()).delete(new Integer(1));
    }
}
