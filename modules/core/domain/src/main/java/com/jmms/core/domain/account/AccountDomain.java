/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.core.domain.account;

import com.jmms.core.persistant.po.account.UserPO;

/**
 * Reason:	 用户领域接口类. 
 * 
 * @author chenlg
 * @version $Id: AccountDomain.java, v 0.1 2014年4月16日 下午4:21:48 chenlg Exp $
 * @since    JDK 1.7
 */
public interface AccountDomain {
    
    /**
     * 根据userId 获取用户记录对象.
     */
    UserPO getUser(Integer userId);

    /**
     * 根据用户对象新增用户记录.
     */
    void saveUser(UserPO userPO);

    /**
     * 根据userId 删除用户记录.
     */
    void deleteUser(Integer userId);

}
