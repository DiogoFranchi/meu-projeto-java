package com.exemplo.projeto.infrastructure.config;

import com.exemplo.projeto.application.ports.out.UserRepositoryPort;
import com.exemplo.projeto.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }
}
