package org.example;

public class Main {
    public static void main(String[] args) {

        SingeltonConexion.getInstance();

        HotelDAO hdao = new HotelDAO();

        Hotel alfonso = new Hotel(1, "Alfonso I", "Jose luis Perez", 1945, 4, "Calle Alfonso I, 1, Zaragoza", new Tipo(1, "Hotel en edificio"));

        hdao.insertar(alfonso);

        hdao.obtenerTodas();

        hdao.obtenerPorCategoria("Hotel");

    }
}