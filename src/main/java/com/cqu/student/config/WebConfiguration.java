package com.cqu.student.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer{
    //读取文件上传的路径
    @Value("${files.upload.path}")
    private String fileUpload;

    //读取文件映射路径
    @Value("${files.upload.fileMapper}")
    private String fileMapper;

    /**
     * 处理跨域访问请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }

    /**
     * 配置静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileMapper+"**").addResourceLocations("file"+fileUpload);
    }
}
