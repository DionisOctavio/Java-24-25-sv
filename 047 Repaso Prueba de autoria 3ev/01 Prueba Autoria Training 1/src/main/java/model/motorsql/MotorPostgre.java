package model.motorsql;

import java.sql.*;
import java.util.Properties;

public class MotorPostgre implements MotorSQL{

    // Elemontos java de conexion
    private Properties properties;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    // elementos de conexion a db
    private static final String USER = "postgres";
    private static final String PASS = "1";
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DRIVER = "org.postgresql.Driver";

    public MotorPostgre() {
        properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);
        properties.setProperty("ssl", "false");
    }

    @Override
    public void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, properties);
            st = con.createStatement();
        }catch (ClassNotFoundException ex) {
            System.out.println("Driver not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception during disconnect: " + ex.getMessage());
        }
    }

    @Override
    public int execute(String sql) {
        int resp = 0;
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return resp;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        return rs;
    }
}
