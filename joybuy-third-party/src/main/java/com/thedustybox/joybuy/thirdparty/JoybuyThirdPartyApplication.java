package com.thedustybox.joybuy.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class JoybuyThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoybuyThirdPartyApplication.class, args);
    }

}
