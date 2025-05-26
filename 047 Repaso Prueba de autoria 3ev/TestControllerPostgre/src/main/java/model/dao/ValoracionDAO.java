package model.dao;

import model.entities.Valoracion;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValoracionDAO {

    private MotorSQL motorSql;

    public ValoracionDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    // ✅ INSERT sin ID manual, porque id_valoracion es SERIAL
    public int add(Valoracion v) {
        String sql = "INSERT INTO VALORACION (id_usuario, id_producto, puntuacion, comentario) VALUES (" +
                v.getIdUsuario() + ", " +
                v.getIdProducto() + ", " +
                v.getPuntuacion() + ", '" +
                v.getComentario() + "')";

        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            String msg = e.getMessage();

            if (msg != null) {
                if (msg.contains("fk_id_usuario")) {
                    System.out.println("❌ Usuario no existente: " + v.getIdUsuario());
                } else if (msg.contains("fk_id_producto")) {
                    System.out.println("❌ Producto no existente: " + v.getIdProducto());
                } else if (msg.contains("usuario_producto")) {
                    System.out.println("❌ Ya existe valoración para ese usuario y producto.");
                } else {
                    System.out.println("❌ Error al insertar valoración: " + msg);
                }
            } else {
                System.out.println("❌ Error desconocido al insertar valoración.");
            }

            return -1;
        } finally {
            motorSql.disconnect();
        }
    }



    public int update(Valoracion v) {
        String sql = "UPDATE VALORACION SET puntuacion = " + v.getPuntuacion() +
                ", comentario = '" + v.getComentario() +
                "' WHERE id_usuario = " + v.getIdUsuario() +
                " AND id_producto = " + v.getIdProducto();
        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar valoración: " + e.getMessage());
            return 0;
        } finally {
            motorSql.disconnect();
        }
    }

    public int delete(int idUsuario, int idProducto) {
        String sql = "DELETE FROM VALORACION WHERE id_usuario = " + idUsuario + " AND id_producto = " + idProducto;
        try {
            motorSql.connect();
            return motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar valoración: " + e.getMessage());
            return 0;
        } finally {
            motorSql.disconnect();
        }
    }

    public Valoracion findByUsuarioAndProducto(int idUsuario, int idProducto) {
        String sql = "SELECT * FROM VALORACION WHERE id_usuario = " + idUsuario + " AND id_producto = " + idProducto;
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);
            if (rs.next()) {
                Valoracion v = new Valoracion();
                v.setIdValoracion(rs.getInt("id_valoracion"));
                v.setIdUsuario(rs.getInt("id_usuario"));
                v.setIdProducto(rs.getInt("id_producto"));
                v.setPuntuacion(rs.getInt("puntuacion"));
                v.setComentario(rs.getString("comentario"));
                return v;
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar valoración: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return null;
    }

    public double findMediaByProducto(int idProducto) {
        String sql = "SELECT AVG(puntuacion) AS media FROM VALORACION WHERE id_producto = " + idProducto;
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble("media");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al calcular media de valoraciones: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return 0;
    }
}
