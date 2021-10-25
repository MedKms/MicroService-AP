package com.sid.eurokodiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurokoDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurokoDiscoveryApplication.class, args);
    }

}
