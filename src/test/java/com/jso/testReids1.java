package com.jso;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class testReids1 {
    @Autowired
    //private RedisTemplate redisTemplate;              //需要写配置类
    private StringRedisTemplate stringRedisTemplate;    //自带配置

    @Test
    public void testValue(){
        /*接收绑定 key*/
        BoundValueOperations<String, String> test2 = stringRedisTemplate.boundValueOps("test2");
        /*设置超时时间,超时就删除*/
        test2.set("测试用例2",10, TimeUnit.SECONDS);
        System.out.println("test2:" + test2.get().toString());
    }

    @Test
    public void testList(){
        /*接收绑定 list*/
        BoundListOperations<String, String> list3 = stringRedisTemplate.boundListOps("list3");
        /*push单个或两个*/
        list3.leftPush("aa");
        /*push多个*/
        list3.leftPushAll("bb","cc","dd","ff");
        System.out.println("list3: " + list3.range(0,-1));
    }

    @Test
    public void testHash(){
        /*接收绑定 hash*/
        BoundHashOperations<String, Object, Object> hash4 = stringRedisTemplate.boundHashOps("hash4");
        /*put单个*/
        hash4.put("username","jso");
        /*put 个 map*/
        Map<String,String> userMap = new HashMap<>();
        userMap.put("password","123456");
        userMap.put("age","22");
        /*put多个*/
        hash4.putAll(userMap);
        /*获取key*/
        System.out.println("hash4: " + hash4.keys().toString());
        /*获取value*/
        System.out.println("hash4: " + hash4.values().toString());
        /*获取元素*/
        System.out.println("hash4: " + hash4.entries().toString());
    }

    @Test
    public void testSet(){
        BoundSetOperations<String, String> set5 = stringRedisTemplate.boundSetOps("set5");
        set5.add("set1","set2","set3","set4","sest5","set6","set1");
        /*随机弹出*/
        String pop = set5.pop();
        System.out.println(pop);
        /*输出全部*/
        System.out.println("set5 = " + set5.members().toString());
    }

    @Test
    public void testZSet(){
        BoundZSetOperations<String, String> zset6 = stringRedisTemplate.boundZSetOps("zset6");
        zset6.add("jso",99);
        zset6.add("j",60);
        zset6.add("s",70);
        zset6.add("o",65);
        /*输出排名后的顺序*/
        System.out.println("zset6 = " + zset6.range(0,-1).toString());
        /*输出排名后的顺序带成绩*/
        System.out.println("zset6[score] = " + zset6.rangeWithScores(0,-1).stream().toArray());
    }

}
