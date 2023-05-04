package com.h.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Lin
 * @since: 2023-05-04
 */
@Component
public class AppConfig {

    @Value("${spring.mail.username}")
    private String mailUsername;

    public String getMailUsername() {
        return mailUsername;
    }
}
