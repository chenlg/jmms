/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.unit;

import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jmms.functional.unit.context.Profiles;
import com.jmms.functional.unit.jetty.JettyFactory;


/**
 * Reason:	 功能测试基类.. 
 *  <p>在整个测试期间启动一次Jetty Server, 并在每个TestCase Class执行前中重新载入默认数据.</p>
 *  
 * @author chenlg
 */
public class BaseUnitTestCase {

    protected static Server jettyServer;

    private static Logger   logger = LoggerFactory.getLogger(BaseUnitTestCase.class);

    @BeforeClass
    public static void initFunctionalTestEnv() throws Exception {
        Boolean isEmbedded = new URL(Profiles.baseUrl).getHost().equals("localhost")
                             && Profiles.embeddedForLocal;

        if (isEmbedded) {
            startJettyOnce();
        }
    }

    /**
     * 启动Jetty服务器, 仅启动一次.
     */
    protected static void startJettyOnce() throws Exception {
        if (jettyServer == null) {
            System.out.println("[HINT] set -XX:MaxPermSize=128m");

            // 设定Spring的profile
            Profiles.setProfileAsSystemProperty(Profiles.UNIT_TEST);

            jettyServer = JettyFactory.createServerInSource(new URL(Profiles.baseUrl).getPort());
            jettyServer.start();

            logger.info("Jetty Server started at {}", Profiles.baseUrl);
        }
    }

}
