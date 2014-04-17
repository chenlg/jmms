/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.utils.others;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * Reason:	 封装各种生成唯一性ID算法的工具类.. 
 * 
 * @author chenlg
 * @version $Id: Identities.java, v 0.1 2014年4月16日 下午2:30:33 chenlg Exp $
 * @since    JDK 1.7
 */
public class Identities {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

}
