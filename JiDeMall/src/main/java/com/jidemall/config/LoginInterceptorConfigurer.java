package com.jidemall.config;

import com.jidemall.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建自定义拦截器的对象
        HandlerInterceptor interceptor=new LoginInterceptor();
        List<String> patterns=new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/js/**");
        patterns.add("/images/**");
        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/index.html");
        patterns.add("/users/regist");
        patterns.add("/users/login");
        patterns.add("/users/send");
        patterns.add("/users/test_email_code");

        //完成拦截器注册
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
    //springboot中配置addResourceHandler和addResourceLocations，使得可以从磁盘中读取图片、视频、音频等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/JideMall/src/main/resources/static/upload/");
    }
}
