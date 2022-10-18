package com.example.prove2022.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {
    private final Map<String, String> testDataMap = new HashMap<>();

    public String getTestData(String testKey){
        return testDataMap.get(testKey);
    }

    public void setTestData(String testKey, String testData){
        testDataMap.put(testKey, testData);
    }
}
