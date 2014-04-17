/*
 * Copyright (c) 2014, lingang.chen@gmail.com  All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.jmms.common.service.response.base;

import javax.xml.bind.annotation.XmlType;

import com.jmms.common.service.response.WsConstants;

/**
 * Reason:	WebService返回结果基类,定义所有返回码. 
 * 
 * @author chenlg
 * @version $Id: WSResult.java, v 0.1 2014年4月16日 下午3:33:16 chenlg Exp $
 * @since    JDK 1.7
 */
@XmlType(name = "WSResult", namespace = WsConstants.NS)
public class WSResult {

    // -- 返回代码定义 --//
    // 按项目的规则进行定义, 比如4xx代表客户端参数错误，5xx代表服务端业务错误等.
    public static final String SUCESS               = "0";
    public static final String PARAMETER_ERROR      = "400";

    public static final String SYSTEM_ERROR         = "500";
    public static final String SYSTEM_ERROR_MESSAGE = "Runtime unknown internal error.";

    // -- WSResult基本属性 --//
    private String             code                 = SUCESS;
    private String             message;

    /**
     * 缺省的构造
     */
    public WSResult(){
        
    }
    
    /**
     * 创建结果.
     */
    public void setError(String resultCode, String resultMessage) {
        code = resultCode;
        message = resultMessage;
    }

    /**
     * 创建默认异常结果.
     */
    public void setDefaultError() {
        setError(SYSTEM_ERROR, SYSTEM_ERROR_MESSAGE);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
