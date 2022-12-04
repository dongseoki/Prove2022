package com.example.prove2022.test;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test-rest")
public class TestRestController {
    private final ApplicationContext applicationContext;
    private final TestService testService;

    public TestRestController(ApplicationContext applicationContext, TestService testService) {
        this.applicationContext = applicationContext;
        this.testService = testService;
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
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        switch (caseType){
            case "1":
                testService.getCase1();
                break;
            case "5":
                testService.getCase5(new User(id, name), id);
                break;
            case "6":
                int[] dataArr = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
                testService.getCase6(dataArr);
                break;
            case "10":
                Map<String, Object> tempMap = new HashMap();
                tempMap.put("id",id);
                tempMap.put("name",name);
                testService.getCase10(tempMap);
                break;
        }
        return "end";
    }
}
