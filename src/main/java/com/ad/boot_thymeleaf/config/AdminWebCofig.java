package com.ad.boot_thymeleaf.config;

import com.ad.boot_thymeleaf.interceptor.loginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现handlerInterceptor接口
 * 2.拦截器注册到一个容器中（通过实现WebMvcConfigurer的addInterceptor）
 * 3.指定拦截规则
 */
@Configuration
public class AdminWebCofig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginIntercepter())
                .addPathPatterns("/**")//所有请求都被拦截
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**");//放行的请求
    }
}
