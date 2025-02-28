package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    private static Connection conn;
    private static Statement st;

    public static final String URLPostgre = "jdbc:postgresql://disney.cno6yck6ypip.us-east-1.rds.amazonaws.com/postgres";
    public static final String USERPostgre = "postgres";
    public static final String PASSPostgre = "Ken131014";

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
            String query = "SELECT id_pelicula, titulo, anyo, d.nombre_demografia, g.nombre_genero, pg.edad " +
                    "FROM pelicula p " +
                    "JOIN demografia AS d ON p.id_demografia = d.id_demografia " +
                    "JOIN genero AS g ON p.id_genero = g.id_genero " +
                    "JOIN pegi AS pg ON p.id_pegi = pg.id_pegi;";


            ResultSet rs = st.executeQuery(query);

            Genero Animación = new Genero(1, "Animación");

            // 📌 Procesar los resultados
            while (rs.next()) {
                int id = rs.getInt("id_pelicula");
                String titulo = rs.getString("titulo");
                int anyo = rs.getInt("anyo");
                String demografia = rs.getString("nombre_demografia");
                String genero = rs.getString("nombre_genero");
                int pegi = rs.getInt("edad");

                // 📌 Crear el objeto Pelicula y agregarlo a la lista
                Pelicula pelicula = new Pelicula(id, titulo, anyo, demografia, genero, pegi);
                peliculas.add(pelicula);

                if(genero.equals("Animación")){
                    Animación.agregarPelicula(pelicula);
                }
            }
            // 📌 Mostrar los resultados almacenados en el ArrayList
            System.out.println("\n🎬 Lista de Películas con Géneros:");
            for (Pelicula p : peliculas) {
                System.out.println(p);
            }
            System.out.println("***************");
            Animación.getLstPeliculasGenero();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}