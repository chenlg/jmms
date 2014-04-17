/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.core.domain.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jmms.core.domain.account.AccountDomain;
import com.jmms.core.persistant.po.account.UserPO;
import com.jmms.core.persistant.repository.account.UserMybatisDao;

/**
 * Reason:	 用户领域接口实现类. 
 * 
 * @author chenlg
 * @version $Id: AccountDomainImpl.java, v 0.1 2014年4月16日 下午4:22:45 chenlg Exp $
 * @since    JDK 1.7
 */
@Component("accountDomain")
@Transactional(readOnly = true)
public class AccountDomainImpl implements AccountDomain {

    @Autowired
    private UserMybatisDao userDao;

    /**
     * @see com.jmms.core.domain.account.AccountDomain#getUser(java.lang.Integer)
     */
    @Override
    public UserPO getUser(Integer userId) {
        return userDao.get(userId);
    }

    /**
     * @see com.jmms.core.domain.account.AccountDomain#saveUser(com.jmms.core.persistant.po.account.UserPO)
     */
    @Override
    @Transactional(readOnly = false)
    public void saveUser(UserPO userPO) {
        userDao.save(userPO);
    }

    /**
     * @see com.jmms.core.domain.account.AccountDomain#deleteUser(java.lang.Integer)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteUser(Integer userId) {
        userDao.delete(userId);
    }

}
