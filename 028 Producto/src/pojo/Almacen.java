package pojo;

import java.util.Arrays;

public class Almacen {
    private Producto[] lstAlmacen;
    private int contador;

    public Almacen() {
        this.lstAlmacen = new Producto[10];
        this.contador = 0;
    }


    public void agregarProductoAlInventario(Producto producto) {
        if (producto == null) {
            System.out.println("Debes agregar algo");
            return;
        }

        for (int i = 0; i < contador; i++) {
            if (lstAlmacen[i].getDescripcion().equalsIgnoreCase(producto.getDescripcion())) {
                lstAlmacen[i].setCantidad(lstAlmacen[i].getCantidad() + producto.getCantidad());
                System.out.println("Cantidad actualizada para " + producto.getDescripcion());
                return;
            }
        }

        if (contador < lstAlmacen.length) {
            lstAlmacen[contador] = producto;
            contador++;
            System.out.println("Producto agregado: " + producto.getDescripcion());
        } else {
            System.out.println("No hay espacio");
        }
    }


    public void mostrarInventario() {
        System.out.println("INVENTARIO:");
        if (contador == 0) {
            System.out.println("INVENTARIO VACIO");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(lstAlmacen[i].toString());
            }
        }
    }

    public Producto buscarProductoPorNombre(String name) {
        for (int i = 0; i < contador; i++) {
            Producto producto = lstAlmacen[i];
            if(lstAlmacen[i].getDescripcion().equalsIgnoreCase(name)) {
                return producto;
            }
        }
        return null;
    }

}
