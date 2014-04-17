/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Reason:	 自定义日志注解. 
 * 
 * @author chenlg
 * @version $Id: AspectLogger.java, v 0.1 2014年3月12日 下午3:51:35 chenlg Exp $
 * @since    JDK 1.7
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectLogger {

    /**
     * 描述信息.
     * @return
     */
    String value();

    /**
     * 是否检测方法运行情况.
     */
    boolean discover() default false;
}
