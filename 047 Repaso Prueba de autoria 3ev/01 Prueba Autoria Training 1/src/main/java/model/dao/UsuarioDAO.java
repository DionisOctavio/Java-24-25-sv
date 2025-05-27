package model.dao;

import model.entities.Usuario;
import model.factory.dbFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

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
               usuario.setUser(resultSet.getString("username"));
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


}