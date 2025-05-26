package model.entities;

public class Valoracion {

    private int idValoracion;
    private int idUsuario;
    private int idProducto;
    private int puntuacion;
    private String comentario;

    public Valoracion() {
    }

    public Valoracion(int idValoracion, int idUsuario, int idProducto, int puntuacion, String comentario) {
        this.idValoracion = idValoracion;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    // Getters y Setters

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Valoracion{" +
                "idValoracion=" + idValoracion +
                ", idUsuario=" + idUsuario +
                ", idProducto=" + idProducto +
                ", puntuacion=" + puntuacion +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
