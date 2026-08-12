package com.exemplo.projeto.application.services;

import com.exemplo.projeto.application.ports.in.CreateUserUseCase;
import com.exemplo.projeto.application.ports.out.UserRepositoryPort;
import com.exemplo.projeto.domain.model.User;

import java.util.UUID;

public class UserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(String name, String email) {
        User user = new User(UUID.randomUUID(), name, email);
        return userRepositoryPort.save(user);
    }
}
