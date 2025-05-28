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
        int idCategoria = Integer.parseInt(request.getParameter("CATEGORIA"));
        ArrayList<Pelicula> peliculas = peliculaDAO.findAllByCategory(idCategoria);
        return Pelicula.toArrayJSon(peliculas);
    }

    public String getPeliculaByTitulo(HttpServletRequest request, HttpServletResponse response) {
        PeliculaDAO peliculaDAO = new PeliculaDAO(dbFactory.POSTGRES);
        String titulo = request.getParameter("TITULO");
        ArrayList<Pelicula> peliculas = peliculaDAO.findAllByTitle(titulo);
        return Pelicula.toArrayJSon(peliculas);
    }
}
