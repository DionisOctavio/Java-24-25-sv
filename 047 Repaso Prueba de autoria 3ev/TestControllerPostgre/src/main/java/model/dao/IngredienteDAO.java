package model.dao;

import model.entities.Ingrediente;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredienteDAO implements DAO<Ingrediente, Integer> {

    private final MotorSQL motorSql;

    public IngredienteDAO(String db) {
        this.motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Ingrediente ingrediente) {
        String sql = "INSERT INTO INGREDIENTE (nombre_ingrediente, descripcion_ingrediente, calorias_por_100g) VALUES ('"
                + ingrediente.getNombreIngrediente() + "', '"
                + ingrediente.getDescripcionIngrediente() + "', "
                + ingrediente.getCaloriasPor100g() + ")";
        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("❌ Error en add Ingrediente: " + e.getMessage());
            return 0;
        } finally {
            motorSql.disconnect();
        }
    }

    @Override
    public int delete(Integer idIngrediente) {
        String sql = "DELETE FROM INGREDIENTE WHERE id_ingrediente = " + idIngrediente;
        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("❌ Error en delete Ingrediente: " + e.getMessage());
            return 0;
        } finally {
            motorSql.disconnect();
        }
    }

    @Override
    public int update(Ingrediente ingrediente) {
        String sql = "UPDATE INGREDIENTE SET " +
                "nombre_ingrediente = '" + ingrediente.getNombreIngrediente() + "', " +
                "descripcion_ingrediente = '" + ingrediente.getDescripcionIngrediente() + "', " +
                "calorias_por_100g = " + ingrediente.getCaloriasPor100g() +
                " WHERE id_ingrediente = " + ingrediente.getIdIngrediente();
        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("❌ Error en update Ingrediente: " + e.getMessage());
            return 0;
        } finally {
            motorSql.disconnect();
        }
    }

    @Override
    public ArrayList<Ingrediente> findAll(Ingrediente filtro) {
        ArrayList<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM INGREDIENTE ORDER BY nombre_ingrediente ASC";

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setIdIngrediente(rs.getInt("id_ingrediente"));
                i.setNombreIngrediente(rs.getString("nombre_ingrediente"));
                i.setDescripcionIngrediente(rs.getString("descripcion_ingrediente"));
                i.setCaloriasPor100g(rs.getDouble("calorias_por_100g"));
                lista.add(i);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en findAll Ingredientes: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public ArrayList<Ingrediente> findByProducto(int idProducto) {
        ArrayList<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT I.* FROM INGREDIENTE I " +
                "JOIN PRODUCTO_INGREDIENTE PI ON I.id_ingrediente = PI.id_ingrediente " +
                "WHERE PI.id_producto = " + idProducto;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setIdIngrediente(rs.getInt("id_ingrediente"));
                i.setNombreIngrediente(rs.getString("nombre_ingrediente"));
                i.setDescripcionIngrediente(rs.getString("descripcion_ingrediente"));
                i.setCaloriasPor100g(rs.getDouble("calorias_por_100g"));
                lista.add(i);
            }

        } catch (Exception e) {
            System.out.println("❌ Error en findByProducto: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }
}
