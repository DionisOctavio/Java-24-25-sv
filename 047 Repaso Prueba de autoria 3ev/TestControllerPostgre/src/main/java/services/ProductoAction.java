package services;

import model.dao.ProductoDAO;
import model.entities.Producto;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductoAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "FIND_ALL":
                return findAll();
            case "FIND_BY_CATEGORY":
                return findByCategory(request);
            case "FIND_BY_ID":
                return findById(request);
            case "SEARCH":
                return searchByTextCategori(request);
            case "ORDER_BY_NAME":
                return orderByName(request);
            case "ORDER_BY_PRICE":
                return orderByPrice(request);
            case "ADD":
                return add(request);
            case "DELETE":
                return delete(request);
            case "UPDATE":
                return update(request);
            case "SET_INGREDIENTES":
                return setIngredientes(request);
            case "SET_CATEGORIAS":
                return setCategorias(request);
            default:
                return "{\"error\": \"Acción no válida para PRODUCTO\"}";
        }
    }

    private String findAll() {
        try {
            ProductoDAO productoDAO = new ProductoDAO(DatabaseFactory.POSTGRE);
            ArrayList<Producto> productos = productoDAO.findAll(null);
            return Producto.fromArrayListToJson(productos);
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String findByCategory(HttpServletRequest request) {
        String categoria = request.getParameter("CATEGORIA");
        ArrayList<Producto> productos = new ArrayList<>();

        try {
            ProductoDAO productoDAO = new ProductoDAO(DatabaseFactory.POSTGRE);
            productos = productoDAO.findByCategory(categoria);
        } catch (Exception e) {
            return "{\"error\": \"Error interno al filtrar productos: " + e.getMessage().replace("\"", "'") + "\"}";
        }

        return Producto.fromArrayListToJson(productos);
    }

    private String findById(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            Producto producto = dao.findById(id);
            if (producto != null) {
                return producto.toJson();
            } else {
                return "{}";
            }
        } catch (Exception e) {
            return "{\"error\": \"Error al obtener producto por ID: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }


    private String searchByTextCategori(HttpServletRequest request) {
        String texto = request.getParameter("TEXTO");
        try {
            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            ArrayList<Producto> lista = dao.searchByTextCategori(texto);
            return Producto.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error en búsqueda: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String orderByName(HttpServletRequest request) {
        String dir = request.getParameter("DIRECCION");
        try {
            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            ArrayList<Producto> lista = dao.orderByNombre(dir);
            return Producto.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error al ordenar por nombre: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String orderByPrice(HttpServletRequest request) {
        String dir = request.getParameter("DIRECCION");
        try {
            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            ArrayList<Producto> lista = dao.orderByPrecio(dir);
            return Producto.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error al ordenar por precio: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String add(HttpServletRequest request) {
        try {
            Producto producto = new Producto();
            producto.setNombreProducto(request.getParameter("NOMBRE"));
            producto.setDescripcionProducto(request.getParameter("DESCRIPCION"));
            producto.setPrecioProducto(Double.parseDouble(request.getParameter("PRECIO")));
            producto.setDisponible(Boolean.parseBoolean(request.getParameter("DISPONIBLE")));
            producto.setImagenUrl(request.getParameter("IMAGEN"));

            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            int filas = dao.add(producto);
            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo añadir el producto\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error al añadir producto: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String delete(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            int filas = dao.delete(id);
            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo eliminar el producto\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error al eliminar producto: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String update(HttpServletRequest request) {
        try {
            Producto producto = new Producto();
            producto.setIdProducto(Integer.parseInt(request.getParameter("ID_PRODUCTO")));
            producto.setNombreProducto(request.getParameter("NOMBRE"));
            producto.setDescripcionProducto(request.getParameter("DESCRIPCION"));
            producto.setPrecioProducto(Double.parseDouble(request.getParameter("PRECIO")));
            producto.setDisponible(Boolean.parseBoolean(request.getParameter("DISPONIBLE")));
            producto.setImagenUrl(request.getParameter("IMAGEN"));

            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            int filas = dao.update(producto);
            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo actualizar el producto\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error al actualizar producto: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String setIngredientes(HttpServletRequest request) {
        try {
            int idProducto = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            String ids = request.getParameter("IDS_INGREDIENTES"); // separados por coma
            List<Integer> ingredientes = Arrays.stream(ids.split(","))
                    .map(Integer::parseInt)
                    .toList();

            ProductoDAO dao = new ProductoDAO(DatabaseFactory.POSTGRE);
            boolean ok = dao.setIngredientes(idProducto, ingredientes);
            return ok ? "{\"success\": true}" : "{\"error\": \"No se pudieron asignar los ingredientes\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error en setIngredientes: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String setCategorias(HttpServletRequest request) {
        try {
            int idProducto = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            String ids = request.getParameter("IDS_CATEGORIAS"); // separados por coma
            List<Integer> categorias = Arrays.stream(ids.split(","))
                    .map(Integer::parseInt)
                    .toList();

            model.dao.CategoriaDAO dao = new model.dao.CategoriaDAO(DatabaseFactory.POSTGRE);
            boolean ok = dao.setCategorias(idProducto, categorias);
            return ok ? "{\"success\": true}" : "{\"error\": \"No se pudieron asignar las categorías\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error en setCategorias: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

}
