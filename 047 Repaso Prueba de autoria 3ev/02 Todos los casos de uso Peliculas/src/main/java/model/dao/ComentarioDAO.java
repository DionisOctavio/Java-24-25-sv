package model.dao;

import model.entities.Comentario;
import model.factory.dbFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ComentarioDAO implements DAO{

    private MotorSQL motorSQL;

    public ComentarioDAO(String db) {
        motorSQL = dbFactory.getDataBase(db);
    }

    @Override
    public int add(Object bean) {
        int result = 0;
        try {
            Comentario comentario = (Comentario) bean;
            motorSQL.connect();

            String sql = "INSERT INTO COMENTARIO (texto, id_usuario, id_pelicula) VALUES ("
                    + "'" + comentario.getTexto().replace("'", "''") + "', "
                    + comentario.getId_usuario() + ", "
                    + comentario.getId_pelicula() + ")";

            result = motorSQL.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            motorSQL.disconnect();
        }
        return result;
    }


    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Object bean) {
        return 0;
    }

    @Override
    public ArrayList findAll(Object bean) {
        return null;
    }
}
