package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Usuario {

    private int idUsuario;
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String telefono;
    private int idRol;
    private String fechaNacimiento;
    private int puntos;

    // Constructor vacío (obligatorio para JDBC y Gson)
    public Usuario() {}

    // Constructor completo (opcional)
    public Usuario(int idUsuario, String correo, String contrasena, String nombre,
                   String apellido, String telefono, int idRol, String fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idRol = idRol;
        this.fechaNacimiento = fechaNacimiento;
        this.puntos = 0;
    }

    public static String fromArrayListToJson(ArrayList<Usuario> usuarios) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(usuarios);
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Metodo estático para convertir un objeto Usuario a JSON
    public static String fromObjectToJSON(Usuario usuario) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(usuario);
    }

}


