package model.dao;

import model.entities.Producto;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements DAO<Producto, Integer> {

    private MotorSQL motorSql;

    public ProductoDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Producto producto) {
        String sql = "INSERT INTO PRODUCTO (nombre_producto, descripcion_producto, precio_producto, isDisponible, imagen_url) VALUES (" +
                "'" + producto.getNombreProducto() + "', " +
                "'" + producto.getDescripcionProducto() + "', " +
                producto.getPrecioProducto() + ", " +
                producto.isDisponible() + ", " +
                "'" + producto.getImagenUrl() + "'" +
                ")";

        int filas = 0;
        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al añadir producto: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM PRODUCTO WHERE id_producto = " + id;
        int filas = 0;

        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public int update(Producto producto) {
        String sql = "UPDATE PRODUCTO SET " +
                "nombre_producto = '" + producto.getNombreProducto() + "', " +
                "descripcion_producto = '" + producto.getDescripcionProducto() + "', " +
                "precio_producto = " + producto.getPrecioProducto() + ", " +
                "isDisponible = " + producto.isDisponible() + ", " +
                "imagen_url = '" + producto.getImagenUrl() + "' " +
                "WHERE id_producto = " + producto.getIdProducto();

        int filas = 0;

        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public ArrayList<Producto> findAll(Producto filtro) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO\n" +
                "ORDER BY precio_producto DESC;";
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);

            if (rs == null) {
                System.out.println("Error: ResultSet nulo.");
                return lista;
            }

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));

                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public ArrayList<Producto> findByCategory(String categoria) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql =    "SELECT *\n" +
                        "FROM PRODUCTO P\n" +
                        "JOIN PRODUCTO_CATEGORIA AS PC ON P.id_producto = PC.id_producto\n" +
                        "JOIN CATEGORIA AS C ON PC.id_categoria = C.id_categoria\n" +
                        "WHERE LOWER(nombre_categoria) = LOWER('" + categoria + "')";

        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                // producto.setCategoriaProducto(rs.getString("categoria_producto")); // si lo tienes en el modelo
                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al filtrar productos por categoría: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public ArrayList<Producto> searchByTextCategori(String texto) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT P.* FROM PRODUCTO P " +
                "LEFT JOIN PRODUCTO_CATEGORIA PC ON P.id_producto = PC.id_producto " +
                "LEFT JOIN CATEGORIA C ON PC.id_categoria = C.id_categoria " +
                "WHERE LOWER(P.nombre_producto) LIKE LOWER('%" + texto + "%') " +
                "OR LOWER(C.nombre_categoria) LIKE LOWER('%" + texto + "%')";

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en searchByText: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public ArrayList<Producto> orderByNombre(String direccion) {
        ArrayList<Producto> lista = new ArrayList<>();
        String dir = direccion.equalsIgnoreCase("desc") ? "DESC" : "ASC";
        String sql = "SELECT * FROM PRODUCTO ORDER BY nombre_producto " + dir;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en orderByNombre: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public ArrayList<Producto> orderByPrecio(String direccion) {
        ArrayList<Producto> lista = new ArrayList<>();
        String dir = direccion.equalsIgnoreCase("desc") ? "DESC" : "ASC";
        String sql = "SELECT * FROM PRODUCTO ORDER BY precio_producto " + dir;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error en orderByPrecio: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public Producto findById(int idProducto) {
        Producto producto = null;
        String sql = "SELECT * FROM PRODUCTO WHERE id_producto = " + idProducto;
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);

            if (rs != null && rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setDescripcionProducto(rs.getString("descripcion_producto"));
                producto.setPrecioProducto(rs.getDouble("precio_producto"));
                producto.setDisponible(rs.getBoolean("isDisponible"));
                producto.setImagenUrl(rs.getString("imagen_url"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en findById: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return producto;
    }

    public boolean setIngredientes(int idProducto, List<Integer> idsIngredientes) {
        try {
            motorSql.connect();

            // Eliminar los ingredientes actuales
            motorSql.execute("DELETE FROM PRODUCTO_INGREDIENTE WHERE id_producto = " + idProducto);

            // Insertar los nuevos
            for (int idIngrediente : idsIngredientes) {
                String sql = "INSERT INTO PRODUCTO_INGREDIENTE (id_producto, id_ingrediente) VALUES (" +
                        idProducto + ", " + idIngrediente + ")";
                motorSql.execute(sql);
            }

            return true;
        } catch (Exception e) {
            System.out.println("❌ Error en setIngredientes: " + e.getMessage());
            return false;
        } finally {
            motorSql.disconnect();
        }
    }


}
