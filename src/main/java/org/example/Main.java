package org.example;

import org.example.DAO.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnect.initializeDatabase();
        System.out.println(connection);
    }
}