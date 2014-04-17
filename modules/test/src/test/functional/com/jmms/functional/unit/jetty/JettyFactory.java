/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.unit.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Reason:	 创建Jetty Server的工厂类.
 * 
 * @author chenlg
 */
public class JettyFactory {

    public static final String DEFAULT_WEBAPP_PATH = "../../server/src/main/webapp";

    public static final String CONTEXT_PATH        = "/jmms";

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port) {
        Server server = new Server();
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, CONTEXT_PATH);

        server.setHandler(webContext);

        return server;
    }

    /**
     * 快速重新启动application，重载所有target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        //        
        //运行需要的模块
        classLoader.addClassPath(JMMS_BIZ_PROCESS);
        classLoader.addClassPath(JMMS_BIZ_SERVICE_HANDLE);
        classLoader.addClassPath(JMMS_BIZ_SHARED);
        classLoader.addClassPath(JMMS_COMMON_SERVICE_FACADE);
        classLoader.addClassPath(JMMS_COMMON_SERVICE_REMOTE);
        classLoader.addClassPath(JMMS_COMMON_SERVICE_RESPONSE);
        classLoader.addClassPath(JMMS_COMMON_SHARED);
        classLoader.addClassPath(JMMS_COMMON_UTILS);
        classLoader.addClassPath(JMMS_CORE_DOMAIN);
        classLoader.addClassPath(JMMS_CORE_PERSISTANT_PO);
        classLoader.addClassPath(JMMS_CORE_PERSISTANT_REPOSITORY);
        classLoader.addClassPath(JMMS_CORE_PROCESS);
        classLoader.addClassPath(JMMS_CORE_SHARED);

        //当前
        classLoader.addClassPath("target/classes");
        classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }

    public static final String JMMS_BIZ_PROCESS                = "../../modules/biz/process/target/classes";
    public static final String JMMS_BIZ_SERVICE_HANDLE         = "../../modules/biz/service/handle/target/classes";
    public static final String JMMS_BIZ_SHARED                 = "../../modules/biz/shared/target/classes";
    public static final String JMMS_COMMON_SERVICE_FACADE      = "../../modules/common/service/facade/target/classes";
    public static final String JMMS_COMMON_SERVICE_REMOTE      = "../../modules/common/service/remote/target/classes";
    public static final String JMMS_COMMON_SERVICE_RESPONSE    = "../../modules/common/service/response/target/classes";
    public static final String JMMS_COMMON_SHARED              = "../../modules/common/shared/target/classes";
    public static final String JMMS_COMMON_UTILS               = "../../modules/common/utils/target/classes";
    public static final String JMMS_CORE_DOMAIN                = "../../modules/core/domain/target/classes";
    public static final String JMMS_CORE_PERSISTANT_PO         = "../../modules/core/persistant/po/target/classes";
    public static final String JMMS_CORE_PERSISTANT_REPOSITORY = "../../modules/core/persistant/repository/target/classes";
    public static final String JMMS_CORE_PROCESS               = "../../modules/core/process/target/classes";
    public static final String JMMS_CORE_SHARED                = "../../modules/core/shared/target/classes";

    
    
}
