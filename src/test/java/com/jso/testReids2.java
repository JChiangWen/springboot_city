package com.jso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class testReids2 {
    @Autowired
    //private RedisTemplate redisTemplate;              //需要写配置类
    private StringRedisTemplate stringRedisTemplate;    //自带配置

    @Test
    public void testValue(){
        /*不绑定的方式*/
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        /*设置键值*/
        stringStringValueOperations.set("test1","测试用例1");
        String test1 = stringStringValueOperations.get("test1");
        System.out.println("test1 = " + test1);
    }
}
