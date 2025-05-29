package services;

import model.dao.PeliculaDAO;
import model.entities.Pelicula;
import model.factory.dbFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class PeliculaAction implements Action {


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
            case "FIND_BY_CATEGORY":
                cadUser = getPeliculaByCategoria(request, response);
                break;
            case "FIND_BY_TITLE":
                cadUser = getPeliculaByTitulo(request, response);
                break;
            case "ADD":
                cadUser = addPelicula(request, response);
                break;
        }

        return cadUser;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        PeliculaDAO peliculaDAO = new PeliculaDAO(dbFactory.POSTGRES);
        ArrayList<Pelicula> peliculas = peliculaDAO.findAll(null);
        return Pelicula.toArrayJSon(peliculas);
    }

    public String getPeliculaByCategoria(HttpServletRequest request, HttpServletResponse response) {
        PeliculaDAO peliculaDAO = new PeliculaDAO(dbFactory.POSTGRES);
        String param = request.getParameter("CATEGORY");
        if (param == null || param.isEmpty()) {
            return "[]";
        }
        try {
            int idCategoria = Integer.parseInt(param);
            ArrayList<Pelicula> peliculas = peliculaDAO.findAllByCategory(idCategoria);
            return Pelicula.toArrayJSon(peliculas);
        } catch (NumberFormatException e) {
            return "[]";
        }
    }

    public String getPeliculaByTitulo(HttpServletRequest request, HttpServletResponse response) {
        PeliculaDAO peliculaDAO = new PeliculaDAO(dbFactory.POSTGRES);
        String titulo = request.getParameter("TITULO");
        ArrayList<Pelicula> peliculas = peliculaDAO.findAllByTitle(titulo);
        return Pelicula.toArrayJSon(peliculas);
    }

    public String addPelicula(HttpServletRequest request, HttpServletResponse response) {
        try {
            String titulo = request.getParameter("TITULO");
            int anio = Integer.parseInt(request.getParameter("ANIO"));
            int idCat = Integer.parseInt(request.getParameter("ID_CATEGORIA"));

            if (titulo == null || titulo.isEmpty())
                return "{\"success\":false,\"message\":\"Faltan datos.\"}";

            Pelicula p = new Pelicula();
            p.setTitulo(titulo);
            p.setAnio(anio);
            p.setId_categoria(idCat);

            return new PeliculaDAO(dbFactory.POSTGRES).add(p) > 0
                    ? "{\"success\":true,\"message\":\"Película añadida.\"}"
                    : "{\"success\":false,\"message\":\"Error al añadir.\"}";

        } catch (Exception e) {
            return "{\"success\":false,\"message\":\"Datos inválidos.\"}";
        }
    }
}
