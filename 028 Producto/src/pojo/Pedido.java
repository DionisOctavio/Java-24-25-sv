package pojo;

public class Pedido {
    private int numProductos;

    private Producto[] lstProductos;


    private int contador = 0;

    public Pedido(int numProductos) {
        this.numProductos = numProductos;
        lstProductos = new Producto[numProductos];
    }

    // Getter and setter
    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (contador<numProductos) {
            this.lstProductos[contador] = producto;
            contador++;
        }else {
            System.out.println();
        }
    }

    public void imprimirTicket() {
        System.out.println("SU TICKET DIGITAL");
        System.out.println("Fecha: 14/01/2025");
        System.out.println("   HORA: 12:11   ");
        for (int i = 0; i < lstProductos.length; i++) {
                Producto producto = lstProductos[i];
                if (producto!=null) {
                    System.out.println(producto.getDescripcion() + producto.getPrecio() + producto.getCantidad());
                }else {
                    System.out.println("HAS LLEGADO AL FINAL DE LA LISTA");
                    break;
                }

        }
    }

    // to string
    @Override
    public String toString() {
        return "Pedido{" +
                "numProductos=" + numProductos +
                '}';
    }
}
