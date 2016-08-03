package com.acesse.vcashadmin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${vcashadmin.service-base-url}")
    protected String serviceBaseUrl;
}
