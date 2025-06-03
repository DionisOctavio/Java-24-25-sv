package model.dao;

import model.entities.Categoria;
import model.entities.Hackaton;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class HackatonDAO implements DAO<Hackaton, Integer>{
    private static String SQL_FILTER ="SELECT h.id, h.nombre, h.descripcion, c.id, c.nombre \n" +
            "FROM hackaton h\n" +
            "INNER JOIN categoria c ON h.categoria_id = c.id\n";


    MotorSQL motorSql;
    public HackatonDAO(MotorSQL motorSql) {
        this.motorSql = motorSql;
    }
    public ArrayList<Hackaton> findAllByCateg(String category, String search) {
        ArrayList<Hackaton> hackatons = new ArrayList<>();

        String SQL_FILTRO_CATEGORIA = "WHERE UPPER(c.nombre) = UPPER('" + category + "')\n";
        String SQL_FILTRO_SEARCH = "AND UPPER(h.nombre) LIKE UPPER('%" + search +"%')";

        String sql = SQL_FILTER + SQL_FILTRO_CATEGORIA + SQL_FILTRO_SEARCH;

        System.out.println(sql);

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Hackaton hackaton = new Hackaton();

                int idHacka = rs.getInt(1);
                String nombreH = rs.getString(2);
                String descrpHa = rs.getString(3);
                int categId = rs.getInt(4);
                String nomCateg = rs.getString(5);

                hackaton.setId(idHacka);
                hackaton.setNombre(nombreH);
                hackaton.setDescripcion(descrpHa);
                hackaton.setCategoria(new Categoria(categId, nomCateg));

                hackatons.add(hackaton);
            }
        }catch(Exception e){
        }finally {
            motorSql.disconnect();
        }
        return hackatons;
    }

    @Override
    public int add(Hackaton bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Hackaton bean) {
        return 0;
    }

    @Override
    public ArrayList<Hackaton> findAll(Hackaton bean) {
        return null;
    }
}
