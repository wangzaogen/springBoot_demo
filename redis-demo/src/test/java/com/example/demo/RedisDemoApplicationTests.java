package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        redisTemplate.opsForValue().set("testKey","wangzaogen");
//        System.out.println(redisTemplate.opsForValue().get("name"));
        int a = 1+3;
        assert a == 4;
    }

}
