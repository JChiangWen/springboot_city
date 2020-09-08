package com.jso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest()
public class testRedisCluster {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedisCluster(){
        redisTemplate.opsForValue().set("demo","测试");
        System.out.println(redisTemplate.opsForValue().get("demo"));
    }


}
