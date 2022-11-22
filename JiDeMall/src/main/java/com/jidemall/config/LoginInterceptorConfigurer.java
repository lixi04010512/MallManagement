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
        patterns.add("/assets/**");
        patterns.add("/img/**");
        patterns.add("/javascripts/**");
        patterns.add("/stylesheets/**");
        patterns.add("/users/regist");
        patterns.add("/users/login");
        patterns.add("/users/send");
        patterns.add("/users/test_email_code");
        patterns.add("/users/register_html");
        patterns.add("/users/login_html");
        patterns.add("/users/index_html");
        patterns.add("/user/products/findProductList");

        //完成拦截器注册
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
    }
    //springboot中配置addResourceHandler和addResourceLocations，使得可以从磁盘中读取图片、视频、音频等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/JideMall/src/main/resources/static/upload/");
    }
}
