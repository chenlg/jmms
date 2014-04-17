/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.account;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.jmms.common.service.response.account.jaxrs.UserJaxrsDTO;
import com.jmms.functional.unit.BaseUnitTestCase;
import com.jmms.functional.unit.context.Profiles;

/**
 * Reason:	 对基于JAX-RS的实现Restful的测试.
 * 
 * @author chenlg
 * @version $Id: AccountJaxRsDynamicClientFT.java, v 0.1 2014年4月17日 下午3:44:14 chenlg Exp $
 * @since    JDK 1.7
 */
public class AccountJaxRsDynamicClientFT extends BaseUnitTestCase {

    private static String resourceUrl  = Profiles.baseUrl + "/cxf/jaxrs/account";

    private RestTemplate  restTemplate = new RestTemplate();

    @Test
    public void getUser() {
        UserJaxrsDTO user = restTemplate.getForObject(resourceUrl + "/{userId}.xml",
            UserJaxrsDTO.class, new Integer(1));
        assertEquals("admin", user.getUserAccount());

        try {
            user = restTemplate.getForObject(resourceUrl + "/{userId}.json", UserJaxrsDTO.class,
                new Integer(1));
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
        }

        assertEquals("admin", user.getUserAccount());
    }
}
