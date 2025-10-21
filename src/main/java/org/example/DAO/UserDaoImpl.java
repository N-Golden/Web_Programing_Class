package org.example.DAO;

import org.example.model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class UserDaoImpl implements UserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public User get(String username, String password) {
        String sql = "SELECT * FROM test_db.User WHERE username = ? and password = ?";
        try {
            conn = DBConnect.initializeDatabase();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername((rs.getString("username")));
                user.setFullName(rs.getString("fullname"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(Integer.parseInt(rs.getString("roleid")));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO test_db.User(email, username, fullname, password, avatar, roleid,phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
        try {
            conn = DBConnect.initializeDatabase();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassword());
            ps.setString(5, null);
            ps.setInt(6, 1);
            ps.setString(7, user.getPhone());

            LocalDate today = LocalDate.now();
            Date sqlDate = Date.valueOf(today);
            ps.setDate(8, sqlDate);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "select * from test_db.User where email = ?";
        try {
            conn = DBConnect.initializeDatabase();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return duplicate;
    }

    @Override
    public boolean checkExistUsername(String username, String password) {
        boolean duplicate = false;
        String query = "select * from test_db.User where username = ? and password = ?";
        try {
            conn = DBConnect.initializeDatabase();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }
}
