package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    private static Connection conn;
    private static Statement st;

    //public static final String URLPostgre = "jdbc:postgresql://netflix-001.cwj7rtbm00wq.us-east-1.rds.amazonaws.com/postgres";
    public static final String URLPostgre = "jdbc:postgresql://127.0.0.1:5432/postgres"
    public static final String USERPostgre = "postgres";
    //public static final String PASSPostgre = "LUCASLUCAS";
    public static final String PASSPostgre = "1";

    public static void connect() {
        Properties properties = new Properties();
        properties.setProperty("url", URLPostgre);
        properties.setProperty("user", USERPostgre);
        properties.setProperty("password", PASSPostgre);
        properties.setProperty("ssl", "false");
        try {
            conn = DriverManager.getConnection(URLPostgre, properties);
            if (conn != null) {
                System.out.println("Conectado a base de datos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
// 📌 Lista donde guardaremos las películas con sus géneros
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        try {
            // 🔗 Conectar a MySQL y hacer el JOIN
            connect();
            System.out.println("✅ Conexión exitosa a MySQL!");

            st = conn.createStatement();

            // 📌 Consulta con JOIN entre películas y género
            String query = "SELECT * " +
                    "FROM peliculas p";

            ResultSet rs = st.executeQuery(query);

            // 📌 Procesar los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String director = rs.getString("descripcion");
                int anio = rs.getInt("anio");

                // 📌 Crear el objeto Pelicula y agregarlo a la lista
                Pelicula pelicula = new Pelicula(id, titulo, director, anio);
                peliculas.add(pelicula);
            }
            // 📌 Mostrar los resultados almacenados en el ArrayList
            System.out.println("\n🎬 Lista de Películas con Géneros:");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
