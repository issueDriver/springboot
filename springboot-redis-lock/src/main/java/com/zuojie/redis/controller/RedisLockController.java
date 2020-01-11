package com.zuojie.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * author:zuojie
 */
@RestController
public class RedisLockController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    @RequestMapping("/deduct_stock")
    public String deductStock() throws InterruptedException{
        String clientId = UUID.randomUUID().toString();
        String lockkey="zuo";
        RLock lock = redisson.getLock(lockkey);
        try {

            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockkey, clientId);
            stringRedisTemplate.expire(lockkey,10, TimeUnit.SECONDS);
           // Boolean result = stringRedisTemplate.opsForValue().setIfAbsent();
            if(!result){
                return "error";
            }
            lock.lock(10,TimeUnit.SECONDS);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("扣减成功，剩余库存" + realStock + "");
            } else {
                System.out.println("扣减失败，库存不足");
            }

        }finally {
            /*if(clientId.equals(stringRedisTemplate.opsForValue().get(lockkey))){
                stringRedisTemplate.delete(lockkey);
            }*/
            lock.unlock();

        }




        return "end";
    }


}
