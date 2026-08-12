package com.exemplo.projeto.application.ports.in;

import com.exemplo.projeto.domain.model.User;

public interface CreateUserUseCase {
    User createUser(String name, String email);
}
