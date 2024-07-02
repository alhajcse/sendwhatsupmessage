/*
 * MPO Database at DSHE, DME and DTE( Module# 24)
 * These modules will ease MPO related information management in a
 * centralized manner and will reduce system overhead for providing different centralized services to the
 * administrators. It will ultimately ease information (related to MPO) access and analytics for DSHE, DME,
 * DTE, and other stakeholders
 * Copyright (c) IEIMS. All rights reserved.
 */
package com.app.whatsupmessage.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties("storage")
public class StorageProperties {

    private final String filesDir = "/var/www/html/IEIMS/DSHE-MPO";
    private final String profileImageDir = "profile-images";
    private final String host = "103.4.145.245";
    private final Integer port = 62233;
    private final String username = "IEIMS";
    private final String password = "IEIMS@dev#123";

}
