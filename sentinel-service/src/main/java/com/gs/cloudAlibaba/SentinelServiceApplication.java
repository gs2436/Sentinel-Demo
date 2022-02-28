package com.gs.cloudAlibaba;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
@AllArgsConstructor
@EnableDiscoveryClient
public class SentinelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);
    }

}
