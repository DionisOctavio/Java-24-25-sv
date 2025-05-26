package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Direccion {
    private int idDireccion;
    private String direccion;
    private String codigoPostal;
    private String provincia;
    private String region;

    public Direccion() {}

    public Direccion(int idDireccion, String direccion, String codigoPostal, String provincia, String region) {
        this.idDireccion = idDireccion;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.region = region;
    }

    public static String fromArrayListToJson(ArrayList<Direccion> direcciones) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(direcciones);
    }

    public int getIdDireccion() { return idDireccion; }
    public void setIdDireccion(int idDireccion) { this.idDireccion = idDireccion; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}
