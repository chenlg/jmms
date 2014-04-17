/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.biz.service.handle;

import java.util.Set;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Reason:	JSR303 Validator(Hibernate Validator)工具类.
 * 
 * @author chenlg
 * @version $Id: Validators.java, v 0.1 2014年4月16日 下午4:52:05 chenlg Exp $
 * @since    JDK 1.7
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class Validators {

    @Autowired
    @Qualifier("validator")
    private Validator validator;

    /**
     * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
     */
    protected void validateWithException(Object object, Class<?>... groups)
                                                                           throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
