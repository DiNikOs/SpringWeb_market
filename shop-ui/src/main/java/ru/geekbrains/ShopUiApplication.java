package ru.geekbrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class ShopUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopUiApplication.class, args);
    }

}

