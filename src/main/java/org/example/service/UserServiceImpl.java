package org.example.service;

import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImpl;
import org.example.model.User;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User findByUsername(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        if (userDao.checkExistUsername(username, password)) {
            return false;
        }
        userDao.insert(new User(email, password, username,fullname, phone));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username, String password) {
        return userDao.checkExistUsername(username, password);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }
}
