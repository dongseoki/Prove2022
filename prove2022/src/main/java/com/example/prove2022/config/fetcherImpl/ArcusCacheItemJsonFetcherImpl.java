package com.example.prove2022.config.fetcherImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.jam2in.arcus.app.common.item.ArcusCacheItemJsonFetcher;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArcusCacheItemJsonFetcherImpl implements ArcusCacheItemJsonFetcher {
    @Override
    public List<String> getArcusCacheItems() {
        List<String> value = new ArrayList<>();
        try {
            JsonMapper mapper = new JsonMapper();
            File from = new File("src/main/resources/arcusCacheFetcherItems.json");
            JsonNode jsonNode = mapper.readTree(from);
            for (JsonNode node : jsonNode) {
                value.add(node.toString());
            }
        } catch (IOException e) {
            System.out.println("aaa");
        }
        return value;
    }
}
