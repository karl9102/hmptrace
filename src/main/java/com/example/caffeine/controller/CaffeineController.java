package com.example.caffeine.controller;

import com.example.caffeine.bean.UserInfo;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 * @author: wangY
 * @date: 2021/11/17
 * @description:
 */
@RestController
@Slf4j
public class CaffeineController {

    @Autowired
    Cache<String, Object> caffeineCache;

    @RequestMapping("caffeine/add")
    public String add(String id) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("张三");
        userInfo.setAge(13);
        userInfo.setSex("男");

        caffeineCache.put(String.valueOf(userInfo.getId()),userInfo);
        log.info("caffeineCache.put:"+userInfo.toString());
        return "add ok";
    }

    @RequestMapping("caffeine/update")
    public String update(String message) {



        //caffeineCache.put(String.valueOf(userInfo.getId()),userInfo);

        return "update ok";
    }

    @RequestMapping("caffeine/get")
    public String get(String id){

        caffeineCache.getIfPresent(id);
        UserInfo userInfo = (UserInfo) caffeineCache.asMap().get(id);
        if(null==userInfo){
            return "";
        }
        return userInfo.toString();
    }


    @RequestMapping("caffeine/del")
    public String del(String id) {


        caffeineCache.asMap().remove(id);

        return "del ok ";
    }

    @RequestMapping("caffeine/all")
    public String all(String id) {
        caffeineCache.asMap();
        return "all ok ";
    }


    @RequestMapping("caffeine/clean")
    public String cleanup() {
        caffeineCache.cleanUp();
        log.info("caffeineCache.cleanUp");
        return "caffeineCache.cleanUp";
    }


}
