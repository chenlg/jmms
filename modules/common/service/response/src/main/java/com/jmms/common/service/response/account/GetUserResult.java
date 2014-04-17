/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.response.account;

import com.jmms.common.service.response.account.dto.UserDTO;
import com.jmms.common.service.response.base.WSResult;

/**
 * Reason:	 查询用户返回类. 
 * 
 * @author chenlg
 * @version $Id: GetUserResult.java, v 0.1 2014年4月16日 下午4:04:51 chenlg Exp $
 * @since    JDK 1.7
 */
public class GetUserResult extends WSResult {
    
    private UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    
    
}
