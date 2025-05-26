package model.dao;

import model.entities.Rol;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RolDAO {
    private final MotorSQL motorSQL = DatabaseFactory.getDatabase(DatabaseFactory.POSTGRE);

    public ArrayList<Rol> findAll() {
        ArrayList<Rol> lista = new ArrayList<>();
        try {
            motorSQL.connect();
            ResultSet rs = motorSQL.executeQuery("SELECT * FROM ROL");
            while (rs.next()) {
                Rol r = new Rol();
                r.setIdRol(rs.getInt("id_rol"));
                r.setNombreRol(rs.getString("nombre_rol"));
                lista.add(r);
            }
        } catch (Exception e) {
            System.out.println("❌ Error en findAll roles: " + e.getMessage());
        } finally {
            motorSQL.disconnect();
        }
        return lista;
    }

    public boolean insert(String nombreRol) {
        try {
            motorSQL.connect();
            String sql = "INSERT INTO ROL (nombre_rol) VALUES ('" + nombreRol + "')";
            return motorSQL.execute(sql) > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al insertar rol: " + e.getMessage());
            return false;
        } finally {
            motorSQL.disconnect();
        }
    }

    public boolean update(int idRol, String nuevoNombre) {
        try {
            motorSQL.connect();
            String sql = "UPDATE ROL SET nombre_rol = '" + nuevoNombre + "' WHERE id_rol = " + idRol;
            return motorSQL.execute(sql) > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar rol: " + e.getMessage());
            return false;
        } finally {
            motorSQL.disconnect();
        }
    }

    public boolean delete(int idRol) {
        try {
            motorSQL.connect();
            String sql = "DELETE FROM ROL WHERE id_rol = " + idRol;
            return motorSQL.execute(sql) > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar rol: " + e.getMessage());
            return false;
        } finally {
            motorSQL.disconnect();
        }
    }
}
