package com.thedustybox.joybuy.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableRedisHttpSession
@EnableCaching
@EnableFeignClients(basePackages = "com.thedustybox.joybuy.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.thedustybox.Joybuy.product.dao")
public class JoybuyProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoybuyProductApplication.class, args);
    }

}
