package com.example.prove2022.test;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test-rest")
public class TestRestController {
    private final TestService testService;

    public TestRestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/arcus-common-module-test/set-test")
    public String arcusCommonModuleSetTest(@RequestParam(value = "testKey") String testKey, @RequestParam(value="testData") String testData){
        testService.setTestData(testKey, testData);
        return "success";
    }

    @GetMapping("/arcus-common-module-test/get-test")
    public String arcusCommonModuleGetTest(@RequestParam(value = "testKey") String testKey){
        String result = testService.getTestData(testKey);
        return result;
    }

    @GetMapping("/user/{id}")
    public String arcusUserTest(@PathVariable long id) {
        testService.getCase1(id);
        return "end";
    }

    @GetMapping("/arcus-common-module-test/get-user")
    public String arcusCommonModuleGetUser(@RequestParam(value = "caseType") String caseType,
                                           @RequestParam(value = "id", required = false) Integer id,
                                           @RequestParam(value="name", required = false)String name,
                                           @RequestParam(value="data", required = false)String data){
        switch (caseType){
            case "1":
                testService.getCase1(id);
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
