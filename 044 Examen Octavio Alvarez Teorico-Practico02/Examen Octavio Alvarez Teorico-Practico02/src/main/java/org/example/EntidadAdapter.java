package org.example;

import java.util.ArrayList;

public interface EntidadAdapter extends HotelRepository {

    ArrayList<Hotel> obtenerPorCategoria(String nombre); // Metodo para Obtener un hotel por su Tipo/Categoria

    @Override
    default void insertar(Hotel hotel) {

    }

    @Override
    default ArrayList<Hotel> obtenerTodas() {
        return null;
    }

    @Override
    default Hotel ordenarPorId(int id) {
        return null;
    }

    @Override
    default void actualizar(Hotel hotel) {

    }

    @Override
    default void eliminar(int id) {

    }
}
