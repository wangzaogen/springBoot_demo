package com.example.demo.controller;

import com.example.demo.util.RedisLockUtils;
import com.example.demo.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisLockUtils redisLockUtils;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/redisTest/{key}/{value}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String redisTest(@PathVariable("key") String key, @PathVariable("value") String value) {
        log.info("redis key={}, value={}", key, value);
        redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
        String myKey = redisTemplate.opsForValue().get(key).toString();
        return myKey;
    }

    @RequestMapping(value = "/repeat/{key}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String repeatRequest(@PathVariable("key") String key) {
        if (!redisLockUtils.getLock(key, "1")) {
            log.warn("repeat request !!!");
            log.warn(" after 10s try again.");
            return "repeat request";
        }
        log.info("request success!");
        return "success";
    }

    @RequestMapping(value = "/check/{key}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String checkKey(@PathVariable("key") String key) {
        if (redisUtil.hasKey(key)) {
            return "exist";
        } else {
            return "no exist";
        }
    }


}