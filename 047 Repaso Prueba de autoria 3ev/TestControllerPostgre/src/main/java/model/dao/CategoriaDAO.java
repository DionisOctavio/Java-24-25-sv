package model.dao;

import model.entities.Categoria;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO implements DAO<Categoria, Integer> {

    private MotorSQL motorSql;

    public CategoriaDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Categoria categoria) {
        String sql = "INSERT INTO CATEGORIA (nombre_categoria, descripcion_categoria) VALUES (" +
                "'" + categoria.getNombreCategoria() + "', " +
                "'" + categoria.getDescripcionCategoria() + "')";
        int filas = 0;

        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al añadir categoría: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM CATEGORIA WHERE id_categoria = " + id;
        int filas = 0;

        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al eliminar categoría: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public int update(Categoria categoria) {
        String sql = "UPDATE CATEGORIA SET " +
                "nombre_categoria = '" + categoria.getNombreCategoria() + "', " +
                "descripcion_categoria = '" + categoria.getDescripcionCategoria() + "' " +
                "WHERE id_categoria = " + categoria.getIdCategoria();
        int filas = 0;

        try {
            motorSql.connect();
            filas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al actualizar categoría: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filas;
    }

    @Override
    public ArrayList<Categoria> findAll(Categoria filtro) {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIA";
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));
                categoria.setDescripcionCategoria(rs.getString("descripcion_categoria"));
                lista.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public boolean setCategorias(int idProducto, List<Integer> idsCategorias) {
        try {
            motorSql.connect();

            // Eliminar las categorías actuales
            motorSql.execute("DELETE FROM PRODUCTO_CATEGORIA WHERE id_producto = " + idProducto);

            // Insertar las nuevas
            for (int idCategoria : idsCategorias) {
                String sql = "INSERT INTO PRODUCTO_CATEGORIA (id_producto, id_categoria) VALUES (" +
                        idProducto + ", " + idCategoria + ")";
                motorSql.execute(sql);
            }

            return true;
        } catch (Exception e) {
            System.out.println("❌ Error en setCategorias: " + e.getMessage());
            return false;
        } finally {
            motorSql.disconnect();
        }
    }

    public ArrayList<Categoria> findCategoriasByProducto(int idProducto) {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT C.* FROM CATEGORIA C " +
                "JOIN PRODUCTO_CATEGORIA PC ON C.id_categoria = PC.id_categoria " +
                "WHERE PC.id_producto = " + idProducto;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("id_categoria"));
                c.setNombreCategoria(rs.getString("nombre_categoria"));
                c.setDescripcionCategoria(rs.getString("descripcion_categoria"));
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("❌ Error en findCategoriasByProducto: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public Categoria findById(int idCategoria) {
        Categoria categoria = null;
        String sql = "SELECT * FROM CATEGORIA WHERE id_categoria = " + idCategoria;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));
                categoria.setDescripcionCategoria(rs.getString("descripcion_categoria"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en findById de categoría: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return categoria;
    }


}
