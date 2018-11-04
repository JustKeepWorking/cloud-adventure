package com.nduyhai.cloudadventure.greetingservice;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import com.nduyhai.cloudadventure.greetingservice.service.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GreetingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner init(GreetingService service) {

        return args -> {
            Greeting greeting = new Greeting();
            greeting.setQuote("Happy Easter.");
            service.create(greeting);

            greeting.setId(null);
            greeting.setQuote("Get well soon.");
            service.create(greeting);

            greeting.setId(null);
            greeting.setQuote("Good morning!  How are you today?");
            service.create(greeting);


            greeting.setId(null);
            greeting.setQuote("Hello");
            service.create(greeting);
        };

    }
}
