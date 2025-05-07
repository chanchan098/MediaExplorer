/*package com.example.mediaexplorer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Value("${myResourceRoot2}")
    private String myResourceRoot2;

//    https://www.baeldung.com/spring-mvc-static-resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        List<String> list = Arrays.stream(myResourceRoot2.split("/")).collect(Collectors.toList());
        String last = list.get(list.size() - 1);

        registry.addResourceHandler("/"+last+"/**")
                .addResourceLocations( "file:///"+myResourceRoot2+"/");

//      确保默认的静态资源路径不被覆盖
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/","classpath:/templates/");


    }
}
*/