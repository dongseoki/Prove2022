package com.example.prove2022.test;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ToString
public class User implements Serializable {
    private int id;
    private String name;
    private String[] mobileNumberArray;
    private List<String> mobileNumberList;
    private User[] friendArray;
    private List<User> friendList;
    private User friend;
    private Map<String, Object> friendMap;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMobileNumberArray() {
        return mobileNumberArray;
    }

    public void setMobileNumberArray(String[] mobileNumberArray) {
        this.mobileNumberArray = mobileNumberArray;
    }

    public List<String> getMobileNumberList() {
        return mobileNumberList;
    }

    public void setMobileNumberList(List<String> mobileNumberList) {
        this.mobileNumberList = mobileNumberList;
    }

    public User[] getFriendArray() {
        return friendArray;
    }

    public void setFriendArray(User[] friendArray) {
        this.friendArray = friendArray;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public Map<String, Object> getFriendMap() {
        return friendMap;
    }

    public void setFriendMap(Map<String, Object> friendMap) {
        this.friendMap = friendMap;
    }

    //...
///* 내부 Field를 가지고 Arcus Key를 생성하기 위해선
//반드시 모든 Field의 getter 메소드가 존재해야 함 */
}