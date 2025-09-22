package org.example.DAO;

import org.example.model.User;

public interface UserDao {
    User get(String username);

    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
