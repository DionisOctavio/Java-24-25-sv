package model.entities;


import java.util.ArrayList;

public class Ingrediente {
    private int idIngrediente;
    private String nombreIngrediente;
    private String descripcionIngrediente;
    private double caloriasPor100g;

    // Getters y setters
    public int getIdIngrediente() { return idIngrediente; }
    public void setIdIngrediente(int id) { this.idIngrediente = id; }

    public String getNombreIngrediente() { return nombreIngrediente; }
    public void setNombreIngrediente(String nombre) { this.nombreIngrediente = nombre; }

    public String getDescripcionIngrediente() { return descripcionIngrediente; }
    public void setDescripcionIngrediente(String descripcion) { this.descripcionIngrediente = descripcion; }

    public double getCaloriasPor100g() { return caloriasPor100g; }
    public void setCaloriasPor100g(double calorias) { this.caloriasPor100g = calorias; }

    // JSON
    public static String fromArrayListToJson(ArrayList<Ingrediente> lista) {
        StringBuilder sb = new StringBuilder("[");
        for (Ingrediente i : lista) {
            sb.append(i.toJson()).append(",");
        }
        if (!lista.isEmpty()) sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public String toJson() {
        return "{" +
                "\"idIngrediente\":" + idIngrediente + "," +
                "\"nombreIngrediente\":\"" + nombreIngrediente + "\"," +
                "\"descripcionIngrediente\":\"" + descripcionIngrediente + "\"," +
                "\"caloriasPor100g\":" + caloriasPor100g +
                "}";
    }
}