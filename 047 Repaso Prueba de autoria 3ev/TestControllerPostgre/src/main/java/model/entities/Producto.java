package model.entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioProducto;
    private boolean isDisponible;
    private String imagenUrl;

    // Constructor vacío (obligatorio para JDBC y Gson)
    public Producto() {}

    // Constructor completo
    public Producto(int idProducto, String nombreProducto, String descripcionProducto,
                    double precioProducto, boolean isDisponible, String imagenUrl) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.isDisponible = isDisponible;
        this.imagenUrl = imagenUrl;
    }

    // Metodo estático para convertir lista de productos a JSON
    public static String fromArrayListToJson(ArrayList<Producto> productos) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(productos);
    }

    // Metodo estático para convertir un producto a JSON
    public static String fromObjectToJSON(Producto producto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(producto);
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String toJson() {
        return "{" +
                "\"idProducto\": " + idProducto + "," +
                "\"nombreProducto\": \"" + nombreProducto + "\"," +
                "\"descripcionProducto\": \"" + descripcionProducto + "\"," +
                "\"precioProducto\": " + precioProducto + "," +
                "\"isDisponible\": " + isDisponible + "," +
                "\"imagenUrl\": \"" + imagenUrl + "\"" +
                "}";
    }

}
