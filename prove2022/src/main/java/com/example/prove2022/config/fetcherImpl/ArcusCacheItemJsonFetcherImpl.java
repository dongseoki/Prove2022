package com.example.prove2022.config.fetcherImpl;

import com.jam2in.arcus.app.common.item.ArcusCacheItemJsonFetcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArcusCacheItemJsonFetcherImpl implements ArcusCacheItemJsonFetcher {
    @Override
    public List<String> getArcusCacheItems() {
        return null;
    }
}
