package model.dao;

import model.entities.Equipo;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipoDAO implements DAO<Equipo, Integer> {

    private MotorSQL motorSql;

    public EquipoDAO(String db){
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Equipo bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Equipo bean) {
        return 0;
    }

    @Override
    public ArrayList<Equipo> findAll(Equipo bean) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM EQUIPO";
        try {
            motorSql.connect();
            if (bean != null) {
                if (bean.getId_equipo() != 0) {
                    sql += "AND ID_EQUIPO='" + bean.getId_equipo() + "'";
                }
                if (bean.getNombre_equipo() != null) {
                    sql += "AND NOMBRE='" + bean.getNombre_equipo() + "'";
                }

                if (bean.getId_categoria() != 0) {
                    sql += "AND ID_CATEGORIA='" + bean.getId_categoria() + "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Equipo equipo = new Equipo();

                equipo.setId_equipo(rs.getInt(1));
                equipo.setNombre_equipo(rs.getString(2));
                equipo.setId_categoria(rs.getInt(3));

                equipos.add(equipo);

            }
        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return equipos;
    }

    public ArrayList<Equipo> searchAndFind(String category, String search) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        String sql =  "SELECT * FROM EQUIPO E JOIN CATEGORIA C ON C.id_categoria = E.id_categoria WHERE C.nombre_categoria LIKE '%" + category+ "%' AND E.nombre_equipo LIKE '%" + search+ "%' ";
        System.out.println(sql);
        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Equipo equipo = new Equipo();
                int id_equipo = rs.getInt(1);
                String nombre_equipo = rs.getString(2);
                int id_categoria = rs.getInt(3);

                equipo.setId_equipo(id_equipo);
                equipo.setNombre_equipo(nombre_equipo);
                equipo.setId_categoria(id_categoria);
                equipos.add(equipo);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return equipos;
    }
}
