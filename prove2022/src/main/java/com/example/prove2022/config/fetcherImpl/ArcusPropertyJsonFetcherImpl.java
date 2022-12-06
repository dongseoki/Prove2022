package com.example.prove2022.config.fetcherImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jam2in.arcus.app.common.property.ArcusProperty;
import com.jam2in.arcus.app.common.property.ArcusPropertyJsonFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ArcusPropertyJsonFetcherImpl implements ArcusPropertyJsonFetcher {
//    @Override
//    public String getProperty() {
//        return null;
//    }

//    private final ArcusProperty property;
//
//    public ArcusPropertyJsonFetcherImpl(@Lazy ArcusProperty property) {
//        this.property = property;
//    }
//
//    @Autowired
//    public void setProperty(ArcusProperty property) {
//        this.property = (ArcusProperty)((ArcusProperty)property).clone();
//    }


//    @Autowired
//    public void setProperty(ArcusProperty property) {
//        this.property = (ArcusProperty) property.clone();
//    }

    @Override
    public String getProperty() {
        String rawData = "{\"propertiesFilePath\":\"arcusExpireTime.properties\",\"propertyJsonFilePath\":\"arcusCacheItems.json\",\"address\":\"172.30.1.60:2181,172.30.1.60:2182,172.30.1.60:2183\",\"serviceCode\":\"testServiceCode\",\"poolSize\":4,\"asyncOperationTimeout\":700,\"globalPrefix\":\"RELEASE\",\"enableCache\":true,\"enableLock\":true,\"exponentOfLocks\":11,\"recachingType\":\"NONE\",\"recachingThreadCount\":10,\"recachingQueueSize\":100,\"recachingTtlRatio\":10,\"cacheTargetEnable\":true,\"cacheTargetRequestUrl\":\"http://127.0.0.1:8080\",\"cacheTargetUpdateInterval\":36000}";
        return rawData;
//        try {
//            Thread.sleep(5);
//            return new ObjectMapper().writeValueAsString(property);
//        } catch (JsonProcessingException e) {
//            log.error(e.getMessage(), e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        return "";
    }

}
