package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class KeyExpiredListener extends KeyExpirationEventMessageListener {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        //获取失效key名称
        String key= new String(message.getBody(), StandardCharsets.UTF_8);
        //获取key原本的value 获取不到 是null
        Object value = redisTemplate.opsForValue().get("school");
        log.info("===========》获取失效key名称"+key);
        log.info("===========》获取失效内容"+value );
    }
}
