package model.dao;

import model.entities.Musica;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MusicaDAO implements DAO<Musica, Integer> {

    private MotorSQL motorSql;

    public MusicaDAO(String db){
        motorSql = DatabaseFactory.getDatabase(db);
    }

    public ArrayList<Musica> findBySearch(String search){
        System.out.println(search);
        ArrayList<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM MUSICA WHERE LOWER(nombre) LIKE LOWER('%" + search + "%')";
        System.out.println(sql);
        try{
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Musica musica = new Musica();
                musica.setNombre(rs.getString(2));

                musicas.add(musica);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return musicas;
    }

    @Override
    public ArrayList<Musica> findAll(Musica bean) {
        ArrayList<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM MUSICA WHERE 1=1";
        try {
            //1º)
            motorSql.connect();
            if (bean != null) {
                if (bean.getId_musica() != 0) {
                    sql += "AND ID_MUSICA='" + bean.getId_musica() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += "AND NOMBRE='" + bean.getNombre() + "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Musica musica = new Musica();

                musica.setId_musica(rs.getInt(1));
                musica.setNombre(rs.getString(2));


                musicas.add(musica);

            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return musicas;
    }

    @Override
    public int add(Musica bean) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Musica bean) {
        return 0;
    }



}
