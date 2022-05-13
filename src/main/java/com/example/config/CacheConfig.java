package com.example.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author: wangY
 * @date: 2021/11/17
 * @description:
 */
@Configuration
@Slf4j
public class CacheConfig {

    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(100)
                //移除监听器，当缓存数据被回收时候，会监听到
                .removalListener(((key,value,cause)->{
                    System.out.println("key:"+key+",value:"+value+",cause:"+cause);
                    log.info("key:"+key+",value:"+value+",cause:"+cause);
                }))
                // 缓存的最大条数
                .maximumSize(1000)
                .build();
    }
}
