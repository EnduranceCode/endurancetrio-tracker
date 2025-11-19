/*
 * Copyright (c) 2025-2025 Ricardo do Canto
 *
 * This file is part of the EnduranceTrio Tracker project.
 *
 * Licensed under the Functional Software License (FSL), Version 1.1, ALv2 Future License
 * (the "License");
 *
 * You may not use this file except in compliance with the License. You may obtain a copy
 * of the License at https://fsl.software/
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND WITHOUT WARRANTIES OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING WITHOUT LIMITATION WARRANTIES OF FITNESS FOR A PARTICULAR
 * PURPOSE, MERCHANTABILITY, TITLE OR NON-INFRINGEMENT.
 *
 * IN NO EVENT WILL WE HAVE ANY LIABILITY TO YOU ARISING OUT OF OR RELATED TO THE
 * SOFTWARE, INCLUDING INDIRECT, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES,
 * EVEN IF WE HAVE BEEN INFORMED OF THEIR POSSIBILITY IN ADVANCE.
 */

package com.endurancetrio.app.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration for the application.
 * <p>
 * This configuration sets up security rules for HTTP requests, including:
 * <ul>
 *   <li>Permitting all requests to the H2 database console endpoints.</li>
 *   <li>Requiring authentication for all other requests.</li>
 *   <li>Disabling CSRF protection for the H2 console endpoints to allow access.</li>
 *   <li>Disabling frame options headers to enable the H2 console to be displayed in a frame.</li>
 *   <li>Enabling form-based login for user authentication.</li>
 * </ul>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
        authorization -> authorization.requestMatchers("/h2-tracker", "/h2-tracker/**")
            .permitAll()
            .anyRequest()
            .authenticated());

    http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-tracker", "/h2-tracker/**"));

    http.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));

    http.formLogin(withDefaults());

    return http.build();
  }
}
