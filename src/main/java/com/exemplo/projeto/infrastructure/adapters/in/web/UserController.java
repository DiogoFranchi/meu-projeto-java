package com.exemplo.projeto.infrastructure.adapters.in.web;

import com.exemplo.projeto.application.ports.in.CreateUserUseCase;
import com.exemplo.projeto.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody CreateUserRequest request) {
        return createUserUseCase.createUser(request.name(), request.email());
    }

    public record CreateUserRequest(String name, String email) {}
}
