package com.example.prove2022.config;

import com.himart.arcus.config.ArcusConfig;
import com.himart.arcus.manager.ArcusCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Import({
        ArcusConfig.class
})
@PropertySource("classpath:arcus.properties")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ArcusCommonConfiguration {
    @Autowired
    private ArcusCacheManager arcusCacheManager;

    @PostConstruct
    public void postConstruct() {
        arcusCacheManager.connect(); }
    @PreDestroy
    public void preDestroy() {
        arcusCacheManager.disconnect(); }


    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }



}
