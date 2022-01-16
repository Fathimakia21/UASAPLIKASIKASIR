/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umtas.uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class DatabaseManager {

    private Connection connection;
    private Statement statement;

    public Statement createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/kasir", "root", "root123");
            statement = connection.createStatement();
            return statement;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement statement = createConnection();
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
    }

    public List<Map<String, Object>> select(String sql, String[] columns) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Statement statement = createConnection();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Map<String, Object> m = new HashMap<String, Object>();
                for (String c : columns) {
                    m.put(c, rs.getObject(c));
                }
                list.add(m);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeConnection();
        }
        return list;
    }
}
