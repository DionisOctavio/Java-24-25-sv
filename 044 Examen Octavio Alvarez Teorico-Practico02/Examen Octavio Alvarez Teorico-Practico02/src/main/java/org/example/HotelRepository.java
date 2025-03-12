package org.example;

import java.util.ArrayList;

public interface HotelRepository {

    void insertar(Hotel hotel); // Metodo para insertar un nuevo hotel
    ArrayList<Hotel> obtenerTodas(); // Metodo para obtener todos los hoteles

    ArrayList<Hotel> obtenerPorCategoria(String tipo);

    Hotel ordenarPorId(int id);

    void actualizar(Hotel hotel);

    void eliminar(int id);

}
