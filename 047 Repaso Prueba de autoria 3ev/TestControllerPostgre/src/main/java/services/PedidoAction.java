package services;

import com.google.gson.Gson;
import model.dao.PedidoDAO;
import model.entities.CarritoLista;
import model.entities.Pedido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PedidoAction implements IAction {

    private final PedidoDAO pedidoDAO = new PedidoDAO();
    private final Gson gson = new Gson();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION");
        if (action == null) action = request.getParameter("action");

        System.out.println("🔍 Acción recibida en PedidoAction: " + action);

        if (action == null || !action.contains(".")) {
            return "{\"error\": \"Parámetro ACTION incorrecto o ausente (ej: PEDIDO.LISTAR)\"}";
        }

        String[] parts = action.split("\\.");
        String operacion = parts[1].toUpperCase();

        try {
            return switch (operacion) {
                case "LISTAR" -> listarPedidosPorUsuario(request);
                case "INFORMACION" -> obtenerInfoPedido(request);
                case "DETALLE" -> obtenerDetallePedido(request);
                case "LISTAR_TODOS" -> listarTodosPedidos(request);
                case "INFORMACION_ADMIN" -> obtenerInfoPedidoAdmin(request);
                case "DETALLE_ADMIN" -> obtenerDetallePedidoAdmin(request);
                default -> "{\"error\": \"Acción no válida para PEDIDO: " + operacion + "\"}";
            };
        } catch (Exception e) {
            return errorJson("Error interno en PedidoAction", e);
        }
    }

    // Nuevo: lista TODOS los pedidos sin filtro por usuario
    private String listarTodosPedidos(HttpServletRequest request) {
        try {
            List<CarritoLista> pedidos = pedidoDAO.obtenerTodosPedidos();
            return gson.toJson(pedidos);
        } catch (Exception e) {
            return errorJson("Error al listar todos los pedidos", e);
        }
    }

    // Nuevo: obtiene resumen pedido sin filtro usuario
    private String obtenerInfoPedidoAdmin(HttpServletRequest request) {
        try {
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            Map<String, Object> info = pedidoDAO.getPedidoInfoExtendidoAdmin(idPedido);
            if (info == null) {
                return "{\"error\": \"Pedido no encontrado\"}";
            }
            return gson.toJson(info);
        } catch (Exception e) {
            return errorJson("Error al obtener info del pedido admin", e);
        }
    }

    // Nuevo: obtiene detalle pedido sin filtro usuario
    private String obtenerDetallePedidoAdmin(HttpServletRequest request) {
        try {
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            List<CarritoLista> productos = pedidoDAO.getProductosByPedido(idPedido);
            return gson.toJson(productos);
        } catch (Exception e) {
            return errorJson("Error al obtener detalle del pedido admin", e);
        }
    }

    private String listarPedidosPorUsuario(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            List<CarritoLista> pedidos = pedidoDAO.obtenerPedidosPorUsuario(idUsuario);
            return gson.toJson(pedidos);
        } catch (Exception e) {
            return errorJson("Error al listar pedidos", e);
        }
    }

    private String obtenerInfoPedido(HttpServletRequest request) {
        try {
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            Map<String, Object> info = pedidoDAO.getPedidoInfoExtendido(idPedido, idUsuario);
            if (info == null) {
                return "{\"error\": \"Pedido no encontrado o no pertenece al usuario\"}";
            }

            return gson.toJson(info);
        } catch (Exception e) {
            return errorJson("Error al obtener información extendida del pedido", e);
        }
    }



    private String obtenerDetallePedido(HttpServletRequest request) {
        try {
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            List<CarritoLista> productos = pedidoDAO.getProductosByPedido(idPedido);
            return gson.toJson(productos);
        } catch (Exception e) {
            return errorJson("Error al obtener productos del pedido", e);
        }
    }

    private String errorJson(String mensaje, Exception e) {
        return "{\"error\": \"" + mensaje + ": " + e.getMessage().replace("\"", "'") + "\"}";
    }
}
