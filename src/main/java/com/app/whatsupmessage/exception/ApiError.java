/*
 * MPO Database at DSHE, DME and DTE( Module# 24)
 * These modules will ease MPO related information management in a
 * centralized manner and will reduce system overhead for providing different centralized services to the
 * administrators. It will ultimately ease information (related to MPO) access and analytics for DSHE, DME,
 * DTE, and other stakeholders
 * Copyright (c) IEIMS. All rights reserved.
 */

package com.app.whatsupmessage.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiError {

    public static Map<String, String> fieldError(BindingResult bindingResult) {
        Map<String, String> fieldErrors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            errors.forEach(e -> {
                fieldErrors.put(e.getField(), e.getDefaultMessage());
            });
        }
        return fieldErrors;
    }
}


