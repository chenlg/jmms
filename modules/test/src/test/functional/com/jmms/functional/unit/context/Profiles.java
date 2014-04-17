/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.unit.context;

import com.jmms.common.utils.others.PropertiesLoader;

/**
 * Reason:	 Spring profile 常用方法与profile名称.
 *      <p>单元测试在test 模块下.系统资源加载只在该resources下</p> 
 * 
 * @author chenlg
 */
public class Profiles {

    public static final String ACTIVE_PROFILE = "spring.profiles.active";

    public static final String UNIT_TEST      = "functional";

    /**
     * 在Spring启动前，设置profile的环境变量。
     */
    public static void setProfileAsSystemProperty(String profile) {
        System.setProperty(ACTIVE_PROFILE, profile);
    }

    protected static PropertiesLoader propertiesLoader = new PropertiesLoader(
                                                           "classpath:/application.functional.properties");

    static {
        baseUrl = propertiesLoader.getProperty("baseUrl");
        embeddedForLocal = propertiesLoader.getBoolean("embeddedForLocal");

        /* 数据库配置 */
        jdbcDriver = propertiesLoader.getProperty("jdbc.driver");
        jdbcUrl = propertiesLoader.getProperty("jdbc.url");
        jdbcUsername = propertiesLoader.getProperty("jdbc.username");
        jdbcPassword = propertiesLoader.getProperty("jdbc.password");
        dbType = propertiesLoader.getProperty("db.type");

    }

    public static final String        baseUrl;
    public static final boolean       embeddedForLocal;
    public static final String        jdbcDriver;
    public static final String        jdbcUrl;
    public static final String        jdbcUsername;
    public static final String        jdbcPassword;
    public static final String        dbType;

}
