package com.exemplo.projeto.application.ports.out;

import com.exemplo.projeto.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
}
