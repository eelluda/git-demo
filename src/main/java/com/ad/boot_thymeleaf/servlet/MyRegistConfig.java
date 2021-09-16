package com.ad.boot_thymeleaf.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet servlet = new MyServlet();
        return new ServletRegistrationBean(servlet,"/my");
    }

    @Bean
    public FilterRegistrationBean MyFilter (){
        MyFilter myFilter = new MyFilter();
//        return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean MyListener(){
        MyServeletContextLitsener litsener = new MyServeletContextLitsener();
        return new ServletListenerRegistrationBean(litsener);
    }
}
