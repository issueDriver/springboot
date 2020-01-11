package com.zuojie.demo;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisDemo {

    public static Jedis jedis=null;
    public static void main(String[] args) {
        jedis=new Jedis("10.211.55.8",6379);
        jedis.auth("zj123456");
        jedis.ping();
        setSet();

    }

    /**
     * 存放string类型
     */
    public static  void setString(){
        System.out.println("redis链接成功");
        jedis.set("小凡","19");
        System.out.println("存储数据成功");
    }

    public static void  setMap(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("user1","zhangsan1");
        map.put("user2","zhangsan2");
        jedis.hmset("mapkey",map);
    }

    public static void setList(){
        jedis.lpush("listKey","redis1");
        jedis.lpush("listKey","redis2");
        jedis.lpush("listKey","redis3");
    }

    public  static void setSet(){
        jedis.sadd("setKey","redis1");
        jedis.sadd("setKey","redis2");
        jedis.sadd("setKey","redis3");

    }



}
