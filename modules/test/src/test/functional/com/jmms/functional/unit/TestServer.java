/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.functional.unit;

import org.eclipse.jetty.server.Server;

import com.jmms.functional.unit.context.Profiles;
import com.jmms.functional.unit.jetty.JettyFactory;

/**
 * 使用Jetty运行调试Web应用, 在Console快速重载应用.
 * 
 * @author chenlg
 */
public class TestServer {
    
    public static final int    PORT    = 8080;
    
    public static final String CONTEXT = "/jmms";
    
    public static void main(String[] args) throws Exception {
        
        // 设定Spring的profile
        Profiles.setProfileAsSystemProperty(Profiles.UNIT_TEST);

        // 启动Jetty
        Server server = JettyFactory.createServerInSource(PORT);

        try {
            //
            System.out.println("[HINT]  -XX:MaxPermSize=128m");

            server.start();
            System.out.println("Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("[HINT] Hit Enter to reload the application quickly");

            // 等待用户输入回车重载应用.
            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
