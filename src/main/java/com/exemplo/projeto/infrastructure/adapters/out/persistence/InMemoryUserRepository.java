package com.exemplo.projeto.infrastructure.adapters.out.persistence;

import com.exemplo.projeto.application.ports.out.UserRepositoryPort;
import com.exemplo.projeto.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryUserRepository implements UserRepositoryPort {

    private final Map<UUID, User> database = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        database.put(user.getId(), user);
        return user;
    }
}
