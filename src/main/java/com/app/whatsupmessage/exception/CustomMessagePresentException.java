/*
 * MPO Database at DSHE, DME and DTE( Module# 24)
 * These modules will ease MPO related information management in a
 * centralized manner and will reduce system overhead for providing different centralized services to the
 * administrators. It will ultimately ease information (related to MPO) access and analytics for DSHE, DME,
 * DTE, and other stakeholders
 * Copyright (c) IEIMS. All rights reserved.
 */

package com.app.whatsupmessage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomMessagePresentException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 14L;

    public CustomMessagePresentException(String s) {
        super(s);
    }

}
