package services;

import com.google.gson.Gson;
import model.dao.CarritoDAO;
import model.entities.CarritoLista;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CarritoAction implements IAction {

    private final CarritoDAO dao = new CarritoDAO();
    private final Gson gson = new Gson();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String fullAction = request.getParameter("ACTION"); // Ejemplo: "CARRITO.ADD", "CARRITO.LISTAR_TODOS"
        String[] parts = fullAction != null ? fullAction.split("\\.") : new String[0];
        String operacion = (parts.length > 1) ? parts[1].toLowerCase() : "";

        String result = "";

        try {
            // Solo algunas operaciones requieren idUsuario
            int idUsuario = -1;
            if (operacion.equals("add") || operacion.equals("delete") || operacion.equals("update_cantidad")
                    || operacion.equals("view") || operacion.equals("finalize")) {
                idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            }

            switch (operacion) {
                case "add" -> {
                    int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    dao.agregarProductoACarrito(idUsuario, idProducto, cantidad);
                    result = "Producto agregado";
                }
                case "delete" -> {
                    int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    dao.eliminarProductoDeCarrito(idUsuario, idProducto);
                    result = "Producto eliminado";
                }
                case "update_cantidad" -> {
                    int idProducto = Integer.parseInt(request.getParameter("idProducto"));
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    dao.actualizarCantidad(idUsuario, idProducto, cantidad);
                    result = "{\"success\": true}";
                }
                case "view" -> {
                    List<CarritoLista> carrito = dao.obtenerCarrito(idUsuario);
                    try {
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(gson.toJson(carrito));
                        return null;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "Error al responder JSON";
                    }
                }
                case "listar_todos" -> {
                    // Listar todos los carritos con datos de usuario y fecha para administración
                    List<Map<String, Object>> carritos = dao.listarTodosCarritos();
                    return gson.toJson(carritos);
                }
                case "detalle" -> {
                    // Obtener detalle de un carrito específico (productos dentro)
                    int idCarrito = Integer.parseInt(request.getParameter("idCarrito"));
                    List<CarritoLista> productos = dao.obtenerProductosPorCarrito(idCarrito);
                    return gson.toJson(productos);
                }
                case "finalize" -> {
                    dao.finalizarCompra(idUsuario);
                    result = "Compra finalizada";
                }
                default -> result = "Operación no reconocida: " + operacion;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "Error en parámetros o ejecución: " + e.getMessage();
        }

        return result;
    }
}
