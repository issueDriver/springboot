package com.zuojie.controller;

import com.zuojie.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class IndecController {
    ReentrantLock lock=new ReentrantLock();

    @Autowired
    private RedisService redisService;
    @RequestMapping("/setToken")
    public String setToken(String value){
        lock.lock();
        String tokenKey=UUID.randomUUID()+"";
        redisService.setString(tokenKey+"",value,20L);
        lock.unlock();
        return "success";
    }

    @RequestMapping("/getToken")
    public  String getToken(String key){
       return (String) redisService.getString(key);
    }



}
