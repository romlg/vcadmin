package com.acesse.vcashadmin.service;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AccountingService {
    String sqlDisplay();

    String sqlDisplayWithMemberId();
}
