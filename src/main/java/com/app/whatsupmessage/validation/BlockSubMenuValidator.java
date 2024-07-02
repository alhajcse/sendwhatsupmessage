/*
 * MPO Database at DSHE, DME and DTE( Module# 24)
 * These modules will ease MPO related information management in a
 * centralized manner and will reduce system overhead for providing different centralized services to the
 * administrators. It will ultimately ease information (related to MPO) access and analytics for DSHE, DME,
 * DTE, and other stakeholders
 * Copyright (c) IEIMS. All rights reserved.
 */

package com.app.whatsupmessage.validation;

import com.app.whatsupmessage.dto.BlockSubMenuDto;
import com.app.whatsupmessage.entity.BlockSubMenu;
import com.app.whatsupmessage.exception.CustomMessagePresentException;
import com.app.whatsupmessage.service.BlockSubMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import static com.app.whatsupmessage.constant.ValidatorConstants.ALREADY_EXIST;


@Component
@RequiredArgsConstructor
public class BlockSubMenuValidator implements Validator {

    private final BlockSubMenuService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return BlockSubMenuDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors error) {
        BlockSubMenuDto request = (BlockSubMenuDto) target;
        Optional<BlockSubMenu> subMenu= service.findByBlockSubMenuName(request.getBlockSubMenuName());
        if (subMenu.isPresent())
            throw new CustomMessagePresentException(ALREADY_EXIST);
    }
}