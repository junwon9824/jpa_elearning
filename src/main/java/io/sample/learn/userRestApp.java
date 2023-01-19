package io.sample.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class userRestApp {

    public static void main(String[] args) {

        SpringApplication.run(userRestApp.class, args);


    }


}
