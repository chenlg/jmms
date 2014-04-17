/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Reason: 表示该类或者方法为描述方法.无实际意义.
 * 
 * @author chenlg
 * @version $Id: Description.java, v 0.1 2014年3月12日 下午3:51:35 chenlg Exp $
 * @since    JDK 1.7
 */
@Retention(RetentionPolicy.SOURCE)  
@Target({ ElementType.TYPE, ElementType.PACKAGE,ElementType.METHOD }) 
public @interface Description {

}
