package postgre;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Nos Creamos una clase Singelton por que solo queremos que se cree una unica instancia de conexion
public class Singleton {

    private static volatile Singleton instance;
    private Connection connection;

    private final String URL_DB = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final String USER_DB = "postgres";
    private final String CONTRA_DB = "1234";

    // Constructor privado para evitar múltiples instancias
    private Singleton() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", USER_DB);
            properties.setProperty("password", CONTRA_DB);
            properties.setProperty("ssl", "false");

            connection = DriverManager.getConnection(URL_DB, properties);
            System.out.println("✅ Conexión con la BD establecida");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para obtener la única instancia del Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        return connection;
    }

    // 🚀 NUEVO: Método para cerrar la conexión al finalizar el programa
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔴 Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al cerrar la conexión: " + e.getMessage());
        }
    }

}
