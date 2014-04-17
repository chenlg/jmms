/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.response.base;

import javax.xml.bind.annotation.XmlType;

import com.jmms.common.service.response.WsConstants;

/**
 * Reason:	创建某个对象返回的 通用IdResult. 
 * 
 * @author chenlg
 * @version $Id: IdResult.java, v 0.1 2014年4月16日 下午3:34:19 chenlg Exp $
 * @since    JDK 1.7
 */
@XmlType(name = "IdResult", namespace = WsConstants.NS)
public class IdResult extends WSResult {
    
    private Integer id;

    public IdResult() {
    }

    public IdResult(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
