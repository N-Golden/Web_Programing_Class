package org.example.DAO;

import org.example.model.User;

public interface UserDao {
    User get(String username, String password);

    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username, String password);
    boolean checkExistPhone(String phone);
}
