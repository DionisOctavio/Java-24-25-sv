package model.dao;

import model.entities.Comentario;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.util.ArrayList;

public class ComentarioDAO implements DAO<Comentario, Integer> {

    private MotorSQL motorSql;

    public ComentarioDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    @Override
    public int add(Comentario bean) {
        int result = 0;
        try {
            Comentario comentario = (Comentario) bean;
            motorSql.connect();

            String sql = "INSERT INTO COMENTARIO (texto, id_usuario, id_pelicula) VALUES ("
                    + "'" + comentario.getComentario().replace("'", "''") + "', "
                    + comentario.getId_usuario() + ", "
                    + comentario.getId_pelicula() + ")";

            result = motorSql.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            motorSql.disconnect();
        }
        return result;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Comentario bean) {
        return 0;
    }

    @Override
    public ArrayList<Comentario> findAll(Comentario bean) {
        return null;
    }
}
