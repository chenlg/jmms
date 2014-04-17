/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.database;

import java.sql.Driver;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.jmms.functional.unit.context.Profiles;

/**
 * Reason:	 unit环境基础数据初始化. 
 * 
 * @author chenlg
 */
public class InitClass {

    protected static SimpleDriverDataSource dataSource;
    
    /**
     * 初始化
     * @throws Exception 
     */
    @Test
    public void initEnv() throws Exception{
        buildDataSourceOnce();
        reloadSampleData();
    }

    /**
     * 构造数据源，仅构造一次.
     */
    @SuppressWarnings("unchecked")
    protected void buildDataSourceOnce() throws ClassNotFoundException {
        if (dataSource == null) {
            dataSource = new SimpleDriverDataSource();
            dataSource.setDriverClass((Class<? extends Driver>) Class.forName(Profiles.jdbcDriver));
            dataSource.setUrl(Profiles.jdbcUrl);
            dataSource.setUsername(Profiles.jdbcUsername);
            dataSource.setPassword(Profiles.jdbcPassword);

        }
    }

    /**
     * 载入默认数据.
     */
    protected void reloadSampleData() throws Exception {
        DataFixtures.executeScript(dataSource, "classpath:data/" + Profiles.dbType + "/cleanup-data.sql",
            "classpath:data/" + Profiles.dbType + "/import-data.sql");
    }
    
    /**
     * Reason:	 SQL数据文件导入工具类. 
     * 
     * @author chenlg
     */
    public static class DataFixtures{
        public static final String    DEFAULT_ENCODING = "UTF-8";

        private static ResourceLoader resourceLoader   = new DefaultResourceLoader();

        public static void executeScript(DataSource dataSource, String... sqlResourcePaths)
                                                                                           throws DataAccessException {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            for (String sqlResourcePath : sqlResourcePaths) {
                Resource resource = resourceLoader.getResource(sqlResourcePath);
                JdbcTestUtils.executeSqlScript(jdbcTemplate, new EncodedResource(resource,
                    DEFAULT_ENCODING), true);
            }
        }
    }
    
   
}
