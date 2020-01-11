package com.zuojie.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("rawTypes")
    @Autowired
    private RedisTemplate redisTemplate;

    public void setString(String key,Object oj){
        set(key,oj,null);

    }
    public void setString(String key,Object oj,Long timeout){
        set(key,oj,timeout);

    }

    public void set(String key,Object oj,Long timeout){
        if(oj==null){
            return;
        }
        if(oj instanceof String){
            String value=(String)oj;
            stringRedisTemplate.opsForValue().set(key,value);
            if(timeout!=null) {
                stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
        }

    }
    public Object getString(String key){
       return stringRedisTemplate.opsForValue().get(key);
    }


}
