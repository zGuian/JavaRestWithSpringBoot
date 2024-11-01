package com.estudos.JavaRestWithSpringBoot.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.OriginPatterns:default}")
    private String corsOriginPatterns = "";

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        // via QUERY PARAM
//        configurer.favorParameter(true)
//            .parameterName("mediaType").ignoreAcceptHeader(true)
//            .useRegisteredExtensionsOnly(false)
//            .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML);

        // via HEADER PARAM
        configurer.favorParameter(false)
            .parameterName("mediaType").ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowedOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins(allowedOrigins)
                .allowCredentials(true);
    }
}
