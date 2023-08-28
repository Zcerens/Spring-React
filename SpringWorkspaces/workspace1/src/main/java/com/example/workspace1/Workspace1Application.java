package com.example.workspace1;

import com.example.workspace1.user.User;
import com.example.workspace1.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Workspace1Application {

    public static void main(String[] args) {

        SpringApplication.run(Workspace1Application.class, args);
        System.out.println("Hello");
    }

    @Bean
    CommandLineRunner createInitialUsers(UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setUsername("Zcs1");
                user.setDisplayName("Ceren");
                user.setPassword("P4ssword");
                userService.save(user);


            }
        };

    }
}
