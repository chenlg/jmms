/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.test.repository.account;


import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.jmms.core.persistant.po.account.UserPO;
import com.jmms.core.persistant.repository.account.UserMybatisDao;
import com.jmms.functional.unit.data.UnitRandom;
import com.jmms.test.SpringTransactionalTestCase;
/**
 * Reason:	 Dao单元测试. 
 * 
 * @author chenlg
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-mybatis.xml" })
public class UserMybatisDaoTest extends SpringTransactionalTestCase {
    
    @Autowired
    private UserMybatisDao userDao;

    @Test
    public void getUser() throws Exception {
        UserPO user = userDao.get(new Integer(1));
        assertThat(user).as("User not found").isNotNull();
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

        int count = countRowsInTable("ss_user");
        userDao.save(user);
        Integer id = user.getUserId();

        assertThat(countRowsInTable("ss_user")).isEqualTo(count + 1);
        UserPO result = userDao.get(id);
        assertThat(result.getUserAccount()).isEqualTo(user.getUserName());

        // delete
        userDao.delete(id);
        assertThat(countRowsInTable("ss_user")).isEqualTo(count);
        assertThat(userDao.get(id)).isNull();
        
    }
    
}
