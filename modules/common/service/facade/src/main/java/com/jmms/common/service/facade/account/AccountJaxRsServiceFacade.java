/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.facade.account;

import javax.ws.rs.PathParam;

import com.jmms.common.service.response.account.jaxrs.UserJaxrsDTO;
import com.jmms.common.utils.annotation.Description;

/**
 * Reason:	JAX-RS的WebService接口定义类.
 * 
 * @author chenlg
 * @version $Id: AccountJaxRsServiceFacade.java, v 0.1 2014年4月17日 下午3:28:21 chenlg Exp $
 * @since    JDK 1.7
 */
@Description
public interface AccountJaxRsServiceFacade {
    
    /**
     *  XML 格式浏览器访问路径.
     *  
     *  <pre>http://localhost:8080/jmms/cxf/jaxrs/user/1.xml</pre>
     * 
     * @param userId
     * @return {@link UserJaxrsDTO}
     */
    public UserJaxrsDTO getAsXml(@PathParam("userId") Integer userId);

    /**
     *  JSON 格式浏览器访问路径 : 
     *  
     * <code> http://localhost:8080/cmmi/cxf/jaxrs/user/1.json</code>
     * 
     * @param userId
     * @return {@link UserJaxrsDTO}
     */
    public UserJaxrsDTO getAsJson(@PathParam("userId") Integer userId);
}
