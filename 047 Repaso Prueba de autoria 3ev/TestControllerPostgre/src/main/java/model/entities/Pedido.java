package model.entities;

public class Pedido {
    private int id_pedido;
    private int id_usuario;
    private String fecha_pedido;
    private double total;

    // Constructor vacío
    public Pedido() {}

    // Constructor completo
    public Pedido(int id_pedido, int id_usuario, String fecha_pedido, double total) {
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
    }

    // Getters y Setters
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Pedido [id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", fecha_pedido=" + fecha_pedido + ", total=" + total + "]";
    }
}
