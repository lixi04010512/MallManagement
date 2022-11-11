package com.jide.security.security;

import com.jide.security.utils.JwtTokenUtils;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * token配置
 */
public class JwtTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenUtils jwtTokenUtils;

    public JwtTokenConfigurer(JwtTokenUtils jwtTokenUtils){

        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Override
    public void configure(HttpSecurity http) {
        JwtAuthenticationTokenFilter customFilter = new JwtAuthenticationTokenFilter(jwtTokenUtils);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
