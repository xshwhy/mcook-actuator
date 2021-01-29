package com.iotmars.config;

import com.iotmars.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: xsh
 * @date: 2021/1/28 11:07
 */
@Configuration
public class WebAuthConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new MyInterceptor()
        );
    }






}
