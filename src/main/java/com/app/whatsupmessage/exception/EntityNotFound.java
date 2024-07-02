/*
 * MPO Database at DSHE, DME and DTE( Module# 24)
 * These modules will ease MPO related information management in a
 * centralized manner and will reduce system overhead for providing different centralized services to the
 * administrators. It will ultimately ease information (related to MPO) access and analytics for DSHE, DME,
 * DTE, and other stakeholders
 * Copyright (c) IEIMS. All rights reserved.
 */

package com.app.whatsupmessage.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityNotFound extends Exception {
    private int status;
    private String message;

    public EntityNotFound(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
