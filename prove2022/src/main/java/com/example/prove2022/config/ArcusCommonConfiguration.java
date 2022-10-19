package com.example.prove2022.config;

import com.example.prove2022.config.aspect.ArcusAnnotationAspect;
//import com.example.prove2022.config.aspect.ArcusJsonAspect;
import com.example.prove2022.config.fetcherImpl.ArcusCacheItemJsonFetcherImpl;
import com.example.prove2022.config.fetcherImpl.ArcusPropertyJsonFetcherImpl;
import com.jam2in.arcus.app.common.config.ArcusConfiguration;
import com.jam2in.arcus.app.common.item.ArcusCacheItemJsonFetcher;
import com.jam2in.arcus.app.common.item.ArcusCacheItemUpdateScheduler;
import com.jam2in.arcus.app.common.item.ArcusCacheItemUpdater;
import com.jam2in.arcus.app.common.property.ArcusPropertyJsonFetcher;
import com.jam2in.arcus.app.common.property.ArcusPropertyUpdateScheduler;
import com.jam2in.arcus.app.common.property.ArcusPropertyUpdater;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@Import(ArcusConfiguration.class)
/* Arcus 프로퍼티 로딩 */
@PropertySource("classpath:arcus.properties")
/*
Annotation 기반의 캐싱을 위한 @Aspect Annotation 활성화
이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
SpringBoot의 경우 proxyTargetClass=true가 default 이므로 true 설정 생략 가능
*/
@EnableAspectJAutoProxy(proxyTargetClass=true)
/*
Arcus 프로퍼티, 캐시 대상 목록 업데이트를 위한 @Scheduler Annotation 활성화.
이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
*/
@EnableScheduling
public class ArcusCommonConfiguration {
    private final ArcusConfiguration arcusConfiguration;
    /*
    Fetcher 기반의 Arcus 프로퍼티, 캐싱 대상 목록 업데이트를 위한 bean 주입 설정
    이 기능을 사용하지 않을 경우 아래의 field 및 생성자의 파라미터 내용을 생략한다.
    */
//    private final ArcusPropertyJsonFetcher propertyJsonFetcher;
//    private final ArcusCacheItemJsonFetcher cacheItemJsonFetcher;

//    public ArcusCommonConfiguration(ArcusConfiguration arcusConfiguration,
//                                    ArcusPropertyJsonFetcherImpl propertyJsonFetcher, ArcusCacheItemJsonFetcherImpl
//                                            cacheItemJsonFetcher) {
//        this.arcusConfiguration = arcusConfiguration;
//        this.propertyJsonFetcher = propertyJsonFetcher;
//        this.cacheItemJsonFetcher = cacheItemJsonFetcher;
//    }

    public ArcusCommonConfiguration(ArcusConfiguration arcusConfiguration) {
        this.arcusConfiguration = arcusConfiguration;
    }
    /* Arcus 프로퍼티를 사용하기 위한 설정 */
    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    /*
    Annotation 기반의 캐싱을 위한 Aspect bean 생성.
    이 기능을 사용하지 않는다면 아래의 내용을 생략한다.
    */
    @Bean
    public ArcusAnnotationAspect arcusAnnotationAspect() {
        return new ArcusAnnotationAspect(arcusConfiguration);
    }
    /*
    JSON 기반의 캐싱을 위한 Aspect bean 생성.
    이 기능을 사용하지 않는다면 아래의 내용을 생략한다.
    */
//    @Bean
//    public ArcusJsonAspect arcusJsonAspect() {
//        return new ArcusJsonAspect(arcusConfiguration);
//    }

    /*
    Fetcher 기반의 Arcus 프로퍼티 업데이트를 위한 bean 생성.
    이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
    */
//    @Bean
//    public ArcusPropertyUpdater arcusPropertyUpdater() {
//        /* Fetcher 구현 방법은 1-3 항목 참고. */
//        return new ArcusPropertyUpdater(propertyJsonFetcher);
//    }

    /*
    Fetcher 기반의 Arcus 프로퍼티 업데이트를 주기적으로 하기 위한 bean 생성.
    1-2 항목의 arcus.cronProperty에 설정된 스케줄에 따라 업데이트 된다.
    이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
    5
    */
//    @Bean
//    public ArcusPropertyUpdateScheduler arcusPropertyUpdateScheduler() {
//        return new ArcusPropertyUpdateScheduler(arcusPropertyUpdater());
//    }
//    @Bean
/*
Fetcher 기반의 캐시 대상 목록 업데이트를 위한 bean 생성.
이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
*/
//    public ArcusCacheItemUpdater arcusCacheItemUpdater() {
//        return new ArcusCacheItemUpdater(arcusConfiguration.arcusCacheItemManager(),
//                /* Fetcher 구현 방법은 1-3 항목 참고. */
//                cacheItemJsonFetcher);
//    }
    /*
    Fetcher 기반의 캐시 대상 목록 업데이트를 주기적으로 하기 위한 bean 생성.
    1-2 항목의 arcus.cronProperty에 설정된 스케줄에 따라 업데이트 된다.
    이 기능을 사용하지 않을 경우 아래의 내용을 생략한다.
    */
//    @Bean
//    public ArcusCacheItemUpdateScheduler arcusCacheItemUpdateScheduler() {
//        return new ArcusCacheItemUpdateScheduler(arcusCacheItemUpdater());
//    }



}