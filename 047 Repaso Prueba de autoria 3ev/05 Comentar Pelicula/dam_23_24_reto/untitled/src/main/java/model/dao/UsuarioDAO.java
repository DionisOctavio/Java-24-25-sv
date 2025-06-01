package model.dao;

import model.entities.Usuario;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO{

    private MotorSQL motorSql;

    public UsuarioDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    public Usuario login(String usuario, String contrasenia){
        String sql = "SELECT * FROM USUARIO WHERE usuario = '"+usuario+"' AND contrasenia='"+contrasenia+"' ";
        this.motorSql.connect();
        ResultSet rs =  this.motorSql.executeQuery(sql);
        Usuario usuarios = new Usuario();
        try {
            if(rs.next()){
                usuarios.setId_usuario(rs.getInt(1));
                usuarios.setUsuario(rs.getString(2));
                usuarios.setContrasenia(rs.getString(3));
            }else{
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.motorSql.disconnect();

        return usuarios;
    }
}
