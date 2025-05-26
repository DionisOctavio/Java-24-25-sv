package services;

import model.dao.IngredienteDAO;
import model.entities.Ingrediente;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class IngredienteAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION").split("\\.")[1];

        switch (action) {
            case "FIND_ALL":
                return findAll();
            case "FIND_BY_PRODUCTO":
                return findByProducto(request);
            case "ADD":
                return add(request);
            case "DELETE":
                return delete(request);
            case "UPDATE":
                return update(request);
            default:
                return "{\"error\": \"Acción no válida para INGREDIENTE\"}";
        }
    }

    private String findAll() {
        try {
            IngredienteDAO dao = new IngredienteDAO(DatabaseFactory.POSTGRE);
            ArrayList<Ingrediente> lista = dao.findAll(null);
            return Ingrediente.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error en findAll Ingredientes: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String findByProducto(HttpServletRequest request) {
        try {
            int idProducto = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            IngredienteDAO dao = new IngredienteDAO(DatabaseFactory.POSTGRE);
            ArrayList<Ingrediente> lista = dao.findByProducto(idProducto);
            return Ingrediente.fromArrayListToJson(lista);
        } catch (Exception e) {
            return "{\"error\": \"Error en findByProducto: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String add(HttpServletRequest request) {
        try {
            String nombre = request.getParameter("NOMBRE");
            String descripcion = request.getParameter("DESCRIPCION");
            double calorias = Double.parseDouble(request.getParameter("CALORIAS"));

            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombreIngrediente(nombre);
            ingrediente.setDescripcionIngrediente(descripcion);
            ingrediente.setCaloriasPor100g(calorias);

            IngredienteDAO dao = new IngredienteDAO(DatabaseFactory.POSTGRE);
            int filas = dao.add(ingrediente);

            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo añadir el ingrediente\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error en ADD: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String delete(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("ID_INGREDIENTE"));
            IngredienteDAO dao = new IngredienteDAO(DatabaseFactory.POSTGRE);
            int filas = dao.delete(id);

            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo eliminar el ingrediente\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error en DELETE: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String update(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("ID_INGREDIENTE"));
            String nombre = request.getParameter("NOMBRE");
            String descripcion = request.getParameter("DESCRIPCION");
            double calorias = Double.parseDouble(request.getParameter("CALORIAS"));

            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setIdIngrediente(id);
            ingrediente.setNombreIngrediente(nombre);
            ingrediente.setDescripcionIngrediente(descripcion);
            ingrediente.setCaloriasPor100g(calorias);

            IngredienteDAO dao = new IngredienteDAO(DatabaseFactory.POSTGRE);
            int filas = dao.update(ingrediente);

            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo actualizar el ingrediente\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error en UPDATE: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }
}
