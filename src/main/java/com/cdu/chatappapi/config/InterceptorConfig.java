package com.cdu.chatappapi.config;

import com.cdu.chatappapi.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 定义后端路由白名单
        ArrayList<String> excludeList = new ArrayList<>();
        excludeList.add("/**/.html");
        excludeList.add("/**/.js");
        excludeList.add("/login");
        excludeList.add("/register");
        excludeList.add("/img/*");
        // 添加拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(excludeList);
    }
}
