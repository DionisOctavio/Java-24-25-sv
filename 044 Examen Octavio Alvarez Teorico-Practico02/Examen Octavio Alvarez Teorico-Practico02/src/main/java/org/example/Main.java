package org.example;

public class Main {
    public static void main(String[] args) {

        SingeltonConexion.getInstance();

        HotelDAO hdao = new HotelDAO();

        Hotel alfonso = new Hotel(1, "Alfonso I", "Jose luis Perez", 1945, 4, "Calle Alfonso I, 1, Zaragoza", new Tipo(1, "Hotel en edificio"));

        hdao.insertar(alfonso);

        hdao.obtenerTodas();

        System.out.println("DDD");
        hdao.obtenerPorCategoria("Hotel");
        System.out.println("DDD");

        Hotel espinosa = new Hotel(2, "espinosa plaza I", "esteban espinosa", 1945, 4, "Calle Alfonso I, 1, madrid", new Tipo(1, "Hotel en edificio"));

        hdao.insertar(espinosa);

        Hotel actualizar = new Hotel(2, "espinosa plaza I", "esteban espinosa", 1946, 4, "Calle Alfonso I, 1, madrid", new Tipo(1, "Hotel en edificio"));

        hdao.actualizar(actualizar);

        hdao.eliminar(2);

        hdao.ordenarPorId(1);

    }
}