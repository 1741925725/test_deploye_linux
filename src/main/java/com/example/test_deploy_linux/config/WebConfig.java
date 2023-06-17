package com.example.test_deploy_linux.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 王康
 * @Description: TODO
 * @DateTime: 2023/6/17 17:35
 **/
@Configuration//相当于是一个applicationContext-mvc.xml
public class WebConfig implements WebMvcConfigurer {
    /**
     * 注册一个字符编码过滤器
     *spring 提供的
     * 注：只有当spring.http.encoding.enabled=false配置成false后，过滤器才起作用
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){

        //创建一个spring提供的过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //强制编码
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");

        //filter注册bean
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(characterEncodingFilter);
        //要过滤的路径
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
