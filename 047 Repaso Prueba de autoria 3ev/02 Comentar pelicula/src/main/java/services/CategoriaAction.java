package services;

import model.dao.CategoriaDAO;
import model.dao.PeliculaDAO;
import model.entities.Categoria;
import model.entities.Pelicula;
import model.factory.dbFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoriaAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadUser = "";
        String action = request.getParameter("ACTION");

        // Por si acaso el parámetro viene mal o es null:
        if (action == null || !action.contains(".")) {
            return "";
        }

        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1].toUpperCase()) {
            case "FIND_ALL":
                cadUser = findAll(request, response);
                break;
        }

        return cadUser;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO categoriaDAO = new CategoriaDAO(dbFactory.POSTGRES);
        ArrayList<Categoria> categorias = categoriaDAO.findAll(null);
        return Categoria.fromArrayToJson(categorias);
    }



}
