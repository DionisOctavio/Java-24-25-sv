package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAO implements EntidadAdapter {

    private ArrayList <Hotel> lstHoteles;

    public HotelDAO() {
        this.lstHoteles = new ArrayList<Hotel>();
    }

    @Override
    public void insertar(Hotel hotel) {
        // Creamos nuestro QUERY a BD con nuestra consulta
        String query = "INSERT INTO hotel (nombre_hotel, director, estrellas, anio, direccion, id_tipo) VALUES (?, ?, ?, ?, ?, ?)";
        // Mediante SingeltonConexion obtenemos conexion a BD
        Connection con = SingeltonConexion.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, hotel.getNombre_hotel());
            ps.setString(2, hotel.getDirector());
            ps.setInt(3, hotel.getEstrellas());
            ps.setInt(4, hotel.getAnio());
            ps.setString(5, hotel.getDireccion());
            ps.setInt(6, hotel.getTipo().getId_tipo());
            ps.executeUpdate();

            System.out.println("Hotel Añadido corectamente" + hotel.toString());
            lstHoteles.add(hotel);
        }catch (SQLException e){
            System.out.println("Error al añadir hotel" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Hotel> obtenerTodas() {

        for ( Hotel h : lstHoteles ){
            System.out.println(h);
        }

        return lstHoteles;
    }

    @Override
    public ArrayList<Hotel> obtenerPorCategoria(String tipo) {

        ArrayList<Hotel> lstHoteles2= new ArrayList<>();



        String query =
                "SELECT id_hotel, nombre_hotel, director, estrellas, anio, direccion, T.id_tipo, T.nombre_tipo \n" +
                        "FROM hotel AS H\n" +
                        "JOIN tipo AS T ON H.id_tipo = T.id_tipo\n" +
                        "WHERE nombre_tipo LIKE ? ";

        Connection con = SingeltonConexion.getInstance().getConnection();

        String conversion = '%' + tipo + '%';
        tipo = conversion;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, tipo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    Tipo tipoObj = new Tipo(
                            rs.getInt("id_tipo"),
                            rs.getString("nombre_tipo")
                    );

                    Hotel hotel = new Hotel(
                            rs.getInt("id_hotel"),
                            rs.getString("nombre_hotel"),
                            rs.getString("director"),
                            rs.getInt("anio"),
                            rs.getInt("estrellas"),
                            rs.getString("direccion"),
                            tipoObj);

                    lstHoteles2.add(hotel);
                } else {
                    System.out.println("⚠️ No se encontró tipo que contenga: " + tipo);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar: " + e.getMessage());
        }

        for ( Hotel h : lstHoteles2 ){
            System.out.println(h);
        }


        return lstHoteles2;
    }

    @Override
    public Hotel ordenarPorId(int id) {
        Hotel hotel = null;
        String query = "SELECT * FROM hotel WHERE id_hotel = ?";
        Connection con = SingeltonConexion.getInstance().getConnection();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {


                    hotel = new Hotel(
                            rs.getInt("id_hotel"),
                            rs.getString("nombre_hotel"),
                            rs.getString("director"),
                            rs.getInt("anio"),
                            rs.getInt("estrellas"),
                            rs.getString("direccion"));

                    System.out.println(hotel);
                } else {
                    System.out.println("⚠️ No se encontró El Hotel con ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar El Hotel: " + e.getMessage());
        }


        return hotel;
    }

    @Override
    public void actualizar(Hotel hotel) {

        String query = "UPDATE hotel SET nombre_hotel = ?, director = ?, estrellas = ?, anio = ?, direccion = ? WHERE id_hotel = ?";
        Connection conn = SingeltonConexion.getInstance().getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, hotel.getNombre_hotel());
            ps.setString(2, hotel.getDirector());
            ps.setInt(3, hotel.getEstrellas());
            ps.setInt(4, hotel.getAnio());
            ps.setString(5, hotel.getDireccion());
            ps.setInt(6, hotel.getId_hotel());
            ps.executeUpdate();

            System.out.println("hotel actualizado: " + hotel.getNombre_hotel());
        } catch (SQLException e) {
            System.out.println("Error al actualizar el hotel: " + e.getMessage());
        }

    }

    @Override
    public void eliminar(int id) {

        String query = "DELETE FROM hotel WHERE id_hotel = ? ";
        Connection con = SingeltonConexion.getInstance().getConnection();
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Película eliminada con ID: " + id);
        }catch (SQLException e) {
            System.out.println("Error al Eliminar la película: " + e.getMessage());
        }

    }


}
