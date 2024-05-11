package dev.durgesh.Splitwise.service;

import dev.durgesh.Splitwise.entity.User;

public interface UserService {
    User signup(String name, String email, String password);
}
