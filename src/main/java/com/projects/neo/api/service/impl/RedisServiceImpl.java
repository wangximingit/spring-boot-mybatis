//package com.projects.neo.api.service.impl;
//
//import com.projects.neo.api.service.RedisService;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * __
// * ,-~¨^  ^¨-,           _,
// * /          / ;^-._...,¨/
// * /          / /         /
// * /          / /         /
// * /          / /         /
// * /,.-:''-,_ / /         /
// * _,.-:--._ ^ ^:-._ __../
// * /^         / /¨:.._¨__.;
// * /          / /      ^  /
// * /          / /         /
// * /          / /         /
// * /_,.--:^-._/ /         /
// * ^            ^¨¨-.___.:^
// *
// * @author WangXiMin
// * @date 2018/5/17 14:30
// */
//@Service
//public class RedisServiceImpl implements RedisService{
//
//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;
//
//    public void set(String key, Object value) {
//        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
//        vo.set(key, value);
//    }
//    public Object get(String key) {
//        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
//        return vo.get(key);
//    }
//}
