package postgre;

public interface DAO {

    // Método para agregar una película a la base de datos
    void add(Pelicula pelicula);

    // Método para eliminar una película de la base de datos
    void delete(int id);

    // Método para actualizar una película existente en la base de datos
    void update(Pelicula pelicula);

    // Método para buscar una película por su ID
    Pelicula find(int id);

    // Método para listar todas las películas de la base de datos
    void findAll();

}
