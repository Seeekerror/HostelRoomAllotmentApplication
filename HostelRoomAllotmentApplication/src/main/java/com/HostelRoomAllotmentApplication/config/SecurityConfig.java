package com.HostelRoomAllotmentApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SecurityConfig {

    @Bean

    public String securityConfiguration() {

        return "Security Configuration Loaded";
    }
}