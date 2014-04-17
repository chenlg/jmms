/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.core.shared.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jmms.common.utils.annotation.AspectLogger;


/**
 * Reason:	 核心层日志拦截器.
 * 
 * @author chenlg
 * @version $Id: CoreAspect.java, v 0.1 2014年2月24日 下午4:23:02 chenlg Exp $
 * @since    JDK 1.7
 */
@Component
@Aspect
public class CoreAspect {

    private static Logger logger = LoggerFactory.getLogger("CORE_ASPECT_DIGEST");

    /** 
     * 添加业务逻辑方法切入点 
     */
    @Pointcut("execution(*  com.cmmi.core..*.*(..)) ")
    public void corePointcut() {
        // 定义一个pointcut，下面用Annotation标注的通知方法可以公用这个pointcut  
    }

    /**
     * 异常通知.
     * 
     * @param jionpoint
     * @param e
     */
    @AfterThrowing(pointcut = "corePointcut() &&  @annotation(aspectLogger)", throwing = "e")
    public void throwingAdvice(JoinPoint jionpoint, AspectLogger aspectLogger, Exception e) {
        /*
         * 获取被调用的类名.  
         */
        String targetClassName = jionpoint.getTarget().getClass().getName();
        /*
         * 获取被调用的方法名.
         */
        String targetMethodName = jionpoint.getSignature().getName();
        /*
         * 注解日志描述.
         */
        String desc = aspectLogger.value();
        /*
         * 日志格式字符串.
         */
        StringBuilder aspectMessage = new StringBuilder();

        aspectMessage.append("[日志]:业务(").append(desc).append("),方法(").append(targetClassName)
            .append(".").append(targetMethodName).append(")").append(",状态(异常)");

        /*
         * 日志记录.
         */
        logger.info(aspectMessage.toString());
    }

    /**
     * 环绕通知.
     * 
     * @param jionpoint
     * @return
     * @throws Throwable
     */
    @Around("corePointcut() &&  @annotation(aspectLogger)")
    public Object aroundAdvice(ProceedingJoinPoint jionpoint, AspectLogger aspectLogger)
                                                                                        throws Throwable {
        /*
         * 起始时间.
         */
        long l1 = System.currentTimeMillis();
        /*
         * 注解日志描述.
         */
        String desc = aspectLogger.value();
        /*
         * 获取被调用的方法名.  
         */
        String targetMethodName = jionpoint.getSignature().getName();
        /*
         * 获取被调用类名.
         */
        String targetClassName = jionpoint.getTarget().getClass().getName();
        /*
         * 运行方法.
         */
        Object o = jionpoint.proceed();
        /*
         * 结束时间.
         */
        long l2 = System.currentTimeMillis();
        /*
         * 日志格式字符串.
         */
        StringBuilder aspectMessage = new StringBuilder();

        aspectMessage.append("[日志]:业务(").append(desc).append("),方法(").append(targetClassName)
            .append(".")
            .append(targetMethodName)
            .append("),时间(")
            .append(l2 - l1)
            .append("ms)")
            .append(",状态(正常)");

        /*
         * 日志记录.
         */
        logger.info(aspectMessage.toString());

        //Object o = jionpoint.proceed();//注意写到这儿的话，环绕通知和其它通知的顺序  
        return o;
    }
}
