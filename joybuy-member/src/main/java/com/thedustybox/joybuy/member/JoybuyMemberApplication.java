package com.thedustybox.joybuy.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.thedustybox.joybuy.member.feign")
public class JoybuyMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoybuyMemberApplication.class, args);
    }

}
