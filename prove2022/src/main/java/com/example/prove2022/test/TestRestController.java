package com.example.prove2022.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test-rest")
@Slf4j
public class TestRestController {
    private final TestService testService;

    public TestRestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/errortest")
    public String errorTest(){
        try{
            throw new IllegalAccessException("dont doit.");
        }catch(Exception e){
            log.info("test errror : {}", e.toString());
            log.info("test errror -----", e);
            log.info("test errror :", e);
        }
        return "test";
    }


    @GetMapping("/arcus-common-module-test/set-test")
    public String arcusCommonModuleSetTest(@RequestParam(value = "testKey") String testKey, @RequestParam(value="testData") String testData){
        testService.setTestData(testKey, testData);
        return "success";
    }

//    @GetMapping("/arcus-common-module-test/get-test")
//    public String arcusCommonModuleGetTest(@RequestParam(value = "testKey") String testKey){
//        String result = testService.getTestData(testKey);
//        return result;
//    }

    @GetMapping("/arcus-common-module-test/get-user")
    public String arcusCommonModuleGetUser(@RequestParam(value = "caseType") String caseType,
                                           @RequestParam(value = "id", required = false) Integer id,
                                           @RequestParam(value="name", required = false)String name,
                                           @RequestParam(value="data", required = false)String data){
        String result = "default";
        // ㅗㅑㄴㅇㄹㄴㅇㄹㄹㄴㅇㅇㄹㄴ
        switch (caseType){
            case "1":
                testService.getCase1();
                break;
            case "5":
                result = testService.getCase5(id).toString();
                break;
            case "6":
                int[] dataArr = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
                result = testService.getCase6(Arrays.stream(dataArr).boxed().collect(Collectors.toList())).toString();
                break;
            case "10":
                Map<String, Object> tempMap = new HashMap();
                tempMap.put("id",id);
                tempMap.put("name",name);
                testService.getCase10(tempMap);
                break;
        }
        return result;
    }
}
