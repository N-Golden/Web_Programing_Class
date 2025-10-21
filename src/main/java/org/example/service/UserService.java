package org.example.service;

import org.example.model.User;

public interface UserService {
    User findByUsername(String username, String password);
    void insert(User user);
    boolean register(String email, String password, String username,
                     String fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username, String password);
    boolean checkExistPhone(String phone);
}
