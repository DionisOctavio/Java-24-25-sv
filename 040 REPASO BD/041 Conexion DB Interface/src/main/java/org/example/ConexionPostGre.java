package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexionPostGre {
    private static Connection conn;
    private static Statement st;

    public ConexionPostGre() {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String user = "postgres";
        String password = "1";

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        properties.setProperty("ssl", "false");

        try {
            conn = DriverManager.getConnection(url, properties);
            st = conn.createStatement();
            System.out.println("✅ Conectado a la base de datos PostgreSQL.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return st;
    }
}
