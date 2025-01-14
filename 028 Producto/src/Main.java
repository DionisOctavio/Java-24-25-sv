import pojo.Almacen;
import pojo.Pedido;
import pojo.Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Producto magdalena = new Producto ("Magdalenas de chocolate", 1.50, 10);
        Producto croasan = new Producto ("croasan de chocolate", 1.50, 10);
        Producto donut = new Producto ("Donut de chocolate", 1.50, 10);


        magdalena.setCantidad(25);

        System.out.println(magdalena.toString());
        System.out.println(croasan.toString());
        System.out.println(donut.toString());

        Pedido pedido = new Pedido(5);
            pedido.agregarProducto(magdalena, 3);
            pedido.agregarProducto(croasan, 1);
            pedido.agregarProducto(donut, 2);

            pedido.imprimirTicket();

        Almacen almacen = new Almacen();
            almacen.agregarProductoAlInventario(new Producto("magdalen", 1.50, 10));
            almacen.agregarProductoAlInventario(new Producto("napolitana", 2.50, 20));

            almacen.mostrarInventario();

            almacen.buscarProductoPorNombre("magdalen");
    }
}