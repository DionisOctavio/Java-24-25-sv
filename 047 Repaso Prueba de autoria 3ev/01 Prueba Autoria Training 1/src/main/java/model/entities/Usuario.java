package model.entities;

import com.google.gson.Gson;

public class Usuario {

   private String User;
   private String Password;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public static String fromObjectToJSON(Usuario usuario) {
        Gson gson = new Gson();
        return gson.toJson(usuario);
    }

}
