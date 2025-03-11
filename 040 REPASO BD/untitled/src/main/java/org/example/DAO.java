package org.example;

public interface DAO {

    void add(Pelicula pelicula);
    void delete(int id);
    void update(Pelicula pelicula);
    void find(int id);
    void findAll();

}
