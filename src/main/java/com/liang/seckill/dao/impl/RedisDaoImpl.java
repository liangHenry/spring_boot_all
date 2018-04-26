package com.liang.seckill.dao.impl;

import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.liang.seckill.entity.Seckill;
import com.liang.seckill.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RedisDaoImpl {

    private static final String KEY = "seckill:";
    @Autowired
    private RedisClient redisClient;

    @Autowired
    private RedisTemplate redisTemplate;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);


    public Seckill getSeckill(long seckillId) {
        //Seckill seckill = redisClient.get(String.format(KEY, seckillId), Seckill.class);
        String key = KEY + seckillId;
        ValueOperations<Serializable, Seckill> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    public String putSeckill(Seckill seckill) {
        ValueOperations<Serializable, Seckill> operations = redisTemplate.opsForValue();
        String key = KEY + seckill.getSeckillId();
        operations.set(key, seckill);
        return "1";
    }

}
