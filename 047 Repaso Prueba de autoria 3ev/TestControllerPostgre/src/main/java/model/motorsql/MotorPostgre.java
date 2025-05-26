package model.motorsql;

import java.sql.*;
import java.util.Properties;

public class MotorPostgre implements MotorSQL {

    private Properties properties;
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    private static final String URL = "jdbc:postgresql://burger.cj2d6ysbhuq6.us-east-1.rds.amazonaws.com/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "Ken131014";
    private static final String DRIVER = "org.postgresql.Driver";

    public MotorPostgre() {
        this.properties = new Properties();
        this.properties.setProperty("user", USER);
        this.properties.setProperty("password", PASS);
        this.properties.setProperty("ssl", "false");
    }

    public void connect() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, properties);
            st = conn.createStatement();
            System.out.println("✅ Connected to PostgreSQL");
        } catch (ClassNotFoundException ex) {
            System.out.println("❌ Driver not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("❌ SQL Exception en connect(): " + ex.getMessage());
            conn = null;
            st = null;
        }
    }

    @Override
    public void disconnect() {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.out.println("❌ Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    @Override
    public int execute(String sql) {
        int result = 0;
        try {
            if (conn == null) throw new SQLException("Conexión nula. ¿Se ha llamado a connect()?");
            if (st == null) st = conn.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("❌ Error SQL en execute(): " + ex.getMessage());
        }
        return result;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try {
            if (conn == null) throw new SQLException("Conexión nula. ¿Se ha llamado a connect()?");
            if (st == null) st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("❌ Error SQL en executeQuery(): " + ex.getMessage());
            System.out.println("🔍 Consulta fallida: " + sql);
        }
        return rs;
    }
}
