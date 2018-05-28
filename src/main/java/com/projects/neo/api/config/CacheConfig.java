//package com.projects.neo.api.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * <pre>
// * ━━━━━━神兽出没━━━━━━
// * 　　　┏┓　　　┏┓
// * 　　┏┛┻━━━┛┻┓
// * 　　┃　　　　　　　┃
// * 　　┃　　　━　　　┃
// * 　　┃　┳┛　┗┳　┃
// * 　　┃　　　　　　　┃
// * 　　┃　　　┻　　　┃
// * 　　┃　　　　　　　┃
// * 　　┗━┓　　　┏━┛
// * 　　　　┃　　　┃神兽保佑, 永无BUG!
// * 　　　　┃　　　┃Code is far away from bug with the animal protecting
// * 　　　　┃　　　┗━━━┓
// * 　　　　┃　　　　　　　┣┓
// * 　　　　┃　　　　　　　┏┛
// * 　　　　┗┓┓┏━┳┓┏┛
// * 　　　　　┃┫┫　┃┫┫
// * 　　　　　┗┻┛　┗┻┛
// * ━━━━━━感觉萌萌哒━━━━━━
// * </pre>
// * <p>
// * Date: 17-6-29
// * Time: 下午5:28
// *
// * @author heroin.nee@gmail.com
// */
//@Configuration
//@EnableCaching
//public class CacheConfig extends CachingConfigurerSupport {
//
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(mapper);
//
//        template.setValueSerializer(serializer);
//        //使用StringRedisSerializer来序列化和反序列化redis的key值
//        template.setKeySerializer(new StringRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }
//}
