package com.fanvox;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public static String coversDir = "file:///E:/media/covers/";
    public static String videosDir = "file:///E:/media/videos/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/images/**").addResourceLocations(coversDir);
        registry.addResourceHandler("/api/videos/**").addResourceLocations(videosDir);
    }
}
