package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Usuario {
    private int id_username;
    private String username;
    private String password;

    public Usuario() {

    }

    public int getId_username() {
        return id_username;
    }

    public void setId_username(int id_username) {
        this.id_username = id_username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String fromObjectToJSON(Usuario usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(usuario);

        return resp;
    }

}
