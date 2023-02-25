package com.cdu.chatappapi.config;

import com.cdu.chatappapi.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
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
        excludeList.add("/api/login");
        excludeList.add("/api/register");
        excludeList.add("/api/chat");
        excludeList.add("/api/group");
        excludeList.add("/api/group/message");
        excludeList.add("/img/*");
        excludeList.add("/index.html");
        excludeList.add("/");
        excludeList.add("/static/js/*");
        excludeList.add("/static/css/*");
        excludeList.add("/static/media/*");
        excludeList.add("/*");
        // 添加拦截器
        registry.addInterceptor(loginInterceptor).excludePathPatterns(excludeList);
    }
}
