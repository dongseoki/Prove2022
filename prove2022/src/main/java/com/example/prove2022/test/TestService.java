package com.example.prove2022.test;

import com.jam2in.arcus.app.common.aop.ArcusCache;
import com.jam2in.arcus.app.common.aop.ArcusCacheKey;
import com.jam2in.arcus.app.common.aop.ArcusCacheKeyParameter;
import com.jam2in.arcus.app.common.key.ArcusCacheKeyDate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    private final Map<String, String> testDataMap = new HashMap<>();
    private final Map<String, User> testUserMap = new HashMap<>();

    @PostConstruct
    public void postMethod(){
        testUserMap.put("case1", new User());

        //for case6
        for (int i = 1; i < 6; i++) {
            testUserMap.put(""+ i +" u"+i ,new User(i,"u"+i));
        }
    }

//    @ArcusCache
//    public String getTestData(@ArcusCacheKey String testKey){
//        return testDataMap.get(testKey);
//
//    }

    public void setTestData(String testKey, String testData){
        testDataMap.put(testKey, testData);
    }


    // guide 시작.
    // 1) APP_USER:case1#20220101
    @ArcusCache(prefix="_USER", key="case1", expireTime="EXPIRE_TIME_1_MIN", keyDate= ArcusCacheKeyDate.KEY_DATE_DAY)
    public User getCase1() {
        return testUserMap.get("case1");
    }


//    // 2) APP:user.UserService.case2
//    @ArcusCache(expireTime="60")
//    public List<User> case2() {...}
//    // 3) APP:user.UserService.case3@ARG0=<id=1,name=arcus>
//    @ArcusCache
//    public User case3(
//            @ArcusCacheKeyParameter("id, "name") User user) {...}
//    // 4) APP:user.UserService.case4@ARG0=<*=1>
//    @ArcusCache
//    public User case4(@ArcusCacheKey int userId) {...}


//    // 5) APP:user.UserService.case5@ARG0=<id=1,name=arcus>,ARG1=<*=1>
    @ArcusCache
    public User getCase5(
            @ArcusCacheKeyParameter({"id", "name"}) User user,@ArcusCacheKey int userId) {
        return testUserMap.get(user.getId()+" "+user.getName());
    }

    // 6) APP:user.UserService.case6@ARG0=<*=[1,2,3]>
//    @ArcusCache
    public List<User> getCase6(int[] userIds) {
        List<User> li = new ArrayList();
        for (int userId :
                userIds) {
            li.add(testUserMap.get(userId + " u"+userId));
        }
        return li;
    }
//    // 7) APP:user.UserService.case7@ARG0=<*=[1,2,3]>
//    @ArcusCache public List<User> case7(@ArcusCacheKey List<Integer> userIds
//    ) {...}
//    // 8) APP:user.UserService.case8@ARG0=<id=[1,2,3]>
//    @ArcusCache
//    public List<User> case8(@ArcusCacheKeyParameter("id") User[] users) {...}
//    // 9) APP:user.UserService.case9@ARG0=<id=[1,2,3]>
//    @ArcusCache
//    public List<User> case9(@ArcusCacheKeyParameter("id") List<User> users) {...}

    // 10) APP:user.UserService.case10@ARG0=<id=1,name=arcus>
    @ArcusCache
    public User getCase10(@ArcusCacheKeyParameter({"id", "name"}) Map<String, Object> user
    ) {
        return testUserMap.get(""+user.get("id").toString() + " "+user.get("name").toString());
    }
    // 11) APP:user.UserService.case11@ARG0=<*={id=1,name=arcus}>
//    @ArcusCache
//    public User case11(@ArcusCacheKeyParameter("*") Map<String, Object> user
//    ) {...}

    // 12) APP:user.UserService.case12@ARG0=<*={id=1,name=arcus}>
//    @ArcusCache
//    public User case12(@ArcusCacheKeyParameter("*") User user) {...}


    // 13) APP:user.UserService.case13@ARG0=<friend.id=2>
//    @ArcusCache
//    public User case13(@ArcusCacheKeyParameter("friend.id") User user) {...}
//    // 14) APP:user.UserService.case14@ARG0=<friendMap.id=2>
//    @ArcusCache
//    public User case14(@ArcusCacheKeyParameter("friendMap.id") User user) {...}
//    // 15) APP:user.UserService.case15@ARG0=<friendArray.id=[2,3,4]>
//    @ArcusCache
//    public User case15(@ArcusCacheKeyParameter("friendArray.id") User user) {...}
//    // 16) APP:user.UserService.case16@ARG0=<friendList.id=[2,3,4]>
//    @ArcusCache
//    public User case16(@ArcusCacheKeyParameter("friendList.id") User user) {...}
//    // 17) APP:user.UserService.case17@ARG0=<mobileNumberArray=[010,011,012]>
//    @ArcusCache
//    public User case17(@ArcusCacheKeyParameter("mobileNumberArray") User user
//    ) {...}
//    // 18) APP:user.UserService.case18@ARG0=<mobileNumberList=[010,011,012]>
//    public User case18(@ArcusCacheKeyParameter("mobileNumberList") User user
//    ) {...}
//    // 19) APP:user.UserService.case19@ARG0=<friend.*={id=2,name=arcus}>
//    public User case19(@ArcusCacheKeyParameter("friend.*") User user) {...}
//30
//    // 20) APP:user.UserService.case20@ARG0=<friendMap.*={id=2,name=arcus}>
//    public User case20(@ArcusCacheKeyParameter("friendMap.*") User user) {...}
}
