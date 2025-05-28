package model.dao;

import model.entities.Usuario;
import model.factory.dbFactory;
import model.motorsql.MotorSQL;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO{

    private MotorSQL motorSQL;

    public UsuarioDAO(String db) {
        motorSQL = dbFactory.getDataBase(db);
    }

    public Usuario login(String user, String password){

        String sql = "SELECT username, PASSWORD FROM USUARIO WHERE username = '" + user + "' AND PASSWORD = '" + password + "'";

        this.motorSQL.connect();
        ResultSet resultSet = this.motorSQL.executeQuery(sql);

        try{

            if(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setUsername(resultSet.getString("username"));
                usuario.setPassword(resultSet.getString("PASSWORD"));
                return usuario;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.motorSQL.disconnect();
        }
        return null;
    }
/*
    @Override
    public int add(Object bean) {
        return 0;
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
    }*/
}
