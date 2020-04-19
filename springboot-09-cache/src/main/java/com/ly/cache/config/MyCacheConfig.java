package com.ly.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author liuyang
 * @date 2020/3/7 17:32
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator ketGenerator(){
        /*return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };*/
        // 以上注释使用lambda表达式
        return (o, method, objects) -> method.getName()+"["+ Arrays.asList(objects).toString()+"]";
    }

}