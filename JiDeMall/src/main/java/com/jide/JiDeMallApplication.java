package com.jide;

import com.jide.security.security.JwtAuthenticationTokenFilter;
import com.jide.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
public class JiDeMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiDeMallApplication.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public FilterRegistrationBean<JwtAuthenticationTokenFilter> registration(JwtAuthenticationTokenFilter filter) {
        FilterRegistrationBean<JwtAuthenticationTokenFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }
}
