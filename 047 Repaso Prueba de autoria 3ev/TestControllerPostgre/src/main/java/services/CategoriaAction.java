package services;

import model.dao.CategoriaDAO;
import model.entities.Categoria;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoriaAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String resultado = "";
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1]) {
            case "FIND_ALL":
                resultado = findAll();
                break;
            case "FIND_BY_ID":
                resultado = findById(request);
                break;
            case "ADD":
                resultado = addCategoria(request);
                break;
            case "DELETE":
                resultado = deleteCategoria(request);
                break;
            case "UPDATE":
                resultado = updateCategoria(request);
                break;
            default:
                resultado = "{\"error\": \"Acción no válida para CATEGORIA\"}";
        }

        return resultado;
    }

    private String findAll() {
        try {
            CategoriaDAO dao = new CategoriaDAO(DatabaseFactory.POSTGRE);
            ArrayList<Categoria> lista = dao.findAll(null);
            return Categoria.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error al obtener categorías: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String findById(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("ID"));
            CategoriaDAO dao = new CategoriaDAO(DatabaseFactory.POSTGRE);
            Categoria categoria = dao.findById(id);
            if (categoria != null) {
                return categoria.toJson();
            } else {
                return "{}";
            }
        } catch (Exception e) {
            return "{\"error\": \"Error al obtener categoría por ID: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }


    private String addCategoria(HttpServletRequest request) {
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        CategoriaDAO dao = new CategoriaDAO(DatabaseFactory.POSTGRE);
        int filas = dao.add(new Categoria(0, nombre, descripcion));
        return "{\"filas_afectadas\": " + filas + "}";
    }

    private String deleteCategoria(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("ID"));
        CategoriaDAO dao = new CategoriaDAO(DatabaseFactory.POSTGRE);
        int filas = dao.delete(id);
        return "{\"filas_afectadas\": " + filas + "}";
    }

    private String updateCategoria(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("ID"));
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        CategoriaDAO dao = new CategoriaDAO(DatabaseFactory.POSTGRE);
        int filas = dao.update(new Categoria(id, nombre, descripcion));
        return "{\"filas_afectadas\": " + filas + "}";
    }
}
