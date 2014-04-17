/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
/**
 * Reason:  公共注解.
 * 
 * <p>说明该注解将被包含在javadoc中
 *		{@link @Documented <tt>@Documented</tt>}}
 * <p>这个注解可以是类注解，也可以是方法的注解  
 *		{@link Target <tt>@Target({ ElementType.TYPE, ElementType.METHOD })</tt>}}  
 * <p>定义的这个注解是注解会在class字节码文件中存在，在运行时可以通过反射获取到.
 * 		{@link @Retention <tt> @Retention(RetentionPolicy.RUNTIME)</tt>}} 
 * <p>子类可以继承父类中的该注解 
 * 		{@link @Inherited <tt>@Inherited</tt>}}
 * 
 * @author chenlg
 */
package com.jmms.common.utils.annotation;